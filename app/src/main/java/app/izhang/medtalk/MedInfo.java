package app.izhang.medtalk;


import java.io.Serializable;

/**
 * Created by ivanzhang on 5/27/17.
 */

public class MedInfo implements Serializable{

    // Name
    private String GenericName;
    private String Tradename;

    // Administration
    private String AdministrationEmptyStomach;
    private String AdministrationOptimaltimeofday;
    private String AdministrationShakeWell;
    private String AdministrationTechnique;
    private String REFAdministration;

    // Interaction
    private String MajorFoodInteractionsFood;
    private String MajorFoodInteractionsAlcohol;
    private String MajorDrugInteractions;
    private String REFMajorDrugInteractions;
    private String REFMajorFoodInteractions;

    // Special Population
    private String SpecialPopulationsAge;
    private String SpecialPopulationsPregnancyLactation;
    private String REFSpecialPopulations;

    // Side Effects
    private String NotableSideEffectsSunlight;
    private String NotableSideEffectsSleepy;
    private String NotableSideEffectsGI;
    private String NotableSideEffectsWeight;
    private String NotableSideEffectsBloodSugar;
    private String NotableSideEffectsOther;

    // Blackbox Warning
    private String REFNotableSideEffects;

    // Monitoring Param
    private String MonitoringParameters;
    private String REFMonitoringParameters;

    // Additional Information
    private String AdditionalInformation;
    private String REFAdditionalInformation;

    // Disease Specific
    private String REFDiseaseSpecific;
    private String DiseaseSpecific;
    private String DiseaseSpecific2;
    private String DiseaseSpecific3;


    // Favorite
    private boolean isFavorite;

    public MedInfo(){

    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String genericName) {
        GenericName = genericName;
    }

    public String getTradename() {
        return Tradename;
    }

    public void setTradename(String tradename) {
        Tradename = tradename;
    }

    public String getAdministrationEmptyStomach() {
        return AdministrationEmptyStomach;
    }

    public void setAdministrationEmptyStomach(String administrationEmptyStomach) {
        AdministrationEmptyStomach = administrationEmptyStomach;
    }

    public String getAdministrationOptimaltimeofday() {
        return AdministrationOptimaltimeofday;
    }

    public void setAdministrationOptimaltimeofday(String administrationOptimaltimeofday) {
        AdministrationOptimaltimeofday = administrationOptimaltimeofday;
    }

    public String getAdministrationShakeWell() {
        return AdministrationShakeWell;
    }

    public void setAdministrationShakeWell(String administrationShakeWell) {
        AdministrationShakeWell = administrationShakeWell;
    }

    public String getAdministrationTechnique() {
        return AdministrationTechnique;
    }

    public void setAdministrationTechnique(String administrationTechnique) {
        AdministrationTechnique = administrationTechnique;
    }

    public String getREFAdministration() {
        return REFAdministration;
    }

    public void setREFAdministration(String REFAdministration) {
        this.REFAdministration = REFAdministration;
    }

    public String getMajorFoodInteractionsFood() {
        return MajorFoodInteractionsFood;
    }

    public void setMajorFoodInteractionsFood(String majorFoodInteractionsFood) {
        MajorFoodInteractionsFood = majorFoodInteractionsFood;
    }

    public String getMajorFoodInteractionsAlcohol() {
        return MajorFoodInteractionsAlcohol;
    }

    public void setMajorFoodInteractionsAlcohol(String majorFoodInteractionsAlcohol) {
        MajorFoodInteractionsAlcohol = majorFoodInteractionsAlcohol;
    }

    public String getMajorDrugInteractions() {
        return MajorDrugInteractions;
    }

    public void setMajorDrugInteractions(String majorDrugInteractions) {
        MajorDrugInteractions = majorDrugInteractions;
    }

    public String getREFMajorDrugInteractions() {
        return REFMajorDrugInteractions;
    }

    public void setREFMajorDrugInteractions(String REFMajorDrugInteractions) {
        this.REFMajorDrugInteractions = REFMajorDrugInteractions;
    }

    public String getREFMajorFoodInteractions() {
        return REFMajorFoodInteractions;
    }

    public void setREFMajorFoodInteractions(String REFMajorFoodInteractions) {
        this.REFMajorFoodInteractions = REFMajorFoodInteractions;
    }

    public String getSpecialPopulationsAge() {
        return SpecialPopulationsAge;
    }

    public void setSpecialPopulationsAge(String specialPopulationsAge) {
        SpecialPopulationsAge = specialPopulationsAge;
    }

    public String getSpecialPopulationsPregnancyLactation() {
        return SpecialPopulationsPregnancyLactation;
    }

    public void setSpecialPopulationsPregnancyLactation(String specialPopulationsPregnancyLactation) {
        SpecialPopulationsPregnancyLactation = specialPopulationsPregnancyLactation;
    }

    public String getREFSpecialPopulations() {
        return REFSpecialPopulations;
    }

    public void setREFSpecialPopulations(String REFSpecialPopulations) {
        this.REFSpecialPopulations = REFSpecialPopulations;
    }

    public String getNotableSideEffectsSunlight() {
        return NotableSideEffectsSunlight;
    }

    public void setNotableSideEffectsSunlight(String notableSideEffectsSunlight) {
        NotableSideEffectsSunlight = notableSideEffectsSunlight;
    }

    public String getNotableSideEffectsSleepy() {
        return NotableSideEffectsSleepy;
    }

    public void setNotableSideEffectsSleepy(String notableSideEffectsSleepy) {
        NotableSideEffectsSleepy = notableSideEffectsSleepy;
    }

    public String getNotableSideEffectsGI() {
        return NotableSideEffectsGI;
    }

    public void setNotableSideEffectsGI(String notableSideEffectsGI) {
        NotableSideEffectsGI = notableSideEffectsGI;
    }

    public String getNotableSideEffectsWeight() {
        return NotableSideEffectsWeight;
    }

    public void setNotableSideEffectsWeight(String notableSideEffectsWeight) {
        NotableSideEffectsWeight = notableSideEffectsWeight;
    }

    public String getNotableSideEffectsBloodSugar() {
        return NotableSideEffectsBloodSugar;
    }

    public void setNotableSideEffectsBloodSugar(String notableSideEffectsBloodSugar) {
        NotableSideEffectsBloodSugar = notableSideEffectsBloodSugar;
    }

    public String getNotableSideEffectsOther() {
        return NotableSideEffectsOther;
    }

    public void setNotableSideEffectsOther(String notableSideEffectsOther) {
        NotableSideEffectsOther = notableSideEffectsOther;
    }

    public String getREFNotableSideEffects() {
        return REFNotableSideEffects;
    }

    public void setREFNotableSideEffects(String REFNotableSideEffects) {
        this.REFNotableSideEffects = REFNotableSideEffects;
    }

    public String getMonitoringParameters() {
        return MonitoringParameters;
    }

    public void setMonitoringParameters(String monitoringParameters) {
        MonitoringParameters = monitoringParameters;
    }

    public String getREFMonitoringParameters() {
        return REFMonitoringParameters;
    }

    public void setREFMonitoringParameters(String REFMonitoringParameters) {
        this.REFMonitoringParameters = REFMonitoringParameters;
    }

    public String getAdditionalInformation() {
        return AdditionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        AdditionalInformation = additionalInformation;
    }

    public String getREFAdditionalInformation() {
        return REFAdditionalInformation;
    }

    public void setREFAdditionalInformation(String REFAdditionalInformation) {
        this.REFAdditionalInformation = REFAdditionalInformation;
    }

    public String getREFDiseaseSpecific() {
        return REFDiseaseSpecific;
    }

    public void setREFDiseaseSpecific(String REFDiseaseSpecific) {
        this.REFDiseaseSpecific = REFDiseaseSpecific;
    }

    public String getDiseaseSpecific() {
        return DiseaseSpecific;
    }

    public void setDiseaseSpecific(String diseaseSpecific) {
        DiseaseSpecific = diseaseSpecific;
    }

    public String getDiseaseSpecific2() {
        return DiseaseSpecific2;
    }

    public void setDiseaseSpecific2(String diseaseSpecific2) {
        DiseaseSpecific2 = diseaseSpecific2;
    }

    public String getDiseaseSpecific3() {
        return DiseaseSpecific3;
    }

    public void setDiseaseSpecific3(String diseaseSpecific3) {
        DiseaseSpecific3 = diseaseSpecific3;
    }

    @Override
    public String toString(){
        String str = "Generic Name: " + getGenericName() + "\n"
                + "Trade Name: " + getTradename() + "\n"
                + "Administration - Empty Stomach: " + getAdministrationEmptyStomach() + "\n"
                + "Administration - Optimal Time: " + getAdministrationOptimaltimeofday() + "\n"
                + "Administration - Shake Well: " + getAdministrationShakeWell() + "\n"
                + "Administration - Technique: " + getAdministrationTechnique() + "\n"
                + "Administration - REF: " + getREFAdministration() + "\n"
                + "Interactions - Food" + getMajorFoodInteractionsFood() + "\n"
                + "Interactions - Alcohol" + getMajorFoodInteractionsAlcohol() + "\n"
                + "Interactions - Drugs" + getMajorDrugInteractions() + "\n"
                + "Interactions - REF food" + getREFMajorDrugInteractions() + "\n"
                + "Interactions - REF drugs" + getREFMajorFoodInteractions() + "\n"
                + "Special populations - Age " + getSpecialPopulationsAge() + "\n"
                + "Special populations - Pregnancy " + getSpecialPopulationsPregnancyLactation() + "\n"
                + "Special populations - REF " + getREFSpecialPopulations() + "\n"
                + "Side Effects - Sunlight " + getNotableSideEffectsSunlight() + "\n"
                + "Side Effects - Sleepy " + getNotableSideEffectsSleepy() + "\n"
                + "Side Effects - GI " + getNotableSideEffectsGI() + "\n"
                + "Side Effects - Weight " + getNotableSideEffectsWeight() + "\n"
                + "Side Effects - Blood Sugar " + getNotableSideEffectsBloodSugar() + "\n"
                + "Side Effects - Other " + getNotableSideEffectsOther() + "\n"
                + "Blackbox Warning " + getREFNotableSideEffects() + "\n"
                + "Monitoring Params  " + getMonitoringParameters() + "\n"
                + "Monitoring Params - REF " + getREFMonitoringParameters() + "\n"
                + "Additional Information " + getAdditionalInformation() + "\n"
                + "Additional Information - REF " + getREFAdditionalInformation() + "\n"
                + "Disease Specific - 1 " + getDiseaseSpecific() + "\n"
                + "Disease Specific - 2 " + getDiseaseSpecific2() + "\n"
                + "Disease Specific - 3 " + getDiseaseSpecific3() + "\n"
                + "Disease Specific - REF " + getREFDiseaseSpecific() + "\n";

        return str;
    }

    public boolean equals(MedInfo medInfo){
        if(this.getGenericName().equals(medInfo.getGenericName())
                && this.getTradename().equals(medInfo.getTradename())
                && this.getAdministrationOptimaltimeofday().equals(medInfo.getAdministrationOptimaltimeofday())
                && this.getAdministrationEmptyStomach().equals(medInfo.getAdministrationEmptyStomach())
                && this.getAdministrationTechnique().equals(medInfo.getAdministrationTechnique())) {
            return true;
        }

        return false;
    }
}
