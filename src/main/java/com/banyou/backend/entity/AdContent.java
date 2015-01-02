package com.banyou.backend.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


//JPA标识
@Entity
@Table(name = "ad_content")
public class AdContent extends IdEntity {

	
	private String url;
	private String pic;
	private String text;

	private int index;

	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getPic() {
		return pic;
	}



	public void setPic(String pic) {
		this.pic = pic;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}


	@Column(name="ad_index")
	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
