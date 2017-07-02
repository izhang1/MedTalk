package app.izhang.medtalk;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.izhang.medtalk.adapter.DetailInfoCardViewAdapter;

public class DetailMedView extends AppCompatActivity {

    private MenuItem favItem;
    private MedInfo currentMedInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_med_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle passedMedInfoData = getIntent().getExtras();
        currentMedInfo = (MedInfo) passedMedInfoData.get("MEDINFO_OBJ");
        // Initial Setup
        setTitle(currentMedInfo.getTradename() + " | " + currentMedInfo.getGenericName());
//        TextView brandNameView = (TextView) findViewById(R.id.content_secondTitle);
//        brandNameView.setText(medInfo.getSecondTitle());

        // Inflate the layout for this fragment
//        RecyclerView medList = (RecyclerView) findViewById(R.id.ListDetails);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
//        medList.setLayoutManager(gridLayoutManager);


        //DetailInfoCardViewAdapter adapter = new DetailInfoCardViewAdapter(testData, DetailMedView.this);
        //medList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorite_menu, menu);

        //noinspection SimplifiableIfStatement
        favItem = menu.findItem(R.id.action_fav);
        favItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // TODO: 6/17/17 Implement the change in data
                Log.v("DetailMedView", "GetItemID: " + item.getItemId());

                if(item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.icon_star_filled).getConstantState())){
                    Log.v("DetailMedView", "Is Star Filled");
                    item.setIcon(R.drawable.icon_star_outline);

                }else{

                    Log.v("DetailMedView", "Is Star Outline");
                    item.setIcon(R.drawable.icon_star_filled);
                }

                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
