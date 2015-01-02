package com.banyou.backend.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.google.common.collect.Lists;

//JPA标识
@Entity
@Table(name = "tag_group")
public class TagGroup extends IdEntity{
private String name;

private List<Tag> tags=Lists.newArrayList();

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Transient
public List<Tag> getTags() {
	return tags;
}
public void setTags(List<Tag> tags) {
	this.tags = tags;
}


}
