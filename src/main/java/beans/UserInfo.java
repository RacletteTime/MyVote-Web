package main.java.beans;

import java.util.Date;

/**
 * Created by pierre on 18/10/2017.
 */

public class UserInfo {
    private String id;
    private String cp;
    private String city;
    private Date birthdate;
    private Gender gender;
    private String nationality;
    private enum Gender {
        MALE,
        FEMALE
    }

    public UserInfo(String id, String cp, String city, Date birthdate, Gender gender, String nationality) {
        this.id = id;
        this.cp = cp;
        this.city = city;
        this.birthdate = birthdate;
        this.gender = gender;
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
