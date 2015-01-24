package com.banyou.backend.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;


//JPA标识
@Entity
@Table(name = "dest")
public class Dest extends IdEntity {

	public static final int TYPE_CONTURY = 0;
	public static final int TYPE_CITY = 1;
	private String name;
	private int type = TYPE_CONTURY;

	public Dest() {
	super();
	}

	public Dest(Long destId) {
	super(destId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
