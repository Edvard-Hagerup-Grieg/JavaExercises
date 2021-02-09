package Exercises10_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("ns")
    @Expose
    private Integer ns;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("pageid")
    @Expose
    private Integer pageid;

    @SerializedName("size")
    @Expose
    private Integer size;

    @SerializedName("wordcount")
    @Expose
    private Integer wordcount;

    @SerializedName("snippet")
    @Expose
    private String snippet;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    public Integer getNs() {
        return ns;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPageid() {
        return pageid;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getWordcount() {
        return wordcount;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
