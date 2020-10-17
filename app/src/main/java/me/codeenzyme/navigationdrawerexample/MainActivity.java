package me.codeenzyme.navigationdrawerexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DrawerArrayAdapter drawerArrayAdapter;
    FrameLayout fragmentContainer;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        fragmentContainer = findViewById(R.id.fragment_container);
        drawerLayout = findViewById(R.id.drawer_layout);

        ((ImageView) findViewById(R.id.ham)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new HomeFragment())
                .commit();

        listView = findViewById(R.id.list_view);
        drawerArrayAdapter = new DrawerArrayAdapter(this, getResources().getStringArray(R.array.nav_drawer));
        listView.setAdapter(drawerArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                drawerLayout.closeDrawer(GravityCompat.START);
                Fragment fragment;
                switch (position) {
                    case 0: fragment = new HomeFragment();
                    break;
                    case 1: fragment = new DashboardFragment();
                    break;
                    case 2: fragment = new ProfileFragment();
                    break;
                    default: throw new IllegalStateException("No valid fragment");
                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();
            }
        });
    }
}