package com.example.mvvmjava.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MobileRemote {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("mobile_name")
    @Expose
    private String mobileName;
    @SerializedName("mobile_price")
    @Expose
    private String mobilePrice;
    @SerializedName("mobile_release")
    @Expose
    private String mobileRelease;
    @SerializedName("mobile_color")
    @Expose
    private String mobileColor;
    @SerializedName("mobile_details")
    @Expose
    private String mobileDetails;
    @SerializedName("mobile_image_url")
    @Expose
    private String mobileImageUrl;
    @SerializedName("mobile_image")
    @Expose
    private String mobileImage;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public String getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(String mobilePrice) {
        this.mobilePrice = mobilePrice;
    }

    public String getMobileRelease() {
        return mobileRelease;
    }

    public void setMobileRelease(String mobileRelease) {
        this.mobileRelease = mobileRelease;
    }

    public String getMobileColor() {
        return mobileColor;
    }

    public void setMobileColor(String mobileColor) {
        this.mobileColor = mobileColor;
    }

    public String getMobileDetails() {
        return mobileDetails;
    }

    public void setMobileDetails(String mobileDetails) {
        this.mobileDetails = mobileDetails;
    }

    public String getMobileImageUrl() {
        return mobileImageUrl;
    }

    public void setMobileImageUrl(String mobileImageUrl) {
        this.mobileImageUrl = mobileImageUrl;
    }

    public String getMobileImage() {
        return mobileImage;
    }

    public void setMobileImage(String mobileImage) {
        this.mobileImage = mobileImage;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

}
