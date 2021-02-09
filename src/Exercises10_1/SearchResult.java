package Exercises10_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("batchcomplete")
    @Expose
    private String batchcomplete;

    @SerializedName("continue")
    @Expose
    private Continue _continue;

    @SerializedName("query")
    @Expose
    private Query query;

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public Query getQuery() {
        return query;
    }
}
