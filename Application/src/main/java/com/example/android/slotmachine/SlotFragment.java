package com.example.android.slotmachine;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.common.logger.Log;
import com.example.android.recyclerview.R;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SlotFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SlotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlotFragment extends Fragment {

    public static final String TAG = "SlogFragmet";
    Button button01,button02,button03,button04;
    TextView slot01, slot02,slot03;
    TextView credit_current,credit_playing,won;
    Handler myHandler;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SlotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SlotFragment newInstance(String param1, String param2) {
        SlotFragment fragment = new SlotFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public SlotFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        myHandler = new Handler();
        initialize_data();
    }

    private void initialize_data() {
        SpinnersData.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slot, container, false);


        button01 = (Button) view.findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "clicked on max credit and spin");
            }
        });
        button02 = (Button) view.findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "clicked on add 1 credit");
            }
        });
        button03 = (Button) view.findViewById(R.id.button03);
        button03.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Runnable r = new Runnable() {
                    @Override
                    public void run(){

                    }
                };

                Log.i(TAG, "clicked on spin");
                slot01.setText("spinning");
                slot02.setText("spinning");
                slot03.setText("spinning");
                Random randomGenerator = new Random();

                int randomInt = randomGenerator.nextInt(17);  // index of array 1
                Log.i(TAG,"Slot 1 index Generated : " + randomInt);
                int randomIntWait = randomGenerator.nextInt(500);
                myHandler.postDelayed(r, randomIntWait);  //Trying to wait random number less than 500 milliseconds

                slot01.setText("result :" + SpinnersData.getInstance().getSpinner_array_01()[randomInt]);

                randomInt = randomGenerator.nextInt(17);  // index of array
                Log.i(TAG,"Slot 2 index Generated : " + randomInt);

                randomIntWait = randomGenerator.nextInt(500);
                myHandler.postDelayed(r, randomIntWait); //Trying to wait random number less than 500 milliseconds

                slot02.setText("result :"+SpinnersData.getInstance().getSpinner_array_02()[randomInt]);
                randomInt = randomGenerator.nextInt(17);  // index of array 3

                Log.i(TAG,"Slot 3 index Generated : " + randomInt);
                randomIntWait = randomGenerator.nextInt(500);
                myHandler.postDelayed(r, randomIntWait);  //Trying to wait random number less than 500 milliseconds

                slot03.setText("result :" + SpinnersData.getInstance().getSpinner_array_03()[randomInt]);

                calculate_prize();

            }
        });
        button04 = (Button) view.findViewById(R.id.button04);
        button04.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.i(TAG, "clicked on payout quit");
                Log.i(TAG, "Settle the account and Good bye");
                getActivity().finish();
            }
        });
        slot01 = (TextView) view.findViewById(R.id.texView02);
        slot02 = (TextView) view.findViewById(R.id.texView03);
        slot03 = (TextView) view.findViewById(R.id.texView04);
        credit_current = (TextView) view.findViewById(R.id.texView06);
        credit_playing = (TextView) view.findViewById(R.id.texView10);
        won = (TextView) view.findViewById(R.id.texView08);

        return view;

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private void calculate_prize() {
        won.setText("prizeze calculated");
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
