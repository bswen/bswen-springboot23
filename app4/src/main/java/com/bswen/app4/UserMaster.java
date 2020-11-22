package com.bswen.app4;

public class UserMaster {
    private int id;
    private String name;
    private String emailid;
    private String photono;
    private String location;

    public UserMaster(int id, String name, String emailid, String photono, String location) {
        this.id = id;
        this.name = name;
        this.emailid = emailid;
        this.photono = photono;
        this.location = location;
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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhotono() {
        return photono;
    }

    public void setPhotono(String photono) {
        this.photono = photono;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "UserMaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailid='" + emailid + '\'' +
                ", photono='" + photono + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
