package com.zoom.photoplace.model;

import java.io.Serializable;

/**
 * Created by wudongli on 2018/4/27.
 */

public class CinemaFeature implements Serializable{

    private String featureName;//特色名;
    private String featureDesc;//特色内容

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public void setFeatureDesc(String featureDesc) {
        this.featureDesc = featureDesc;
    }

    @Override
    public String toString() {
        return "CinemaFeature{" +
                "featureName='" + featureName + '\'' +
                ", featureDesc='" + featureDesc + '\'' +
                '}';
    }
}
