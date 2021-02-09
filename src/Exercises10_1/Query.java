package Exercises10_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Query {

    @SerializedName("searchinfo")
    @Expose
    private Searchinfo searchinfo;

    @SerializedName("search")
    @Expose
    private List<Search> search = null;

    public Searchinfo getSearchinfo() {
        return searchinfo;
    }

    public List<Search> getSearch() {
        return search;
    }
}
