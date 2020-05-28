package fr.mds.theverbproject.model;

import java.util.Set;

public class Collection {

    private User author;
    private Double author_id;
    private String date_created;
    private String date_updated;
    private String description;
    private String id;
    private String is_collaborative;
    private String is_featured;
    private String is_published;
    private String is_store_item;
    private String name;
    private String permalink;
    private String slug;
//  "sponsor": {},
    private String sponsor_campaign_link;
    private String sponsor_id;
    private Set<Tag> tags;
    private String template;

    public Collection(User author, Double author_id, String date_created, String date_updated,
                      String description, String id, String is_collaborative, String is_featured,
                      String is_published, String is_store_item, String name, String permalink,
                      String slug, String sponsor_campaign_link, String sponsor_id, Set<Tag> tags,
                      String template) {
        this.author = author;
        this.author_id = author_id;
        this.date_created = date_created;
        this.date_updated = date_updated;
        this.description = description;
        this.id = id;
        this.is_collaborative = is_collaborative;
        this.is_featured = is_featured;
        this.is_published = is_published;
        this.is_store_item = is_store_item;
        this.name = name;
        this.permalink = permalink;
        this.slug = slug;
        this.sponsor_campaign_link = sponsor_campaign_link;
        this.sponsor_id = sponsor_id;
        this.tags = tags;
        this.template = template;
    }

    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    public Double getAuthor_id() {
        return author_id;
    }
    public void setAuthor_id(Double author_id) {
        this.author_id = author_id;
    }

    public String getDate_created() {
        return date_created;
    }
    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_updated() {
        return date_updated;
    }
    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getIs_collaborative() {
        return is_collaborative;
    }
    public void setIs_collaborative(String is_collaborative) {
        this.is_collaborative = is_collaborative;
    }

    public String getIs_featured() {
        return is_featured;
    }
    public void setIs_featured(String is_featured) {
        this.is_featured = is_featured;
    }

    public String getIs_published() {
        return is_published;
    }
    public void setIs_published(String is_published) {
        this.is_published = is_published;
    }

    public String getIs_store_item() {
        return is_store_item;
    }
    public void setIs_store_item(String is_store_item) {
        this.is_store_item = is_store_item;
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

    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }
}
