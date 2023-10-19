package com.example.mvvmjava.data.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "mobiles")
public class Mobile implements Parcelable {


    @SerializedName("id")
    @Expose
    @ColumnInfo(name = "id")
    private String id;

    @SerializedName("category_id")
    @ColumnInfo(name = "category_id")
    @Expose
    private String categoryId;

    @SerializedName("mobile_name")
    @ColumnInfo(name = "mobile_name")
    @Expose
    private String mobileName;
    @SerializedName("mobile_price")
    @ColumnInfo(name = "mobile_price")
    @Expose
    private String mobilePrice;
    @SerializedName("mobile_release")
    @ColumnInfo(name = "mobile_release")
    @Expose
    private String mobileRelease;
    @SerializedName("mobile_color")
    @ColumnInfo(name = "mobile_color")
    @Expose
    private String mobileColor;
    @SerializedName("mobile_details")
    @ColumnInfo(name = "mobile_details")
    @Expose
    private String mobileDetails;
    @SerializedName("mobile_image_url")
    @ColumnInfo(name = "mobile_image_url")
    @Expose
    private String mobileImageUrl;
    @SerializedName("mobile_image")
    @ColumnInfo(name = "mobile_image")
    @Expose
    private String mobileImage;
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    @Expose
    private Object updatedAt;

    public Mobile(String id, String categoryId, String mobileName, String mobilePrice,
                  String mobileRelease, String mobileColor, String mobileDetails, String mobileImageUrl,
                  String mobileImage, String createdAt, Object updatedAt) {
        this.id = id;
        this.categoryId = categoryId;
        this.mobileName = mobileName;
        this.mobilePrice = mobilePrice;
        this.mobileRelease = mobileRelease;
        this.mobileColor = mobileColor;
        this.mobileDetails = mobileDetails;
        this.mobileImageUrl = mobileImageUrl;
        this.mobileImage = mobileImage;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public static final Creator<Mobile> CREATOR = new Creator<Mobile>() {
        @Override
        public Mobile createFromParcel(Parcel in) {
            return new Mobile(in);
        }

        @Override
        public Mobile[] newArray(int size) {
            return new Mobile[size];
        }
    };

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


    // Override method from Parcelable describeContents and writeToParcel
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(categoryId);
        parcel.writeString(mobileName);
        parcel.writeString(mobilePrice);
        parcel.writeString(mobileRelease);
        parcel.writeString(mobileColor);
        parcel.writeString(mobileDetails);
        parcel.writeString(mobileImageUrl);
        parcel.writeString(mobileImage);
        parcel.writeString(createdAt);
    }

    protected Mobile(Parcel in) {
        id = in.readString();
        categoryId = in.readString();
        mobileName = in.readString();
        mobilePrice = in.readString();
        mobileRelease = in.readString();
        mobileColor = in.readString();
        mobileDetails = in.readString();
        mobileImageUrl = in.readString();
        mobileImage = in.readString();
        createdAt = in.readString();
    }
}

