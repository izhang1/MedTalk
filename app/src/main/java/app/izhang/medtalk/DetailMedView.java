package app.izhang.medtalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.izhang.medtalk.adapter.DetailInfoCardViewAdapter;

public class DetailMedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_med_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Test Data
        ArrayList testData = new ArrayList<>();

        Map indications = new HashMap();
        Map warnings = new HashMap();
        Map administration = new HashMap();
        Map interactions = new HashMap();
        Map specialPopulations = new HashMap();
        Map sideEffects = new HashMap();

        indications.put("-", "high blood pressure/ heart failure");
        indications.put("title", "Indications");

        warnings.put("-","May cause injury or death to developing fetus");
        warnings.put("title", "Warnings");

        administration.put("Empty Stomach", "Take with or without food");
        administration.put("title", "Administration");

        interactions.put("Food", "Avoid salt substitutes such as potassium cloride or other supplements which may raise potassium levels");
        interactions.put("Alcohol", "Alcohol may further decrease blood pressure");
        interactions.put("Drug", "Monitor levels of potassium with use of drugs that are proven to raise levels");
        interactions.put("title", "Interactions");

        specialPopulations.put("Pregnancy/Lactation", "Pregnancy Category C...ectectect");
        specialPopulations.put("title", "Special Populations");

        sideEffects.put("GI", "Cause damage to yo GI");
        sideEffects.put("Other", "Excess potassium in the blood....ectect");
        sideEffects.put("title", "Side Effects");

        MedInfo medInfo = new MedInfo("Accupril",
                "Quinapril",
                indications,
                warnings,
                interactions,
                administration,
                specialPopulations,
                sideEffects);

        testData.add(indications);
        testData.add(administration);
        testData.add(warnings);
        testData.add(specialPopulations);
        testData.add(sideEffects);


        // Initial Setup
        setTitle(medInfo.getName());
        TextView brandNameView = (TextView) findViewById(R.id.content_secondTitle);
        brandNameView.setText(medInfo.getSecondTitle());

        // Inflate the layout for this fragment
        RecyclerView medList = (RecyclerView) findViewById(R.id.ListDetails);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        medList.setLayoutManager(gridLayoutManager);


        DetailInfoCardViewAdapter adapter = new DetailInfoCardViewAdapter(testData, DetailMedView.this);
        medList.setAdapter(adapter);

    }

}
