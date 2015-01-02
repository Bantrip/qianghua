package com.banyou.backend.entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;


//JPA标识
@Entity
@Table(name = "ad_position")
public class AdPosition extends IdEntity {

	public final static AdPosition EMPTY_POSITION=new AdPosition();
	private String name;
	private String code;
	private List<AdContent> content=Lists.newArrayList();
	public AdPosition() {
	super();
	}

	public AdPosition(Long destId) {
	super(destId);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@OneToMany
	@JoinColumn(name="ad_position_id")
	@OrderBy("index desc")
	public List<AdContent> getContent() {
		return content;
	}

	public void setContent(List<AdContent> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
