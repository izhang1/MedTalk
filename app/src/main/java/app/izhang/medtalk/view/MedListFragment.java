package app.izhang.medtalk.view;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

import app.izhang.medtalk.R;
import app.izhang.medtalk.adapter.MedinfoCardViewAdapter;
import app.izhang.medtalk.model.MedInfo;
import app.izhang.medtalk.model.TinyDB;


/**
 * Created by ivanzhang on 5/27/17.
 *
 * FavListFragment
 * - Displays a list of all medicine and search view
 *
 */

public class MedListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String MED_INFO_KEY = "MED_INFO";

    TinyDB db;
    MedinfoCardViewAdapter adapter;
    RecyclerView medList;
    ProgressBar progress;

    ArrayList<MedInfo> medInfoList;
    ArrayList<MedInfo> searchList;
    MedinfoCardViewAdapter searchAdapter;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MedListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedListFragment newInstance(String param1, String param2) {
        MedListFragment fragment = new MedListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        db = new TinyDB(getContext());
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v("MedListFragment", "OnCreateView");
        View view = inflater.inflate(R.layout.fragment_med_list, container, false);

        // Progress Bar
        progress = (ProgressBar) view.findViewById(R.id.progressBar);

        // Inflate the layout for this fragment
        medList = (RecyclerView) view.findViewById(R.id.medList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 1);
        medList.setLayoutManager(gridLayoutManager);

        initView();

        return view;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public void initView(){
        medInfoList = new ArrayList<>();
        medInfoList = db.getListObject(MED_INFO_KEY, MedInfo.class);
        if(medInfoList.isEmpty()){
            // Check to see if the user has internet data.
            if(isNetworkAvailable()) {
                Log.v("MedListFragment", "Pulling Data");
                medList.setVisibility(View.INVISIBLE);
                pullDataFromFirebase();
            }else{
                Toast.makeText(getContext(), "Please enable Wifi or Data to download the initial medicine data.", Toast.LENGTH_LONG).show();
            }

        }else if(!isNetworkAvailable()){
            initListView();
        }else{
            initListView();
        }
    }

    public void initListView(){
        adapter = new MedinfoCardViewAdapter(medInfoList, MedListFragment.this);
        medList.setAdapter(adapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        initView();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView sv = new SearchView(((Homeactivity) getActivity()).getSupportActionBar().getThemedContext());
        sv.setBackground(getResources().getDrawable(R.drawable.ripple));
        MenuItemCompat.setShowAsAction(item, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(item, sv);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<MedInfo> searchList = new ArrayList<>();
                query = query.toLowerCase();
                for(int i = 0; i < medInfoList.size(); i++){
                    MedInfo temp = medInfoList.get(i);
                    if((temp.getGenericName().toLowerCase()).contains(query) || (temp.getTradename().toLowerCase()).contains(query)){
                        searchList.add(temp);
                    }
                }

                searchAdapter = new MedinfoCardViewAdapter(searchList, MedListFragment.this);
                medList.setAdapter(searchAdapter);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<MedInfo> searchList = new ArrayList<>();
                newText = newText.toLowerCase();

                for(int i = 0; i < medInfoList.size(); i++){
                    MedInfo temp = medInfoList.get(i);
                    if(temp != null && temp.getGenericName().toLowerCase().contains(newText) || temp.getTradename().toLowerCase().contains(newText)){
                        searchList.add(temp);
                    }
                }

                searchAdapter = new MedinfoCardViewAdapter(searchList, MedListFragment.this);
                medList.setAdapter(searchAdapter);

                return false;
            }
        });
    }

    // TODO: 8/7/17 Change this method to allow a string valye to find the data
    public void pullDataFromFirebase(){

        Log.v("MedListFragment", "Start Pulling Data");

        // Initialize main variables
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progress.setVisibility(View.VISIBLE);
                ArrayList<MedInfo> medInfos = new ArrayList<MedInfo>();
                Iterator medIterator = dataSnapshot.getChildren().iterator();
                while(medIterator.hasNext()){
                    DataSnapshot tempDataSnapshot = (DataSnapshot) medIterator.next();
                    MedInfo medInfo = tempDataSnapshot.getValue(MedInfo.class);
                    medInfos.add(medInfo);

                    Log.v("MedListFragment", "Pulling MedInfo: " + medInfo.getTradename());
                }

                db.putListObject(MED_INFO_KEY, medInfos);

                adapter = new MedinfoCardViewAdapter(medInfos, MedListFragment.this);
                medList.setAdapter(adapter);

                medList.setVisibility(View.VISIBLE);
                progress.setVisibility(View.INVISIBLE);
                Log.v("MedListFragment", "Stop Pulling Data");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



}
