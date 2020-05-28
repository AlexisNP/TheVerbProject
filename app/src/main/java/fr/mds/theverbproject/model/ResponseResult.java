package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseResult implements Serializable {

    @SerializedName("generated_at")
    private String generated_at;
    @SerializedName("icons")
    private List<Icon> icons;

    public ResponseResult(String generated_at, List<Icon> icons) {
        this.generated_at = generated_at;
        this.icons = icons;
    }

    public String getGenerated_at() {
        return generated_at;
    }
    public void setGenerated_at(String generated_at) {
        this.generated_at = generated_at;
    }

    public List<Icon> getIcons() {
        return icons;
    }
    public void setIcons(List<Icon> icons) {
        this.icons = icons;
    }
}
