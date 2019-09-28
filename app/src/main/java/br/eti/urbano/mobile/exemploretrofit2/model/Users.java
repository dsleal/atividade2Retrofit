package br.eti.urbano.mobile.exemploretrofit2.model;

public class Users {
    public int id;
    public String name;
    public String username;
    public String email;
    public String address;
    public String phone;
    public String website;
    public String company;

    public Users() {    }

    public Users(int id, String name, String username, String email, String address, String phone, String website, String company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + getId() + ", " +
                "name:" + getName() + ", " +
                "username:" + getUsername() + ", " +
                "email:" + getEmail() + ", " +
                "phone:" + getPhone() + ", " +
                "website:" + getWebsite() + " " +
                "}";
    }
}

