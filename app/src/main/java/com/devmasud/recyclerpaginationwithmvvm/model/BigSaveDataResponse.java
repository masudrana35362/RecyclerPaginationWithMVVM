package com.devmasud.recyclerpaginationwithmvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BigSaveDataResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("previous_price")
    @Expose
    private String previousPrice;
    @SerializedName("details")
    @Expose
    private String details;

    @SerializedName("discount_date")
    @Expose
    private String discountDate;

    @SerializedName("rating")
    @Expose
    private String rating;

    public BigSaveDataResponse() {
    }

    public BigSaveDataResponse(int id, String name, String photo, String thumbnail, String price, String previousPrice, String details, String discountDate, String rating) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.thumbnail = thumbnail;
        this.price = price;
        this.previousPrice = previousPrice;
        this.details = details;
        this.discountDate = discountDate;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(String previousPrice) {
        this.previousPrice = previousPrice;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(String discountDate) {
        this.discountDate = discountDate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}