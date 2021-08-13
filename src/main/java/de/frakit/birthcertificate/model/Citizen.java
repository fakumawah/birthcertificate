package de.frakit.birthcertificate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.tomcat.util.buf.HexUtils;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Citizen")
@Table(name = "citizen")
public class Citizen implements Serializable, Specification<Citizen> {

    @Id
    @Column(name = "citizenId", insertable = false, updatable = false, nullable = false)
    @SequenceGenerator(
            name = "citizen_sequence",
            sequenceName = "citizen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "citizen_sequence"
    )
    private Long citizenId;

    @Column(name = "ssn", updatable = false, unique = true)
    private String ssn;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "birthDay", nullable = false)
    private LocalDate birthDay;
    @Column(name = "birthTown", nullable = false)
    private String birthTown;
    @Column(name = "birthRegion", nullable = false)
    private String birthRegion;
    @Column(name = "email")
    private String email;
    @Column(name = "email2")
    private String email2;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "telephone2")
    private String telephone2;
    @Transient
    private Integer age;
    @Column(name = "fatherSsn")
    private Long fatherSsn;
    @Column(name = "motherSsn", nullable = false)
    private Long motherSsn;
    @Column(name = "hospitalId", nullable = false)
    private Long hospitalId;
    @Column(name = "marriageStatus", nullable = false)
    private Enum marriageStatus;
    @Column(name = "sex", nullable = false)
    private Enum sex;
    @Column(name = "comment")
    private String comment;

    @ManyToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "addressId", nullable = false)
    private Address address;

    @CreationTimestamp
    private Instant createdDate;

    @UpdateTimestamp
    private Instant lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "deletedOn")
    private LocalDate deletedOn;

    @PrePersist
    private void prePersistFunction() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!StringUtils.hasText(ssn)) {
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            this.ssn = HexUtils.toHexString(salt.digest());
        }
        this.lastModifiedBy = "Me";
    }


    @Override
    public Predicate toPredicate(Root<Citizen> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (firstName == null) {
            return criteriaBuilder.isTrue(criteriaBuilder.literal(true)); // always true = no filtering
        }
        return criteriaBuilder.equal(root.get("firstName"), firstName);
    }
}
