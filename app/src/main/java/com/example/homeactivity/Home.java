package com.example.homeactivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import java.util.ArrayList;


public class Home extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

      private String mParam1;
    private String mParam2;
    RecyclerView recyclerView1,recyclerView2;
    ViewPager viewPager;
    SearchView searchView;
    CustomPagerAdapter customPagerAdapter;
    CardViewData cardViewData1;
    RecyclerData recyclerData,recyclerData1;
    RecyclerAdapter recyclerAdapter,recyclerAdapter1;
    ArrayList<RecyclerData> recyclerDataArrayList1=new ArrayList<RecyclerData>();
    ArrayList<RecyclerData> recyclerDataArrayList2=new ArrayList<RecyclerData>();
    ArrayList<CardViewData> dataArrayList=new ArrayList<CardViewData>();
    private OnFragmentInteractionListener mListener;

    public Home() {
        // Required empty public constructor
    }


    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

               final View view= inflater.inflate(R.layout.fragment_home, container, false);
               viewPager=view.findViewById(R.id.viewpager);
               recyclerView1=view.findViewById(R.id.recyclerview1);
               recyclerView2=view.findViewById(R.id.recyclerview2);
               searchView=view.findViewById(R.id.searchView);
                 cardViewData1=new CardViewData(R.drawable.image1);
                dataArrayList.add(cardViewData1);
                 cardViewData1=new CardViewData(R.drawable.image2);
                dataArrayList.add(cardViewData1);
                 cardViewData1=new CardViewData(R.drawable.image3);
                dataArrayList.add(cardViewData1);
                cardViewData1=new CardViewData(R.drawable.image4);
                dataArrayList.add(cardViewData1);
                customPagerAdapter=new CustomPagerAdapter(getContext(),dataArrayList);
                viewPager.setAdapter(customPagerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManage1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView2.setLayoutManager(linearLayoutManage1);

        recyclerData=new RecyclerData(R.drawable.small_img1,"Tiger");
        recyclerDataArrayList1.add(recyclerData);

        recyclerData=new RecyclerData(R.drawable.small_img2,"Animal");
        recyclerDataArrayList1.add(recyclerData);

        recyclerData=new RecyclerData(R.drawable.small_img3,"Lion");
        recyclerDataArrayList1.add(recyclerData);

        recyclerData=new RecyclerData(R.drawable.small_img5,"Deer");
        recyclerDataArrayList1.add(recyclerData);

       recyclerAdapter=new RecyclerAdapter(getContext(),recyclerDataArrayList1);
       recyclerView1.setAdapter(recyclerAdapter);


        recyclerData1=new RecyclerData(R.drawable.small_img6,"Tiger");
        recyclerDataArrayList2.add(recyclerData1);

        recyclerData1=new RecyclerData(R.drawable.small_img7,"Animal");
        recyclerDataArrayList2.add(recyclerData1);

        recyclerData1=new RecyclerData(R.drawable.small_img8,"Lion");
        recyclerDataArrayList2.add(recyclerData1);

        recyclerData1=new RecyclerData(R.drawable.small_img9,"Deer");
        recyclerDataArrayList2.add(recyclerData1);

        recyclerData1=new RecyclerData(R.drawable.small_img10,"Deer");
        recyclerDataArrayList2.add(recyclerData1);

        recyclerAdapter1=new RecyclerAdapter(getContext(),recyclerDataArrayList2);
        recyclerView2.setAdapter(recyclerAdapter1);






        return view;
    }

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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
