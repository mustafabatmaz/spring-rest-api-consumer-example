package com.mustafa.examplewebservice.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumDTO {
    private int userId;
    private int id;
    private String title;
    private List<PhotosDTO> photos;
    public List<PhotosDTO> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosDTO> photos) {
        this.photos = photos;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
