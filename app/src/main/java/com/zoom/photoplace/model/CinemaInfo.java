package com.zoom.photoplace.model;

import java.io.Serializable;
import java.util.Arrays;

public class CinemaInfo implements Serializable {
//  "ParkMemo": null,
//  "LatLng": null,
//  "cinemaNo": 63733851,
//  "IsSupport3D": null,
//  "cinemaName": "金逸国际影城虹口龙之梦IMAX店",


//  "deviceUrl": "http://Img.wangpiao.com/NewsImage/201310/e9565abf-591a-4442-bfa2-1d2467fcbbc6.jpg",
//  "IsSupportUnionPay": null,
//  "IsSupportRest": null,
//  "IsSupportGoods": null,
//  "sellFlag": 1,

//  "phoneNo": "021-36538850",
//  "fouseAmount": null,
//  "areaNo": 52846,
//  "IsHasPark": null,
//  "traffic": "轨道交通3号线、8号线直达、312路、167路、21路、597路、66路",
//  "Introduction": "　　影城秉承典雅浪漫的设计理念，共设10个数字放映厅，一个IMAX影厅，一个豪华VIP厅，八个数字厅，近1800座。还有独家引进超高清的SONY-4K放映设备及2012年伦敦奥运会现场直播的LEONIS&nbsp;3D数字放映设备。到金逸观看3D影片让您体验顶级的立体感受，敬请品鉴！",
//  "areaName": "虹口区",
//  "deviceDesc": "[A%#]独家引进2012年伦敦奥运会现场直播的LEONIS 3D数字放映设备。无押金[A%#]IMAX影厅，给您身临其境、栩栩如生水晶般清晰画面的感受！[A%#]地下停车场10元/小时，看电影可以凭票根至卖品部领取停车券，一张票根可免费1小时。[A%#]鲁迅公园 虹口运动LOFT[A%#]外婆家，绿茶，避风塘，必胜客[A%#][A%#][A%#]",
//  "Address": "上海市虹口区西江湾路388号凯德龙之梦B座6F-7F ",
//  "restMemo": null,
//  "cinemaLogo": "http://Img.wangpiao.com/NewsImage/201310/e9565abf-591a-4442-bfa2-1d2467fcbbc6.jpg",
//  "averageDegree": "7   


    private String ParkMemo;
    private String LatLng;
    private String cinemaNo;
    private String IsSupport3D;
    private String cinemaName;

    private String deviceUrl;
    private String IsSupportUnionPay;
    private String IsSupportRest;
    private String IsSupportGoods;
    private String sellFlag;

    private String phoneNo;
    private String fouseAmount;
    private String areaNo;
    private String IsHasPark;
    private String traffic;
    private String Introduction;
    private String areaName;

    private String deviceDesc;
    private String Address;
    private String restMemo;
    private String cinemaLogo;
    private String averageDegree;
    private String isFavorites; //是否收藏 0：未收藏 1：已收藏

    private String featureLabel;//特色标签,/隔开
    private CinemaFeature[] feature;//特色列表
    private String takeAddress;
    private String cinemaNotice;//影院公告

    public String getIsFavorites() {
        return isFavorites;
    }

    public void setIsFavorites(String isFavorites) {
        this.isFavorites = isFavorites;
    }

    public String getParkMemo() {
        return ParkMemo;
    }

    public void setParkMemo(String parkMemo) {
        ParkMemo = parkMemo;
    }

    public String getLatLng() {
        return LatLng;
    }

    public void setLatLng(String latLng) {
        LatLng = latLng;
    }

    public String getCinemaNo() {
        return cinemaNo;
    }

    public void setCinemaNo(String cinemaNo) {
        this.cinemaNo = cinemaNo;
    }

    public String getIsSupport3D() {
        return IsSupport3D;
    }

    public void setIsSupport3D(String isSupport3D) {
        IsSupport3D = isSupport3D;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getDeviceUrl() {
        return deviceUrl;
    }

    public void setDeviceUrl(String deviceUrl) {
        this.deviceUrl = deviceUrl;
    }

    public String getIsSupportUnionPay() {
        return IsSupportUnionPay;
    }

    public void setIsSupportUnionPay(String isSupportUnionPay) {
        IsSupportUnionPay = isSupportUnionPay;
    }

    public String getIsSupportRest() {
        return IsSupportRest;
    }

    public void setIsSupportRest(String isSupportRest) {
        IsSupportRest = isSupportRest;
    }

    public String getIsSupportGoods() {
        return IsSupportGoods;
    }

    public void setIsSupportGoods(String isSupportGoods) {
        IsSupportGoods = isSupportGoods;
    }

    public String getSellFlag() {
        return sellFlag;
    }

    public void setSellFlag(String sellFlag) {
        this.sellFlag = sellFlag;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFouseAmount() {
        return fouseAmount;
    }

    public void setFouseAmount(String fouseAmount) {
        this.fouseAmount = fouseAmount;
    }

    public String getAreaNo() {
        return areaNo;
    }

    public void setAreaNo(String areaNo) {
        this.areaNo = areaNo;
    }

    public String getIsHasPark() {
        return IsHasPark;
    }

    public void setIsHasPark(String isHasPark) {
        IsHasPark = isHasPark;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getRestMemo() {
        return restMemo;
    }

    public void setRestMemo(String restMemo) {
        this.restMemo = restMemo;
    }

    public String getCinemaLogo() {
        return cinemaLogo;
    }

    public void setCinemaLogo(String cinemaLogo) {
        this.cinemaLogo = cinemaLogo;
    }

    public String getAverageDegree() {
        return averageDegree;
    }

    public void setAverageDegree(String averageDegree) {
        this.averageDegree = averageDegree;
    }

    public String getFeatureLabel() {
        return featureLabel;
    }

    public void setFeatureLabel(String featureLabel) {
        this.featureLabel = featureLabel;
    }

    public String getTakeAddress() {
        return takeAddress;
    }

    public void setTakeAddress(String takeAddress) {
        this.takeAddress = takeAddress;
    }

    public String getCinemaNotice() {
        return cinemaNotice;
    }

    public void setCinemaNotice(String cinemaNotice) {
        this.cinemaNotice = cinemaNotice;
    }

    public CinemaFeature[] getFeature() {
        return feature;
    }

    public void setFeature(CinemaFeature[] feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "CinemaInfo{" +
                "ParkMemo='" + ParkMemo + '\'' +
                ", LatLng='" + LatLng + '\'' +
                ", cinemaNo='" + cinemaNo + '\'' +
                ", IsSupport3D='" + IsSupport3D + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", deviceUrl='" + deviceUrl + '\'' +
                ", IsSupportUnionPay='" + IsSupportUnionPay + '\'' +
                ", IsSupportRest='" + IsSupportRest + '\'' +
                ", IsSupportGoods='" + IsSupportGoods + '\'' +
                ", sellFlag='" + sellFlag + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", fouseAmount='" + fouseAmount + '\'' +
                ", areaNo='" + areaNo + '\'' +
                ", IsHasPark='" + IsHasPark + '\'' +
                ", traffic='" + traffic + '\'' +
                ", Introduction='" + Introduction + '\'' +
                ", areaName='" + areaName + '\'' +
                ", deviceDesc='" + deviceDesc + '\'' +
                ", Address='" + Address + '\'' +
                ", restMemo='" + restMemo + '\'' +
                ", cinemaLogo='" + cinemaLogo + '\'' +
                ", averageDegree='" + averageDegree + '\'' +
                ", isFavorites='" + isFavorites + '\'' +
                ", featureLabel='" + featureLabel + '\'' +
                ", feature=" + Arrays.toString(feature) +
                ", takeAddress='" + takeAddress + '\'' +
                ", cinemaNotice='" + cinemaNotice + '\'' +
                '}';
    }
}
