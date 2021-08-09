package de.frakit.birthcertificate.model;

import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Entity(name = "Citizen")
@Table(name = "citizen")
public class Citizen implements Serializable {

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
    @Column(name = "createdDate", nullable = false)
    private LocalDate createdDate;
    @Column(name = "lastModifiedDate", nullable = false)
    private LocalDate lastModifiedDate;
    @Column(name = "lastupdatedBy", nullable = false)
    private String lastModifiedBy;
    @Column(name = "imageUrl")
    private String imageUrl;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "deletedOn")
    private LocalDate deletedOn;

    public Citizen(String ssn,
                   String firstName,
                   String lastName,
                   LocalDate birthDay,
                   String birthTown,
                   Region birthRegion,
                   Enum sex,
                   String email,
                   String email2,
                   String telephone,
                   String telephone2,
                   Long fatherSsn,
                   Long motherSsn,
                   Long hospitalId,
                   Enum marriageStatus,
                   String comment,
                   LocalDate createdDate,
                   LocalDate lastModifiedDate,
                   String lastModifiedBy) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthTown = birthTown;
        this.birthRegion = birthRegion.code();
        this.sex = sex;
        this.email = email;
        this.email2 = email2;
        this.telephone = telephone;
        this.telephone2 = telephone2;
        this.fatherSsn = fatherSsn;
        this.motherSsn = motherSsn;
        this.hospitalId = hospitalId;
        this.marriageStatus = marriageStatus;
        this.comment = comment;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Citizen() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getBirthRegion() {
        return birthRegion;
    }

    public void setBirthRegion(String birthRegion) {
        this.birthRegion = birthRegion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthTown() {
        return birthTown;
    }

    public Enum getSex() {
        return sex;
    }

    public void setSex(Enum sex) {
        this.sex = sex;
    }

    public void setBirthTown(String birthTown) {
        this.birthTown = birthTown;
    }

    public Long getFatherSsn() {
        return fatherSsn;
    }

    public void setFatherSsn(Long fatherSsn) {
        this.fatherSsn = fatherSsn;
    }

    public Long getMotherSsn() {
        return motherSsn;
    }

    public void setMotherSsn(Long motherSsn) {
        this.motherSsn = motherSsn;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Enum getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Enum marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDate getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDate deletedOn) {
        this.deletedOn = deletedOn;
    }

    @PrePersist
    private void prePersistFunction() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (!StringUtils.hasText(ssn)) {
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            this.ssn = HexUtils.toHexString(salt.digest());
        }
        this.createdDate = LocalDate.now();
        this.lastModifiedDate = LocalDate.now();
        this.lastModifiedBy = "Me";
    }

    @PreUpdate
    private void preUpdateFunction() {
        this.lastModifiedDate = LocalDate.now();
        this.lastModifiedBy = "Me";
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", birthTown='" + birthTown + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", telephone='" + telephone + '\'' +
                ", telephone2='" + telephone2 + '\'' +
                ", age=" + age +
                ", fatherSsn=" + fatherSsn +
                ", motherSsn=" + motherSsn +
                ", hospitalId=" + hospitalId +
                ", marriageStatus=" + marriageStatus +
                ", sex=" + sex +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy='" + lastModifiedBy + '\'' +
                '}';
    }
}
