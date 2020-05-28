package fr.mds.theverbproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class IconPageResult implements Serializable {

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<Icon> iconResult;

    public IconPageResult(int page, int totalResults, int totalPages, ArrayList<Icon> iconResult) {
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.iconResult = iconResult;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<Icon> getIconResult() {
        return iconResult;
    }
    public void setIconResult(ArrayList<Icon> iconResult) {
        this.iconResult = iconResult;
    }
}