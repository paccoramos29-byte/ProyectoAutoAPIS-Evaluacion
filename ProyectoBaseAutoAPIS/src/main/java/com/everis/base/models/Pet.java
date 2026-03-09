package com.everis.base.models;

import java.util.List;
public class Pet {

    private Long id;
    private String name;
    private List<String> photoUrls;
    private String status;
    public Pet() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getPhotoUrls() { return photoUrls; }
    public void setPhotoUrls(List<String> photoUrls) { this.photoUrls = photoUrls; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}
