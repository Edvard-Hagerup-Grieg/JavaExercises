package Exercises10_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue {

    @SerializedName("sroffset")
    @Expose
    private Integer sroffset;

    @SerializedName("continue")
    @Expose
    private String _continue;

    public Integer getSroffset() {
        return sroffset;
    }

    public String getContinue() {
        return _continue;
    }
}
