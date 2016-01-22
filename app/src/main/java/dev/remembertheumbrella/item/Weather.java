package dev.remembertheumbrella.item;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("id")
    private long mId;

    @SerializedName("main")
    private String mMain;

    @SerializedName("description")
    private String mDescription;

    @SerializedName("icon")
    private String mIconId;

    /**
     * Returns Weather id.
     *
     * @return Weather id.
     */
    public long getId() {

        return mId;
    }

    public String getMain() {

        return mMain;
    }

    public String getDescription() {

        return mDescription;
    }

    public String getIconId() {

        return mIconId;
    }
}
