
package com.radlab.eltiempodelemur.network.models.weatherModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Geoname {

    @SerializedName("timezone")
    @Expose
    private Timezone timezone;
    @SerializedName("bbox")
    @Expose
    private Bbox bbox;
    @SerializedName("asciiName")
    @Expose
    private String asciiName;
    @SerializedName("astergdem")
    @Expose
    private Integer astergdem;
    @SerializedName("countryId")
    @Expose
    private String countryId;
    @SerializedName("fcl")
    @Expose
    private String fcl;
    @SerializedName("srtm3")
    @Expose
    private Integer srtm3;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("adminId2")
    @Expose
    private String adminId2;
    @SerializedName("adminId3")
    @Expose
    private String adminId3;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("adminCodes2")
    @Expose
    private AdminCodes2 adminCodes2;
    @SerializedName("adminCodes1")
    @Expose
    private AdminCodes1 adminCodes1;
    @SerializedName("adminId1")
    @Expose
    private String adminId1;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("fcode")
    @Expose
    private String fcode;
    @SerializedName("continentCode")
    @Expose
    private String continentCode;
    @SerializedName("adminCode2")
    @Expose
    private String adminCode2;
    @SerializedName("adminCode3")
    @Expose
    private String adminCode3;
    @SerializedName("adminCode1")
    @Expose
    private String adminCode1;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("geonameId")
    @Expose
    private Integer geonameId;
    @SerializedName("toponymName")
    @Expose
    private String toponymName;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("adminName5")
    @Expose
    private String adminName5;
    @SerializedName("adminName4")
    @Expose
    private String adminName4;
    @SerializedName("adminName3")
    @Expose
    private String adminName3;
    @SerializedName("alternateNames")
    @Expose
    private List<AlternateName> alternateNames = null;
    @SerializedName("adminName2")
    @Expose
    private String adminName2;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fclName")
    @Expose
    private String fclName;
    @SerializedName("countryName")
    @Expose
    private String countryName;
    @SerializedName("fcodeName")
    @Expose
    private String fcodeName;
    @SerializedName("adminName1")
    @Expose
    private String adminName1;
    @SerializedName("adminTypeName")
    @Expose
    private String adminTypeName;
    @SerializedName("adminId4")
    @Expose
    private String adminId4;
    @SerializedName("adminCode4")
    @Expose
    private String adminCode4;
    @SerializedName("elevation")
    @Expose
    private Integer elevation;
    @SerializedName("cc2")
    @Expose
    private String cc2;

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
    }

    public Bbox getBbox() {
        return bbox;
    }

    public void setBbox(Bbox bbox) {
        this.bbox = bbox;
    }

    public String getAsciiName() {
        return asciiName;
    }

    public void setAsciiName(String asciiName) {
        this.asciiName = asciiName;
    }

    public Integer getAstergdem() {
        return astergdem;
    }

    public void setAstergdem(Integer astergdem) {
        this.astergdem = astergdem;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public Integer getSrtm3() {
        return srtm3;
    }

    public void setSrtm3(Integer srtm3) {
        this.srtm3 = srtm3;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAdminId2() {
        return adminId2;
    }

    public void setAdminId2(String adminId2) {
        this.adminId2 = adminId2;
    }

    public String getAdminId3() {
        return adminId3;
    }

    public void setAdminId3(String adminId3) {
        this.adminId3 = adminId3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public AdminCodes2 getAdminCodes2() {
        return adminCodes2;
    }

    public void setAdminCodes2(AdminCodes2 adminCodes2) {
        this.adminCodes2 = adminCodes2;
    }

    public AdminCodes1 getAdminCodes1() {
        return adminCodes1;
    }

    public void setAdminCodes1(AdminCodes1 adminCodes1) {
        this.adminCodes1 = adminCodes1;
    }

    public String getAdminId1() {
        return adminId1;
    }

    public void setAdminId1(String adminId1) {
        this.adminId1 = adminId1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    public String getAdminCode2() {
        return adminCode2;
    }

    public void setAdminCode2(String adminCode2) {
        this.adminCode2 = adminCode2;
    }

    public String getAdminCode3() {
        return adminCode3;
    }

    public void setAdminCode3(String adminCode3) {
        this.adminCode3 = adminCode3;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Integer getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(Integer geonameId) {
        this.geonameId = geonameId;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getAdminName5() {
        return adminName5;
    }

    public void setAdminName5(String adminName5) {
        this.adminName5 = adminName5;
    }

    public String getAdminName4() {
        return adminName4;
    }

    public void setAdminName4(String adminName4) {
        this.adminName4 = adminName4;
    }

    public String getAdminName3() {
        return adminName3;
    }

    public void setAdminName3(String adminName3) {
        this.adminName3 = adminName3;
    }

    public List<AlternateName> getAlternateNames() {
        return alternateNames;
    }

    public void setAlternateNames(List<AlternateName> alternateNames) {
        this.alternateNames = alternateNames;
    }

    public String getAdminName2() {
        return adminName2;
    }

    public void setAdminName2(String adminName2) {
        this.adminName2 = adminName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getAdminTypeName() {
        return adminTypeName;
    }

    public void setAdminTypeName(String adminTypeName) {
        this.adminTypeName = adminTypeName;
    }

    public String getAdminId4() {
        return adminId4;
    }

    public void setAdminId4(String adminId4) {
        this.adminId4 = adminId4;
    }

    public String getAdminCode4() {
        return adminCode4;
    }

    public void setAdminCode4(String adminCode4) {
        this.adminCode4 = adminCode4;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public String getCc2() {
        return cc2;
    }

    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }

}
