package ir.boardbazi.updatetest;

import com.google.gson.annotations.SerializedName;

public class BodyResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("description")
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
