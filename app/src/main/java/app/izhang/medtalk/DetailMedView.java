package app.izhang.medtalk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DetailMedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_med_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Inflate the layout for this fragment
        RecyclerView medList = (RecyclerView) findViewById(R.id.ListDetails);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        medList.setLayoutManager(gridLayoutManager);
        ArrayList testData = new ArrayList<>();

        Map indications = new HashMap();
        Map warnings = new HashMap();
        Map administration = new HashMap();
        Map interactions = new HashMap();
        Map specialPopulations = new HashMap();
        Map sideEffects = new HashMap();

        indications.put("0", "high blood pressure/ heart failure");
        warnings.put("0","May cause injury or death to developing fetus");

        administration.put("Empty Stomach", "Take with or without food");

        interactions.put("Food", "Avoid salt substitutes such as potassium cloride or other supplements which may raise potassium levels");
        interactions.put("Alcohol", "Alcohol may further decrease blood pressure");
        interactions.put("Drug", "Monitor levels of potassium with use of drugs that are proven to raise levels");

        specialPopulations.put("Pregnancy/Lactation", "Pregnancy Category C...ectectect");

        sideEffects.put("GI", "Cause damage to yo GI");
        sideEffects.put("Other", "Excess potassium in the blood....ectect");

        MedInfo medInfo = new MedInfo("Accupril",
                "Quinapril",
                indications,
                warnings,
                interactions,
                administration,
                specialPopulations,
                sideEffects);
        testData.add(medInfo);
        testData.add(medInfo);

        DetailInfoCardViewAdapter adapter = new DetailInfoCardViewAdapter(testData, DetailMedView.this);
        medList.setAdapter(adapter);

    }

}
