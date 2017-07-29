package app.izhang.medtalk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailMedView extends AppCompatActivity {

    private MenuItem favItem;
    private MedInfo currentMedInfo;
    private int currentDBPosition;

    private static final String MED_INFO_KEY = "MED_INFO";
    private static final String FAV_INFO_KEY = "FAV_INFO";

    private ArrayList<Integer> favIndexList = new ArrayList<>();

    TinyDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_med_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle passedMedInfoData = getIntent().getExtras();
        currentMedInfo = (MedInfo) passedMedInfoData.get("MEDINFO_OBJ");
        currentDBPosition = passedMedInfoData.getInt("OBJ_POS");

        // Initial Setup
        setTitle(currentMedInfo.getTradename() + " | " + currentMedInfo.getGenericName());

        db = new TinyDB(this);

        Log.v("DetailMedView", currentMedInfo.toString());

        // CardViews
        CardView cv_admin = (CardView) this.findViewById(R.id.card_view_administration);
        CardView cv_interaction = (CardView) this.findViewById(R.id.card_view_interaction);
        CardView cv_additional = (CardView) this.findViewById(R.id.card_view_additionalinfo);
        CardView cv_params = (CardView) this.findViewById(R.id.card_view_parameters);
        CardView cv_sideeffects = (CardView) this.findViewById(R.id.card_view_sideeffects);
        CardView cv_special = (CardView) this.findViewById(R.id.card_view_special);
        CardView cv_warning = (CardView) this.findViewById(R.id.card_view_warning);

        // TextViews Title


        // TextViews Content
        // Administration
        TextView tv_admin_emptystomach = (TextView) findViewById(R.id.tv_admin_emptystomach_content);
        TextView tv_admin_emptystomach_title = (TextView) findViewById(R.id.tv_admin_emptystomach);

        TextView tv_admin_optionaltime = (TextView) findViewById(R.id.tv_admin_time_content);
        TextView tv_admin_optionaltime_title = (TextView) findViewById(R.id.tv_admin_time)
;
        TextView tv_admin_technique = (TextView) findViewById(R.id.tv_admin_technique_content);
        TextView tv_admin_technique_title = (TextView) findViewById(R.id.tv_admin_technique);

        TextView tv_admin_ref = (TextView) findViewById(R.id.tv_admin_ref_content);
        TextView tv_admin_ref_title = (TextView) findViewById(R.id.tv_admin_ref);

        // Interactions
        TextView tv_interaction_food = (TextView) findViewById(R.id.tv_interaction_food_content);
        TextView tv_interaction_food_title = (TextView) findViewById(R.id.tv_interaction_food);

        TextView tv_interaction_alcohol = (TextView) findViewById(R.id.tv_interaction_alcohol_content);
        TextView tv_interaction_alcohol_title = (TextView) findViewById(R.id.tv_interaction_alcohol);

        TextView tv_interaction_drugs = (TextView) findViewById(R.id.tv_interaction_drug_content);
        TextView tv_interaction_drugs_title = (TextView) findViewById(R.id.tv_interaction_drug);

        TextView tv_interaction_others = (TextView) findViewById(R.id.tv_interaction_other_content);
        TextView tv_interaction_others_title = (TextView) findViewById(R.id.tv_interaction_others);

        // Special population
        TextView tv_special_age = (TextView) findViewById(R.id.tv_special_age_content);
        TextView tv_special_age_title = (TextView) findViewById(R.id.tv_special_age);

        TextView tv_special_preg = (TextView) findViewById(R.id.tv_special_preg_content);
        TextView tv_special_preg_title = (TextView) findViewById(R.id.tv_special_preg);

        TextView tv_special_others = (TextView) findViewById(R.id.tv_special_ref_content);
        TextView tv_special_others_title = (TextView) findViewById(R.id.tv_special_ref);

        // Side Effects
        TextView tv_sideeffects_sunlight = (TextView) findViewById(R.id.tv_side_sunlight_content);
        TextView tv_sideeffects_sunlight_title = (TextView) findViewById(R.id.tv_side_sunlight);

        TextView tv_sideeffects_sleepy = (TextView) findViewById(R.id.tv_side_sleepy_content);
        TextView tv_sideeffects_sleepy_title = (TextView) findViewById(R.id.tv_side_sleepy);

        TextView tv_sideeffects_gi = (TextView) findViewById(R.id.tv_side_gi_content);
        TextView tv_sideeffects_gi_title = (TextView) findViewById(R.id.tv_side_GI);

        TextView tv_sideeffects_weight = (TextView) findViewById(R.id.tv_side_weight_content);
        TextView tv_sideeffects_weight_title = (TextView) findViewById(R.id.tv_side_weight);

        TextView tv_sideeffects_bloodsugar = (TextView) findViewById(R.id.tv_side_bloodsugar_content);
        TextView tv_sideeffects_bloodsugar_title = (TextView) findViewById(R.id.tv_side_bloodsugar);

        TextView tv_sideeffects_others = (TextView) findViewById(R.id.tv_side_others_content);
        TextView tv_sideeffects_others_title = (TextView) findViewById(R.id.tv_side_others);


        // Parameters
        TextView tv_params_monitoring = (TextView) findViewById(R.id.tv_param_monitoring_content);
        TextView tv_params_monitoring_title = (TextView) findViewById(R.id.tv_param_monitoring);

        TextView tv_params_others = (TextView) findViewById(R.id.tv_param_others_content);
        TextView tv_params_others_title = (TextView) findViewById(R.id.tv_params_others);

        // Diseases (Does not have titles)
        TextView tv_disease_specific1 = (TextView) findViewById(R.id.tv_disease_specific1_content);
        TextView tv_disease_specific2 = (TextView) findViewById(R.id.tv_disease_specific2_content);
        TextView tv_disease_specific3 = (TextView) findViewById(R.id.tv_disease_specific3_content);


        // Additional information (Does not have titles)
        TextView additional_info = (TextView) findViewById(R.id.tv_additional_content);

        /**
         *  If all admin is available, enable each individually.
         */
        int adminCount = 0;
        String contentEmptyStomach = currentMedInfo.getAdministrationEmptyStomach();
        if(contentEmptyStomach == null || contentEmptyStomach.equals("null") || contentEmptyStomach.isEmpty()){
            tv_admin_emptystomach.setVisibility(View.GONE);
            tv_admin_emptystomach_title.setVisibility(View.GONE);
        }else{
            tv_admin_emptystomach.setText(contentEmptyStomach);
            adminCount++;
        }

        String contentOptimalTime = currentMedInfo.getAdministrationOptimaltimeofday();
        if(contentOptimalTime == null || contentOptimalTime.equals("null") || contentOptimalTime.isEmpty()){
            tv_admin_optionaltime.setVisibility(View.GONE);
            tv_admin_optionaltime_title.setVisibility(View.GONE);
        }else{
            tv_admin_optionaltime.setText(contentOptimalTime);
            adminCount++;
        }

        String contentTechnique = currentMedInfo.getAdministrationTechnique();
        if(contentTechnique == null || contentTechnique.equals("null") || contentTechnique.isEmpty()){
            tv_admin_technique.setVisibility(View.GONE);
            tv_admin_technique_title.setVisibility(View.GONE);
        }else{
            tv_admin_technique.setText(contentTechnique);
            adminCount++;
        }

        String contentREFAdmin = currentMedInfo.getREFAdministration();
        if(contentREFAdmin == null || contentREFAdmin.equals("null") || contentREFAdmin.isEmpty()){
            tv_admin_ref.setVisibility(View.GONE);
            tv_admin_ref_title.setVisibility(View.GONE);
        }else{
            tv_admin_ref.setText(contentREFAdmin);
            adminCount++;
        }

        /**
         *  Interactions setting content
         */
        int interactionCount = 0;
        String contentFood = currentMedInfo.getMajorFoodInteractionsFood();
        if(contentFood == null || contentFood.equals("null") || contentFood.isEmpty()){
            tv_interaction_food.setVisibility(View.GONE);
            tv_interaction_food_title.setVisibility(View.GONE);
        }else{
            tv_interaction_food.setText(contentFood);
            interactionCount++;
        }

        String contentAlcohol = currentMedInfo.getMajorFoodInteractionsAlcohol();
        if(contentAlcohol == null || contentAlcohol.equals("null") || contentAlcohol.isEmpty()){
            tv_interaction_alcohol.setVisibility(View.GONE);
            tv_interaction_alcohol_title.setVisibility(View.GONE);
        }else{
            tv_interaction_alcohol.setText(contentAlcohol);
            interactionCount++;
        }

        String contentDrugs = currentMedInfo.getMajorDrugInteractions();
        if(contentDrugs == null || contentDrugs.equals("null") || contentDrugs.isEmpty()){
            tv_interaction_drugs.setVisibility(View.GONE);
            tv_interaction_drugs_title.setVisibility(View.GONE);
        }else{
            tv_interaction_drugs.setText(contentDrugs);
            interactionCount++;
        }

        // TODO: 7/8/17  this is messy. fix this.
        String contentInterOthersAll = currentMedInfo.getREFMajorFoodInteractions() + "\n" + currentMedInfo.getREFMajorDrugInteractions();
        String contentInterOthers = currentMedInfo.getREFMajorFoodInteractions();
        if(contentInterOthers == null || contentInterOthers.equals("null") || contentInterOthers.isEmpty()){
            tv_interaction_others.setVisibility(View.GONE);
            tv_interaction_others_title.setVisibility(View.GONE);
        }else{
            tv_interaction_others.setText(contentInterOthersAll);
            interactionCount++;
        }

        /**
         *  Special populations setting content
         */
        int specialPopCount = 0;

        String contentAge = currentMedInfo.getSpecialPopulationsAge();
        if(contentAge == null || contentAge.equals("null") || contentAge.isEmpty()){
            tv_special_age.setVisibility(View.GONE);
            tv_special_age_title.setVisibility(View.GONE);
        }else{
            tv_special_age.setText(contentAge);
            specialPopCount++;
        }

        String contentPreg = currentMedInfo.getSpecialPopulationsPregnancyLactation();
        if(contentPreg == null || contentPreg.equals("null") || contentPreg.isEmpty()){
            tv_special_preg.setVisibility(View.GONE);
            tv_special_preg_title.setVisibility(View.GONE);
        }else{
            tv_special_preg.setText(contentPreg);
            specialPopCount++;
        }

        String contentOthers = currentMedInfo.getREFSpecialPopulations();
        if(contentOthers == null || contentOthers.equals("null") || contentOthers.isEmpty()){
            tv_special_others.setVisibility(View.GONE);
            tv_special_others_title.setVisibility(View.GONE);
        }else{
            tv_special_others.setText(contentOthers);
            specialPopCount++;
        }

        /**
         *  Side effects setting content
         */
        int sideEffectCount = 0;

        String contentSunlight = currentMedInfo.getNotableSideEffectsSunlight();
        if(contentSunlight == null || contentSunlight.equals("null") || contentSunlight.isEmpty()){
            tv_sideeffects_sunlight.setVisibility(View.GONE);
            tv_sideeffects_sunlight_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_sunlight.setText(contentSunlight);
            sideEffectCount++;
        }

        String contentSleepy = currentMedInfo.getNotableSideEffectsSleepy();
        if(contentSleepy == null || contentSleepy.equals("null") || contentSleepy.isEmpty()){
            tv_sideeffects_sleepy.setVisibility(View.GONE);
            tv_sideeffects_sleepy_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_sleepy.setText(contentSleepy);
            sideEffectCount++;
        }

        String contentGI = currentMedInfo.getNotableSideEffectsGI();
        if(contentGI == null || contentGI.equals("null") || contentGI.isEmpty()){
            tv_sideeffects_gi.setVisibility(View.GONE);
            tv_sideeffects_gi_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_gi.setText(contentGI);
            sideEffectCount++;
        }

        String contentWeight = currentMedInfo.getNotableSideEffectsWeight();
        if(contentWeight == null || contentWeight.equals("null") || contentWeight.isEmpty()){
            tv_sideeffects_weight.setVisibility(View.GONE);
            tv_sideeffects_weight_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_weight.setText(contentWeight);
            sideEffectCount++;
        }

        String contentBloodSugar = currentMedInfo.getNotableSideEffectsBloodSugar();
        if(contentBloodSugar == null || contentBloodSugar.equals("null") || contentBloodSugar.isEmpty()){
            tv_sideeffects_bloodsugar.setVisibility(View.GONE);
            tv_sideeffects_bloodsugar_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_bloodsugar.setText(contentBloodSugar);
            sideEffectCount++;
        }

        String contentOthersSide = currentMedInfo.getNotableSideEffectsOther();
        if(contentOthersSide == null || contentOthersSide.equals("null") || contentOthersSide.isEmpty()){
            tv_sideeffects_others.setVisibility(View.GONE);
            tv_sideeffects_others_title.setVisibility(View.GONE);
        }else{
            tv_sideeffects_others.setText(contentOthersSide);
            sideEffectCount++;
        }

        /**
         *  Parameters setting content
         */
        int paramsCount = 0;

        String contentMonitoring = currentMedInfo.getMonitoringParameters();
        if(contentMonitoring == null || contentMonitoring.equals("null") || contentMonitoring.isEmpty()){
            tv_params_monitoring.setVisibility(View.GONE);
            tv_params_monitoring_title.setVisibility(View.GONE);
        }else{
            tv_params_monitoring.setText(contentMonitoring);
            paramsCount++;
        }

        String contentMonitoringREF = currentMedInfo.getREFMonitoringParameters();
        if(contentMonitoringREF == null || contentMonitoringREF.equals("null") || contentMonitoringREF.isEmpty()){
            tv_params_others.setVisibility(View.GONE);
            tv_params_others_title.setVisibility(View.GONE);
        }else{
            tv_params_others.setText(contentMonitoringREF);
            paramsCount++;
        }


        /**
         *  Parameters setting content
         */
        int diseaseSpecificCount = 0;

        String contentDisease1 = currentMedInfo.getDiseaseSpecific();
        if(contentDisease1 == null || contentDisease1.equals("null") || contentDisease1.isEmpty()){
            tv_disease_specific1.setVisibility(View.GONE);
        }else{
            tv_disease_specific1.setText(contentDisease1);
            diseaseSpecificCount++;
        }

        String contentDisease2 = currentMedInfo.getDiseaseSpecific2();
        if(contentDisease2 == null || contentDisease2.equals("null") || contentDisease2.isEmpty()){
            tv_disease_specific2.setVisibility(View.GONE);
        }else{
            tv_disease_specific2.setText(contentDisease2);
            diseaseSpecificCount++;
        }

        String contentDisease3 = currentMedInfo.getDiseaseSpecific3();
        if(contentDisease3 == null || contentDisease3.equals("null") || contentDisease3.isEmpty()){
            tv_disease_specific3.setVisibility(View.GONE);
        }else{
            tv_disease_specific3.setText(contentDisease3);
            diseaseSpecificCount++;
        }


        /**
         *  Additional information setting content
         */
        int additionalCount = 0;

        String combinedContent = "";
        String contentAdditional =  currentMedInfo.getAdditionalInformation();
        String contentAdditionalREF = currentMedInfo.getREFAdditionalInformation();
        if (contentAdditional == null || contentAdditional.isEmpty() || contentAdditional.equals("null")) {

        }else{
            combinedContent += contentAdditional;
            additionalCount++;
        }

        if (contentAdditionalREF == null || contentAdditionalREF.isEmpty() || contentAdditionalREF.equals("null")) {

        }else{
            if(combinedContent.equals("")){
                combinedContent +=  contentAdditionalREF;
            }else{
                combinedContent = combinedContent + "\n" + contentAdditionalREF;
            }
            additionalCount++;
        }

        additional_info.setText(combinedContent);

        /**
         * Cardview Visibility Setting
         */
        if(adminCount == 0){
            cv_admin.setVisibility(View.GONE);
        }

        if(interactionCount == 0){
            cv_interaction.setVisibility(View.GONE);
        }

        if(additionalCount == 0){
            cv_additional.setVisibility(View.GONE);
        }

        if(diseaseSpecificCount == 0){
            cv_warning.setVisibility(View.GONE);
        }

        if(paramsCount == 0){
            cv_params.setVisibility(View.GONE);
        }

        if(specialPopCount == 0){
            cv_special.setVisibility(View.GONE);
        }

        if(sideEffectCount == 0){
            cv_sideeffects.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorite_menu, menu);

        //noinspection SimplifiableIfStatement
        favItem = menu.findItem(R.id.action_fav);

        // Set the icon state
        if(currentMedInfo.isFavorite()){
            Log.v("DetailMedView", "Current Med is a favorite, show that at the top");
            favItem.setIcon(getResources().getDrawable(R.drawable.icon_star_filled));
        }

        favItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.v("DetailMedView", "GetItemID: " + item.getItemId());

                ArrayList<MedInfo> medInfos = db.getListObject(MED_INFO_KEY, MedInfo.class);
                for(int i = 0; i < medInfos.size(); i++){
                    if(currentMedInfo.equals(medInfos.get(i))){
                        currentDBPosition = i;
                        break;
                    }
                }

                Log.v("DetailMedView", "Current DB Position: " + currentDBPosition);

                if(item.getIcon().getConstantState().equals(getResources().getDrawable(R.drawable.icon_star_filled).getConstantState())){
                    Log.v("DetailMedView", "This medicine is a favorite. Removing it from favorites.");
                    // The MedInfo is a favorite
                    currentMedInfo.setFavorite(false);

                    favIndexList = db.getListInt(FAV_INFO_KEY);
                    // Remove the index from the favorite index list
                    for(int i = 0; i < favIndexList.size(); i++){
                        if(favIndexList.get(i) == currentDBPosition) {
                            favIndexList.remove(i);
                            break;
                        }
                    }

                    Log.v("DetailMedView", "Remove from index. " + "Fav Index List size: " + favIndexList.size());

                    // Replace the medinfo with new data
                    medInfos.set(currentDBPosition, currentMedInfo);

                    // Saving the MedInfo list
                    db.remove(MED_INFO_KEY);
                    db.putListObject(MED_INFO_KEY, medInfos);

                    // Saving the Favorite index list
                    db.remove(FAV_INFO_KEY);
                    db.putListInt(FAV_INFO_KEY, favIndexList);

                    item.setIcon(R.drawable.icon_star_outline);

                }else{
                    Log.v("DetailMedView", "This medicine is NOT a favorite. Adding it from favorites.");

                    // The MedInfo is not a favorite
                    currentMedInfo.setFavorite(true);
                    favIndexList = db.getListInt(FAV_INFO_KEY);

                    // Adding to favorite list
                    favIndexList.add(currentDBPosition);

                    // Saving the data
                    medInfos.set(currentDBPosition, currentMedInfo);

                    db.remove(MED_INFO_KEY);
                    db.putListObject(MED_INFO_KEY, medInfos);

                    db.remove(FAV_INFO_KEY);
                    db.putListInt(FAV_INFO_KEY, favIndexList);

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
