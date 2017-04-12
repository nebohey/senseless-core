package de.alt.senseless.model.entities;

import de.alt.senseless.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
public class Address {

    public Address() { // jpa only

    }

    public Address(String name, String ip) {
        this.name = name;
        this.ip = ip;
        this.created = new Date();
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Pattern(regexp = Constants.IPADDRESS_PATTERN, message = "must be a valid IP address")
    private String ip;

    private Date created;

    private Date lastUpdate;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public Date getCreated() {
        return created;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }
}
