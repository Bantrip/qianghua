package com.banyou.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="merchant")
public class Merchant extends IdEntity {
	
	public static final Merchant NULL=new Merchant(){

		@Override
		public String getName() {
			return null;
		}

		@Override
		public int getType() {
			return TYPE_UNKNOW;
		}
		
	};
	
	public static final int TYPE_OWN = 0;

	public static final int TYPE_THIRD_PART = 1;
	public static final int TYPE_UNKNOW=-1;
	private String name;
	private int type = TYPE_UNKNOW;// 0自营，1第三方

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

}
