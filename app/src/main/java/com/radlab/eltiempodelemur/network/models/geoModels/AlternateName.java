
package com.radlab.eltiempodelemur.network.models.geoModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlternateName {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("isShortName")
    @Expose
    private Boolean isShortName;
    @SerializedName("isPreferredName")
    @Expose
    private Boolean isPreferredName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getIsShortName() {
        return isShortName;
    }

    public void setIsShortName(Boolean isShortName) {
        this.isShortName = isShortName;
    }

    public Boolean getIsPreferredName() {
        return isPreferredName;
    }

    public void setIsPreferredName(Boolean isPreferredName) {
        this.isPreferredName = isPreferredName;
    }

}
