
package com.rahul.multiplelayoutrecyclerview.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {

    @SerializedName("homeData")
    @Expose
    private List<HomeDatum> homeData = null;

    public List<HomeDatum> getHomeData() {
        return homeData;
    }

    public void setHomeData(List<HomeDatum> homeData) {
        this.homeData = homeData;
    }

}
