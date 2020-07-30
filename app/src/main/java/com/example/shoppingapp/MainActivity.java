package com.example.shoppingapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
//    ListView l;
//    String str[]={"Recent","Offline","Uploads","BackUps"};
DrawerLayout d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        l=findViewById(R.id.list);
        d= findViewById(R.id.drawer_layout);
//        ArrayAdapter<String> ad =new  ArrayAdapter<String>(MainActivity.this,android.R.layout.activity_list_item,str);
//        l.setAdapter(ad);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle ad = new ActionBarDrawerToggle(MainActivity.this,d,toolbar,R.string.close,R.string.open);
        ad.syncState();

    }


 @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.my_files:
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                MyFileFrag f1 = new MyFileFrag();
                ft.replace(R.id.root,f1);
                ft.commit();
                d.close();
                break;
            case R.id.shared:
                FragmentManager fm1 =getSupportFragmentManager();
                FragmentTransaction ft1= fm1.beginTransaction();
                SharedFrag f2= new SharedFrag();
                ft1.replace(R.id.root,f2);
                ft1.commit();
                d.close();
                break;
            case R.id.Starred:
                FragmentManager fm2 =getSupportFragmentManager();
                FragmentTransaction ft2= fm2.beginTransaction();
                StarredFrag f3= new StarredFrag();
                ft2.replace(R.id.root,f3);
                ft2.commit();
                d.close();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}