package net.derohimat.sample;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.balysv.materialmenu.MaterialMenuDrawable;

import net.derohimat.sample.fragment.BaseFragment;
import net.derohimat.sample.fragment.CardListFragment;
import net.derohimat.sample.fragment.ContactFragment;
import net.derohimat.sample.fragment.HomeFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.toolbar)    Toolbar mToolbar;
    @InjectView(R.id.navigationView)    NavigationView mNavigationView;
    @InjectView(R.id.drawerLayout)    DrawerLayout mDrawerLayout;

    private BaseFragment fragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setupToolbar(mToolbar);
        materialMenuIcon.setState(mDrawerLayout.isDrawerOpen(GravityCompat.START) ?
                MaterialMenuDrawable.IconState.ARROW : MaterialMenuDrawable.IconState.BURGER);

        setUpUi();
        setupDrawerContent(mNavigationView);
    }

    private void setUpUi(){
        fragment = HomeFragment.newInstance();
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.drawer_home) {
                    fragment = HomeFragment.newInstance();
                } else if (id == R.id.drawer_favourite) {
                    fragment = CardListFragment.newInstance();
                } else if (id == R.id.drawer_settings) {
                    fragment = CardListFragment.newInstance();
                } else if (id == R.id.drawer_contact) {
                    fragment = CardListFragment.newInstance();
                } else if (id == R.id.drawer_help) {
                    fragment = CardListFragment.newInstance();
                } else {
                    fragment = ContactFragment.newInstance();
                }

                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content, fragment)
                        .commit();

                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static void start(Context mContext){
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }

}
