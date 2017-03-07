package com.adrian.mvpwithdagger.main.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.adrian.mvpwithdagger.R;
import com.adrian.mvpwithdagger.app.MyApp;
import com.adrian.mvpwithdagger.main.di.DaggerMainComponent;
import com.adrian.mvpwithdagger.main.di.MainComponent;
import com.adrian.mvpwithdagger.main.di.MainModule;
import com.adrian.mvpwithdagger.main.presenter.MainPresenter;
import com.adrian.mvpwithdagger.omdb.view.OmdbApiActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = MainActivity.class.getName().toString();

    @BindView(R.id.navigationView)
    NavigationView navigationView;

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    MainPresenter mainPresenter;

    private int navItemIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        MainComponent mainComponent = DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .appComponent(MyApp.get(this).getAppComponent())
                .build();
        mainComponent.inject(this);

        mainPresenter.setUpNavDrawer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshNavDrawerItemsCheck(navItemIndex);
    }

    @Override
    public void setUpNavDrawer() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        break;
                    case R.id.nav_ombdapi:
                        startActivity(new Intent(MainActivity.this, OmdbApiActivity.class));
                        drawerLayout.closeDrawers();
                        return true;
                    default:
                        navItemIndex = 0;
                }
                return true;
            }
        });
    }

    public void refreshNavDrawerItemsCheck(final int navItemIndex) {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), sharedPreferences.getString("logged_username", "default") + "", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
