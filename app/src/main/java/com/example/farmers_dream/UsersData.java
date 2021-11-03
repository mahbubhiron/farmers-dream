package com.example.farmers_dream;

public class UsersData {
    private String userId;
    private String username;
    private String phone_number;
    private String email;
    private String password;
    private String voter_id;
    private String division;
    private String district;
    private String up;
    private String un;
    private String village;
    private String imageUrl;

    public UsersData(String userId, String username, String phone_number, String email,
                     String password, String voter_id, String division, String district,
                     String up, String un, String village, String imageURL) {
        this.userId = userId;
        this.username = username;
        this.phone_number = phone_number;
        this.email = email;
        this.password = password;
        this.voter_id = voter_id;
        this.division = division;
        this.district = district;
        this.up = up;
        this.un = un;
        this.village = village;
        this.imageUrl = imageURL;
    }

    public UsersData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(String voter_id) {
        this.voter_id = voter_id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getUn() {
        return un;
    }

    public void setUn(String un) {
        this.un = un;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getImageURL() {
        return imageUrl;
    }

    public void setImageURL(String imageURL) {
        this.imageUrl = imageURL;
    }
}

