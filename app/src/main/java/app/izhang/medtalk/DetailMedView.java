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

        Log.v("DetailMedView", currentMedInfo.toString());
//        TextView brandNameView = (TextView) findViewById(R.id.content_secondTitle);
//        brandNameView.setText(medInfo.getSecondTitle());

        // Inflate the layout for this fragment
//        RecyclerView medList = (RecyclerView) findViewById(R.id.ListDetails);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
//        medList.setLayoutManager(gridLayoutManager);


        //DetailInfoCardViewAdapter adapter = new DetailInfoCardViewAdapter(testData, DetailMedView.this);
        //medList.setAdapter(adapter);

        TextView tv_admin_emptystomach = (TextView) findViewById(R.id.tv_admin_emptystomach_content);
        TextView tv_admin_optionaltime = (TextView) findViewById(R.id.tv_admin_time_content);
        TextView tv_admin_technique = (TextView) findViewById(R.id.tv_admin_technique_content);
        TextView tv_admin_ref = (TextView) findViewById(R.id.tv_admin_ref_content);
        TextView tv_interaction_food = (TextView) findViewById(R.id.tv_interaction_food_content);
        TextView tv_interaction_alcohol = (TextView) findViewById(R.id.tv_interaction_alcohol_content);
        TextView tv_interaction_drugs = (TextView) findViewById(R.id.tv_interaction_drug_content);
        TextView tv_interaction_others = (TextView) findViewById(R.id.tv_interaction_other_content);
        TextView tv_special_age = (TextView) findViewById(R.id.tv_special_age_content);
        TextView tv_special_preg = (TextView) findViewById(R.id.tv_special_preg_content);
        TextView tv_special_others = (TextView) findViewById(R.id.tv_special_ref_content);
        TextView tv_sideeffects_sunlight = (TextView) findViewById(R.id.tv_side_sunlight_content);
        TextView tv_sideeffects_sleepy = (TextView) findViewById(R.id.tv_side_sleepy_content);
        TextView tv_sideeffects_gi = (TextView) findViewById(R.id.tv_side_gi_content);
        TextView tv_sideeffects_weight = (TextView) findViewById(R.id.tv_side_weight_content);
        TextView tv_sideeffects_bloodsugar = (TextView) findViewById(R.id.tv_side_bloodsugar_content);
        TextView tv_params_monitoring = (TextView) findViewById(R.id.tv_param_monitoring_content);
        TextView tv_params_others = (TextView) findViewById(R.id.tv_param_others_content);
        TextView tv_disease_specific1 = (TextView) findViewById(R.id.tv_disease_specific1_content);
        TextView tv_disease_specific2 = (TextView) findViewById(R.id.tv_disease_specific2_content);
        TextView tv_disease_specific3 = (TextView) findViewById(R.id.tv_disease_specific3_content);
        TextView additional_info = (TextView) findViewById(R.id.tv_additional_content);

        tv_admin_emptystomach.setText(currentMedInfo.getAdministrationEmptyStomach());
        tv_admin_optionaltime.setText(currentMedInfo.getAdministrationOptimaltimeofday());
        tv_admin_technique.setText(currentMedInfo.getAdministrationTechnique());
        tv_admin_ref.setText(currentMedInfo.getREFAdministration());

        tv_interaction_food.setText(currentMedInfo.getMajorFoodInteractionsFood());
        tv_interaction_alcohol.setText(currentMedInfo.getMajorFoodInteractionsAlcohol());
        tv_interaction_drugs.setText(currentMedInfo.getMajorDrugInteractions());
        tv_interaction_others.setText(currentMedInfo.getREFMajorFoodInteractions() + "\n" + currentMedInfo.getREFMajorDrugInteractions());

        tv_special_age.setText(currentMedInfo.getSpecialPopulationsAge());
        tv_special_preg.setText(currentMedInfo.getSpecialPopulationsPregnancyLactation());
        tv_special_others.setText(currentMedInfo.getREFSpecialPopulations());

        tv_sideeffects_sunlight.setText(currentMedInfo.getNotableSideEffectsSunlight());
        tv_sideeffects_sleepy.setText(currentMedInfo.getNotableSideEffectsSleepy());
        tv_sideeffects_gi.setText(currentMedInfo.getNotableSideEffectsGI());
        tv_sideeffects_weight.setText(currentMedInfo.getNotableSideEffectsWeight());
        tv_sideeffects_bloodsugar.setText(currentMedInfo.getNotableSideEffectsBloodSugar());

        tv_params_monitoring.setText(currentMedInfo.getMonitoringParameters());
        tv_params_others.setText(currentMedInfo.getREFMonitoringParameters());

        tv_disease_specific1.setText(currentMedInfo.getDiseaseSpecific());
        tv_disease_specific2.setText(currentMedInfo.getDiseaseSpecific2());
        tv_disease_specific3.setText(currentMedInfo.getDiseaseSpecific3());

        additional_info.setText(currentMedInfo.getAdditionalInformation() + "\n" + currentMedInfo.getREFAdditionalInformation());

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
