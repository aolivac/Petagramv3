package com.example.xoff.fragments_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.xoff.fragments_1.adapter.PageAdapter;
import com.example.xoff.fragments_1.fragment.PerfilFragment;
import com.example.xoff.fragments_1.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();



        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAcercaDe:
                startActivity(new Intent(MainActivity.this, AcercaDe.class));
                return true;

            case R.id.mContacto:
                //Intent i = new Intent(this, ContactoEmail.class);
                startActivity(new Intent(MainActivity.this, ContactoEmail.class));
                return true;

            case R.id.menuFavoritos:
                startActivity(new Intent(MainActivity.this, Favoritos.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }
    private void setUpViewPager(){
            viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
            tabLayout.setupWithViewPager(viewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
            tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }

}
