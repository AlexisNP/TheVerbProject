package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {

    @SerializedName("location")
    private String location;
    @SerializedName("name")
    private String name;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("username")
    private String username;

    public User(String location, String name, String permalink, String username) {
        this.location = location;
        this.name = name;
        this.permalink = permalink;
        this.username = username;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPermalink() {
        return permalink;
    }
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
