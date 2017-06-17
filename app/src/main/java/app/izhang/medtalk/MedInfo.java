package app.izhang.medtalk;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ivanzhang on 5/27/17.
 */

public class MedInfo {
    private String title;
    private String secondTitle;
    private Map<String, String> indications;
    private Map<String, String> warnings;
    private Map<String, String> administration;
    private Map<String, String> interactions;
    private Map<String, String> specialPopulations;
    private Map<String, String> sideEffects;
    private boolean isFavorite;

    public MedInfo(String title, String secondTitle, Map indications, Map warnings, Map administration, Map interactions, Map specialPopulations, Map sideEffects){
        this.title = title;
        this.secondTitle = secondTitle;
        this.indications = indications;
        this.warnings = warnings;
        this.administration = administration;
        this.interactions = interactions;
        this.specialPopulations = specialPopulations;
        this.sideEffects = sideEffects;
        this.isFavorite = false;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public Map<String, String> getIndications() {
        return indications;
    }

    public void setIndications(Map<String, String> indications) {
        this.indications = indications;
    }

    public Map<String, String> getWarnings() {
        return warnings;
    }

    public void setWarnings(Map<String, String> warnings) {
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

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }


    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
