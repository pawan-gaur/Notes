package com.pgaur.notes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notes", catalog = "notes")
public class Notes {

	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date doc;
	private Date dou;

	public Notes() {
	}

	public Notes(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDoc() {
		return doc;
	}

	public void setDoc(Date doc) {
		this.doc = doc;
	}

	public Date getDou() {
		return dou;
	}

	public void setDou(Date dou) {
		this.dou = dou;
	}

	@Override
	public String toString() {
		return "Notes [title=" + title + ", description=" + description + ", doc=" + doc + ", dou=" + dou + "]";
	}

}