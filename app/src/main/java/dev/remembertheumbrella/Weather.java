package dev.remembertheumbrella;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private long mId;

    @SerializedName("main")
    private String mMain;

    @SerializedName("description")
    private String mDescription;

    public long getId() {

        return mId;
    }

    public String getMain() {

        return mMain;
    }

    public String getDescription() {

        return mDescription;
    }
}
