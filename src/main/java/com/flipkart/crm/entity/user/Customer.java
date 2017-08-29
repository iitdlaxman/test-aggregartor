package com.flipkart.crm.entity.user;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.interview.Request;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by Vikram Aditya on 6/23/2017.
 */
@Entity
@Table(name="Customer")
/*
@DynamicUpdate
@SelectBeforeUpdate(value=true)
*/
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String accountId;
    private String firstName;
    private String lastName;
    private String contact;
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateOfJoining;
    private String email;
    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private Role role;
    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id", nullable = false)
    private Location location;
    @JsonIgnore
    private String password;
    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    private Company company;
    private String status;
    private int balance;


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Attribute> attributes;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<SkillRating> skillRatings;

   /* @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<CXRating> cxRatings;
*/
    @OneToMany(mappedBy = "candidateId", fetch = FetchType.EAGER)
    private List<Interview> candidature;

    @OneToMany(mappedBy = "interviewerId", fetch = FetchType.EAGER)
    private List<Interview> interviews;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER)
    private List<Request> requests;

    @OneToMany(mappedBy = "customerId", fetch = FetchType.EAGER)
    private List<Qualifications> qualifications;

    public Customer() {
    }

    public boolean equals(Customer o) {
        if(o.id == null) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public DateTime getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(DateTime dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<SkillRating> getSkillRatings() {
        return skillRatings;
    }

    public void setSkillRatings(List<SkillRating> skillRatings) {
        this.skillRatings = skillRatings;
    }

    public List<Interview> getCandidature() {
        return candidature;
    }

    public void setCandidature(List<Interview> candidature) {
        this.candidature = candidature;
    }

    public List<Interview> getInterviews() {
        return interviews;
    }

    public void setInterviews(List<Interview> interviews) {
        this.interviews = interviews;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Qualifications> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualifications> qualifications) {
        this.qualifications = qualifications;
    }
}
