package com.banyou.backend.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//JPA标识
@Entity
@Table(name = "tag")
public class Tag extends IdEntity {
	private String name;
	private TagGroup group;

	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tag(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	@Fetch(FetchMode.JOIN)
	public TagGroup getGroup() {
		return group;
	}

	public void setGroup(TagGroup group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Tag [name=" + name + ", group=" + group + "]";
	}

}
