package app.izhang.medtalk;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Homeactivity extends AppCompatActivity implements MedListFragment.OnFragmentInteractionListener, FavListFragmnet.OnFragmentInteractionListener {

    SearchView searchView;
    MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MedTabAdapter(getSupportFragmentManager(), getApplicationContext()));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

//        // Creating the right fragment viewing experience for the user
//        FragmentManager manager = getSupportFragmentManager();
//        Fragment fragment = new MedListFragment();
//
//        manager.beginTransaction()
//                .replace(R.id.content_frame, fragment,
//                        "MedListFragment").commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        //noinspection SimplifiableIfStatement
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));

        SearchManager searchManager = (SearchManager) getApplication().getSystemService(SEARCH_SERVICE);

        searchView.setMaxWidth(Integer.MAX_VALUE); // Needed to have the search bar go the full width

        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.v("HomeActivity", "onQueryTextSubmit");

                /**
                 * FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                 Fragment newFragment = new SearchFragment(); //your search fragment
                 Bundle args = new Bundle();
                 args.putString("query_string", query);
                 newFragment.setArguments(args);

                 transaction.replace(R.id.content_frame, newFragment);
                 transaction.addToBackStack(null);
                 transaction.commit();
                 */

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.v("HomeActivity", "onQueryTextChange");
                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                Log.v("HomeActivity", "Query closed");
                return true;
            }
        });


        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public static class MedTabAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;
        private String tabTitles[] = new String[] { "Med List", "Favorites" };
        Context context = null;

        public MedTabAdapter(FragmentManager fragmentManager, Context context) {
            super(fragmentManager);
            this.context = context;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return MedListFragment.newInstance("0", "Page #1");
                case 1: // Fragment # 0 - This will show FirstFragment
                    return FavListFragmnet.newInstance("0", "Page #1");
                default:
                    return MedListFragment.newInstance("0", "Page #1");
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }

    public class SampleAdapter extends FragmentPagerAdapter {
        Context ctxt = null;

        public SampleAdapter(Context ctxt, FragmentManager mgr) {
            super(mgr);
            this.ctxt = ctxt;
        }

        @Override
        public int getCount() {
            return (10);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public String getPageTitle(int position) {
            return "Hello";
        }

    }
}
