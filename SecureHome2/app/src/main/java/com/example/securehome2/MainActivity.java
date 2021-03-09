package com.example.securehome2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.securehome2.Start.Start;
import com.example.securehome2.alert.Alert;
import com.example.securehome2.emergencyList.EmergencyList;
import com.example.securehome2.home.HomeFragment;
import com.example.securehome2.settings.Settings;
import com.example.securehome2.store.Buy;
import com.example.securehome2.store.Sell;
import com.example.securehome2.store.Store;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.onFragmentFabSelected, Store.onBuySelected, Store.onSellSelected,
         Start.onAlertCardSelected, Start.onHomeCardSelected, Start.onEmergencyCardSelected{




    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout = findViewById(R.id.drawer);
        navigationView =  findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.bringToFront();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,new Start());
        fragmentTransaction.commit();
        navigationView.setCheckedItem(R.id.start);





    }

    @Override
    public void onBackPressed() {
       if(drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
       }else{
           super.onBackPressed();
       }
    }

    @Override
    public void onBtnSelected() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new Store() );
        fragmentTransaction.commit();
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()){
            case R.id.start:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new Start());
                fragmentTransaction.commit();
                break;
            case R.id.home:
                Intent intent3 = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent3);
                break;
            case R.id.store:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new Store());
                fragmentTransaction.commit();
                break;
            case R.id.alert:
                Intent intent2 = new Intent(MainActivity.this, Alert.class);
                startActivity(intent2);

                break;



            case R.id.emergency_list:
                Intent intent4 = new Intent(MainActivity.this, EmergencyList.class);
                startActivity(intent4);

                break;
            case R.id.settings:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new Settings());
                fragmentTransaction.commit();

                break;


        }
        return true;
    }



    @Override
    public void buyText() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new Buy());
        fragmentTransaction.commit();
    }

    @Override
    public void sellText() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,new Sell());
        fragmentTransaction.commit();

    }

    @Override
    public void onAlertSelected() {
        Intent intent2 = new Intent(MainActivity.this, Alert.class);
        startActivity(intent2);
    }

    @Override
    public void onHomeSelected() {
        Intent intent3 = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent3);
    }

    @Override
    public void onEmergencySelected() {
        Intent intent4 = new Intent(MainActivity.this, EmergencyList.class);
        startActivity(intent4);
    }
}
