package de.alt.senseless.model.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {

	Account() { // jpa only
	}

	public Account(String name, String password) {
		this.username = name;
		this.password = password;
	}

	@Id
	@GeneratedValue
	private Long id;

	@JsonIgnore
	public String password;

	public String username;

	@OneToMany(mappedBy = "account")
	private Set<Bookmark> bookmarks = new HashSet<>();

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

}
