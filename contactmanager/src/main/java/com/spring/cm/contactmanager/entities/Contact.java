package com.spring.cm.contactmanager.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;

    @Override
    public String toString() {
        return "{" +
            " cid='" + getCid() + "'" +
            ", name='" + getName() + "'" +
            ", secondname='" + getSecondname() + "'" +
            ", work='" + getWork() + "'" +
            ", email='" + getEmail() + "'" +
            ", imagepath='" + getImagepath() + "'" +
            ", phone='" + getPhone() + "'" +
            ", description='" + getDescription() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }
    private  String secondname;
    private String work;
    private String email;
    private String imagepath;
    private long phone;
    @Column(length = 1000)
    private String description;

    @ManyToOne
    private User user; 


    /**
     * @return int return the cid
     */
    public int getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(int cid) {
        this.cid = cid;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the secondname
     */
    public String getSecondname() {
        return secondname;
    }

    /**
     * @param secondname the secondname to set
     */
    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    /**
     * @return String return the work
     */
    public String getWork() {
        return work;
    }

    /**
     * @param work the work to set
     */
    public void setWork(String work) {
        this.work = work;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the imagepath
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * @param imagepath the imagepath to set
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    /**
     * @return long return the phone
     */
    public long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(long phone) {
        this.phone = phone;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}