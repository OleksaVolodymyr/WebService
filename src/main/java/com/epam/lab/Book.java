package com.epam.lab;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Book")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private String title;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [id=" + this.id + ", name=" + this.name + ", title=" + this.title + "]";
	}

}
