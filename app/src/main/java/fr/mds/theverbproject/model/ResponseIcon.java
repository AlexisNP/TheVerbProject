package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Set;

public class ResponseIcon implements Serializable {

    @SerializedName("generated_at")
    private String generated_at;
    @SerializedName("icons")
    private Set<Icon> icons;

    public ResponseIcon(String generated_at, Set<Icon> icons) {
        this.generated_at = generated_at;
        this.icons = icons;
    }

    public String getGenerated_at() {
        return generated_at;
    }
    public void setGenerated_at(String generated_at) {
        this.generated_at = generated_at;
    }

    public Set<Icon> getIcons() {
        return icons;
    }
    public void setIcons(Set<Icon> icons) {
        this.icons = icons;
    }
}
