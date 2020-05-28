package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Set;

public class Icon implements Serializable {

    @SerializedName("attribution")
    private String attribution;
    @SerializedName("attribution_p")
    private String attribution_preview_url;
    @SerializedName("coll")
    private Set<Collection> collections;
    @SerializedName("date_uploaded")
    private String date_uploaded;
    @SerializedName("id")
    private String id;
    @SerializedName("is_active")
    private String is_active;
    @SerializedName("is_explicit")
    private String is_explicit;
    @SerializedName("license_descr")
    private String license_description;
    @SerializedName("nounji_free")
    private String nounji_free;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("preview_url")
    private String preview_url;
    @SerializedName("preview_url_4")
    private String preview_url_42;
    @SerializedName("preview_url_8")
    private String preview_url_84;
//  @SerializedName("sponsor")
//  "sponsor": {},
    @SerializedName("sponsor_campa")
    private String sponsor_campaign_link;
    @SerializedName("sponsor_id")
    private String sponsor_id;
    @SerializedName("tags")
    private Set<Tag> tags;
    @SerializedName("term")
    private String term;
    @SerializedName("term_id")
    private String term_id;
    @SerializedName("term_slug")
    private String term_slug;
    @SerializedName("updated_at")
    private String updated_at;
    @SerializedName("uploader")
    private User uploader;
    @SerializedName("uploader_id")
    private String uploader_id;
    @SerializedName("year")
    private int year;

    public Icon(String attribution, String attribution_preview_url, Set<Collection> collections,
                String date_uploaded, String id, String is_active, String is_explicit,
                String license_description, String nounji_free, String permalink,
                String preview_url, String preview_url_42, String preview_url_84,
                String sponsor_campaign_link, String sponsor_id, Set<Tag> tags, String term,
                String term_id, String term_slug, String updated_at, User uploader,
                String uploader_id, int year) {
        this.attribution = attribution;
        this.attribution_preview_url = attribution_preview_url;
        this.collections = collections;
        this.date_uploaded = date_uploaded;
        this.id = id;
        this.is_active = is_active;
        this.is_explicit = is_explicit;
        this.license_description = license_description;
        this.nounji_free = nounji_free;
        this.permalink = permalink;
        this.preview_url = preview_url;
        this.preview_url_42 = preview_url_42;
        this.preview_url_84 = preview_url_84;
        this.sponsor_campaign_link = sponsor_campaign_link;
        this.sponsor_id = sponsor_id;
        this.tags = tags;
        this.term = term;
        this.term_id = term_id;
        this.term_slug = term_slug;
        this.updated_at = updated_at;
        this.uploader = uploader;
        this.uploader_id = uploader_id;
        this.year = year;
    }

    public String getAttribution() {
        return attribution;
    }
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getAttribution_preview_url() {
        return attribution_preview_url;
    }
    public void setAttribution_preview_url(String attribution_preview_url) {
        this.attribution_preview_url = attribution_preview_url;
    }

    public Set<Collection> getCollections() {
        return collections;
    }
    public void setCollections(Set<Collection> collections) {
        this.collections = collections;
    }

    public String getDate_uploaded() {
        return date_uploaded;
    }
    public void setDate_uploaded(String date_uploaded) {
        this.date_uploaded = date_uploaded;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIs_active() {
        return is_active;
    }
    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_explicit() {
        return is_explicit;
    }
    public void setIs_explicit(String is_explicit) {
        this.is_explicit = is_explicit;
    }

    public String getLicense_description() {
        return license_description;
    }
    public void setLicense_description(String license_description) {
        this.license_description = license_description;
    }

    public String getNounji_free() {
        return nounji_free;
    }
    public void setNounji_free(String nounji_free) {
        this.nounji_free = nounji_free;
    }

    public String getPermalink() {
        return permalink;
    }
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPreview_url() {
        return preview_url;
    }
    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getPreview_url_42() {
        return preview_url_42;
    }
    public void setPreview_url_42(String preview_url_42) {
        this.preview_url_42 = preview_url_42;
    }

    public String getPreview_url_84() {
        return preview_url_84;
    }
    public void setPreview_url_84(String preview_url_84) {
        this.preview_url_84 = preview_url_84;
    }

    public String getSponsor_campaign_link() {
        return sponsor_campaign_link;
    }
    public void setSponsor_campaign_link(String sponsor_campaign_link) {
        this.sponsor_campaign_link = sponsor_campaign_link;
    }

    public String getSponsor_id() {
        return sponsor_id;
    }
    public void setSponsor_id(String sponsor_id) {
        this.sponsor_id = sponsor_id;
    }

    public Set<Tag> getTags() {
        return tags;
    }
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }

    public String getTerm_id() {
        return term_id;
    }
    public void setTerm_id(String term_id) {
        this.term_id = term_id;
    }

    public String getTerm_slug() {
        return term_slug;
    }
    public void setTerm_slug(String term_slug) {
        this.term_slug = term_slug;
    }

    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User getUploader() {
        return uploader;
    }
    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public String getUploader_id() {
        return uploader_id;
    }
    public void setUploader_id(String uploader_id) {
        this.uploader_id = uploader_id;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
