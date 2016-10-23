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
}
