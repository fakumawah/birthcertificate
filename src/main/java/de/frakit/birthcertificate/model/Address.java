package de.frakit.birthcertificate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Long addressId;

//    @OneToMany(targetEntity = Citizen.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="citizen_id", referencedColumnName = "citizen_id")
//    private Set<Citizen> citizens;

    @Column(name = "street")
    private String street;
    @Column(name = "house_nr")
    private Integer house_nr;
    @Column(name = "extra")
    private String extra;
    @Column(name = "postcode")
    private String postcode;
    @Column(name = "town")
    private String town;
    @Column(name = "region")
    private Region region;
    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;
    @Column(name = "lastModifiedDate", nullable = false)
    private LocalDate lastModifiedDate;
    @Column(name = "lastupdatedBy", nullable = false)
    private String lastModifiedBy;

    public Address(String street, Integer house_nr, String town) {
        this.street = street;
        this.house_nr = house_nr;
        this.town = town;
    }

    @PrePersist
    private void prePersistFunction() {
        this.createdDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.lastModifiedBy = "Me";
    }

    @PreUpdate
    private void preUpdateFunction() {
        this.lastModifiedDate = LocalDate.now();
        this.lastModifiedBy = "Me";
    }
}
