package de.frakit.birthcertificate.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Address")
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "addressId", insertable = false, updatable = false, nullable = false)
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private Long address_id;
    private String street;
    private Integer house_nr;
    private String extra;
    private String postcode;
    private String town;
    private Region region;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;
    private String lastupdatedBy;

    public Address(String street, Integer house_nr, String extra, String postcode, String town, Region region, LocalDate createdDate, LocalDate lastModifiedDate, String lastupdatedBy) {
        this.street = street;
        this.house_nr = house_nr;
        this.extra = extra;
        this.postcode = postcode;
        this.town = town;
        this.region = region;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.lastupdatedBy = lastupdatedBy;
    }

    public Address() {
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse_nr() {
        return house_nr;
    }

    public void setHouse_nr(Integer house_nr) {
        this.house_nr = house_nr;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastupdatedBy() {
        return lastupdatedBy;
    }

    public void setLastupdatedBy(String lastupdatedBy) {
        this.lastupdatedBy = lastupdatedBy;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", street='" + street + '\'' +
                ", house_nr=" + house_nr +
                ", extra='" + extra + '\'' +
                ", postcode='" + postcode + '\'' +
                ", town='" + town + '\'' +
                ", region=" + region +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastupdatedBy='" + lastupdatedBy + '\'' +
                '}';
    }
}
