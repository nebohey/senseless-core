package de.alt.senseless.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AuthToken {

	AuthToken() { // jpa only
	}

	public AuthToken(Account account, String token) {
		this.account = account;
		this.token = token;
		this.validUntil = new DateTime().plusMinutes(30).toDate();
	}

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	@OneToOne
	private Account account;

	private String token;

	private Date validUntil;

	public Account getAccount() {
		return account;
	}

	public String getToken() {
		return token;
	}

	public Date getValidUntil() {
		return validUntil;
	}

}
