package Exercises10_1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Searchinfo {

    @SerializedName("totalhits")
    @Expose
    private Integer totalhits;

    public Integer getTotalhits() {
        return totalhits;
    }
}
