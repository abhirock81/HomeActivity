package com.example.homeactivity;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Home.OnFragmentInteractionListener,Cart.OnFragmentInteractionListener,Profile.OnFragmentInteractionListener,Search.OnFragmentInteractionListener {
TextView homeTextView,cartTextView,searchTextView,profileTextView;
FloatingActionButton floatingActionButton;
    Fragment fragment;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingActionButton2);
        homeTextView=findViewById(R.id.hometextView);
        cartTextView=findViewById(R.id.carttextView);
        searchTextView=findViewById(R.id.searchtextView);
        profileTextView=findViewById(R.id.profiletextView);
        homeTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.bluehome),null,null);
        cartTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.cart),null,null);
        profileTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.user),null,null);
        searchTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.search),null,null);
        loadFragment(new Home());

    }

    public void selectBottomNavigation(View view) {
    switch (view.getId()){
        case R.id.hometextView:
            homeTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.bluehome),null,null);
            cartTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.cart),null,null);
            profileTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.user),null,null);
            searchTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.search),null,null);
            loadFragment(new Home());
            break;
        case R.id.carttextView:
            homeTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.home),null,null);
            cartTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.bluecart),null,null);
            profileTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.user),null,null);
            searchTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.search),null,null);
            loadFragment(new Cart());
            break;
        case R.id.profiletextView:
            homeTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.home),null,null);
            cartTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.cart),null,null);
            profileTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.blueuser),null,null);
            searchTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.search),null,null);
            loadFragment(new Profile());
            break;
        case R.id.searchtextView:
            homeTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.home),null,null);
            cartTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.cart),null,null);
            profileTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.user),null,null);
            searchTextView.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.bluesearch),null,null);
            loadFragment(new Search());
            break;
    }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.detach(fragment);
        transaction.attach(fragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
