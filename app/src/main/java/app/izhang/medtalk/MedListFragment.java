package app.izhang.medtalk;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MedListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v("MedListFragment", "OnCreateView");
        View view = inflater.inflate(R.layout.fragment_med_list, container, false);;

        // Inflate the layout for this fragment
        RecyclerView medList = (RecyclerView) view.findViewById(R.id.medList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 1);
        medList.setLayoutManager(gridLayoutManager);
        ArrayList testData = new ArrayList<>();

        Map indications = new HashMap();
        Map warnings = new HashMap();
        Map administration = new HashMap();
        Map interactions = new HashMap();
        Map specialPopulations = new HashMap();
        Map sideEffects = new HashMap();

        indications.put("0", "high blood pressure/ heart failure");
        warnings.put("0","May cause injury or death to developing fetus");

        administration.put("Empty Stomach", "Take with or without food");

        interactions.put("Food", "Avoid salt substitutes such as potassium cloride or other supplements which may raise potassium levels");
        interactions.put("Alcohol", "Alcohol may further decrease blood pressure");
        interactions.put("Drug", "Monitor levels of potassium with use of drugs that are proven to raise levels");

        specialPopulations.put("Pregnancy/Lactation", "Pregnancy Category C...ectectect");

        sideEffects.put("GI", "Cause damage to yo GI");
        sideEffects.put("Other", "Excess potassium in the blood....ectect");

        MedInfo medInfo = new MedInfo("Accupril",
                                        "Quinapril",
                                        indications,
                                        warnings,
                                        interactions,
                                        administration,
                                        specialPopulations,
                                        sideEffects);
        testData.add(medInfo);
        testData.add(medInfo);

        MedinfoCardViewAdapter adapter = new MedinfoCardViewAdapter(testData, MedListFragment.this);
        medList.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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