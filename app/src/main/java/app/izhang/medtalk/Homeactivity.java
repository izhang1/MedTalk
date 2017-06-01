package app.izhang.medtalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class Homeactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        RecyclerView medList = (RecyclerView) findViewById(R.id.medList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        medList.setLayoutManager(gridLayoutManager);
        ArrayList testData = new ArrayList<>();


        MedinfoCardViewAdapter adapter = new MedinfoCardViewAdapter(testData, Homeactivity.this);
        medList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        return true;
    }
}
