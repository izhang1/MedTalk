package app.izhang.medtalk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.izhang.medtalk.adapter.MedinfoCardViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FavListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FavListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static final String FAV_INFO_KEY = "FAV_INFO";
    private static final String MED_INFO_KEY = "MED_INFO";


    TinyDB db;
    RecyclerView favList;
    ArrayList<Integer> favIndexList;
    ArrayList<MedInfo> medInfoList;
    ArrayList<MedInfo> favMedList;

    MedinfoCardViewAdapter adapter;


    private OnFragmentInteractionListener mListener;

    public FavListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavListFragment newInstance(String param1, String param2) {
        FavListFragment fragment = new FavListFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v("MedListFragment", "OnCreateView");
        View view = inflater.inflate(R.layout.fragment_fav_list, container, false);

        // Inflate the layout for this fragment
        favList = (RecyclerView) view.findViewById(R.id.rv_favlist);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 1);
        favList.setLayoutManager(gridLayoutManager);

        initView();

        return view;
    }

    public void initView(){
        favIndexList = new ArrayList<>();
        favIndexList = db.getListInt(FAV_INFO_KEY);
        if(favIndexList.isEmpty()){
            medInfoList = db.getListObject(MED_INFO_KEY, MedInfo.class);
            favMedList = new ArrayList<>();
            for(int i = 0; i < favIndexList.size(); i++){
                favMedList.add(medInfoList.get(favIndexList.get(i)));
            }

            adapter = new MedinfoCardViewAdapter(favMedList, FavListFragment.this);
            favList.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }else{
            medInfoList = db.getListObject(MED_INFO_KEY, MedInfo.class);
            favMedList = new ArrayList<>();
            for(int i = 0; i < favIndexList.size(); i++){
                favMedList.add(medInfoList.get(favIndexList.get(i)));
            }

            adapter = new MedinfoCardViewAdapter(favMedList, FavListFragment.this);
            favList.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }

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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
