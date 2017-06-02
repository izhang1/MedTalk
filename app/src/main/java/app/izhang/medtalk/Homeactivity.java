package app.izhang.medtalk;

import android.app.SearchManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class Homeactivity extends AppCompatActivity {

    SearchView searchView;
    MenuItem searchItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        RecyclerView medList = (RecyclerView) findViewById(R.id.medList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        medList.setLayoutManager(gridLayoutManager);
        ArrayList testData = new ArrayList<>();


        MedInfo medInfo = new MedInfo("Accupril",
                                        "Quinapril",
                                        null,
                                        null,
                                        null,
                                        null,
                                        null,
                                        null);
        testData.add(medInfo);

        MedinfoCardViewAdapter adapter = new MedinfoCardViewAdapter(testData, Homeactivity.this);
        medList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        //noinspection SimplifiableIfStatement
        searchItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getApplication().getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getParent().getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });


        return true;
    }
}
