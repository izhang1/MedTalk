package app.izhang.medtalk;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ivanzhang on 5/27/17.
 */

public class MedInfo {
    private String name;
    private ArrayList<String> indications;
    private ArrayList<String> warnings;
    private Map<String, String> administration;
    private Map<String, String> interactions;
    private Map<String, String> specialPopulations;
    private Map<String, String> sideEffects;

    public MedInfo(String name, ArrayList indications, ArrayList warnings, Map administration, Map interactions, Map specialPopulations, Map sideEffects){
        this.name = name;
        this.indications = indications;
        this.warnings = warnings;
        this.administration = administration;
        this.interactions = interactions;
        this.specialPopulations = specialPopulations;
        this.sideEffects = sideEffects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getIndications() {
        return indications;
    }

    public void setIndications(ArrayList<String> indications) {
        this.indications = indications;
    }

    public ArrayList<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<String> warnings) {
        this.warnings = warnings;
    }

    public Map<String, String> getAdministration() {
        return administration;
    }

    public void setAdministration(Map<String, String> administration) {
        this.administration = administration;
    }

    public Map<String, String> getInteractions() {
        return interactions;
    }

    public void setInteractions(Map<String, String> interactions) {
        this.interactions = interactions;
    }

    public Map<String, String> getSpecialPopulations() {
        return specialPopulations;
    }

    public void setSpecialPopulations(Map<String, String> specialPopulations) {
        this.specialPopulations = specialPopulations;
    }

    public Map<String, String> getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(Map<String, String> sideEffects) {
        this.sideEffects = sideEffects;
    }
}