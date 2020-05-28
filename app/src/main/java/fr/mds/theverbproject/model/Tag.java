package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tag implements Serializable {

    @SerializedName("id")
    private Double id;
    @SerializedName("slug")
    private String slug;

    public Tag(Double id, String slug) {
        this.id = id;
        this.slug = slug;
    }

    public Double getId() {
        return id;
    }
    public void setId(Double id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
}
