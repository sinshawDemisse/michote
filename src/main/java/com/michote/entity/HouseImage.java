package com.michote.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jtq603 on 10/16/16.
 */

@Entity
@Table(name = "image")
public class HouseImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long imageId;

    @NotNull
    private String imageUrl;

    @ManyToOne
    private House house;

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}
