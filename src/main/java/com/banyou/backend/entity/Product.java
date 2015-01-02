package com.banyou.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

//JPA标识
@Entity
@Table(name = "product")
public class Product extends IdEntity {
	public final static String PIC_SPLIT = ",";
	// 创建
	public final static int STATUS_NEW = 0;
	// 审核中
	public final static int STATUS_IN_AUDIT = 1;
	// 审核通过
	public final static int STATUS_OK = 2;

	private String name;
	private String recommand;
	private int status;
	private BigDecimal price;
	private String url;
	private Integer stock;
	private String pics;
	private Long merchantId;
	private List<Dest> dests = Lists.newArrayList();
	private List<Tag> tags = Lists.newArrayList();

	private List<ProductDesc> descs = Lists.newArrayList();;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecommand() {
		return recommand;
	}

	public void setRecommand(String recommand) {
		this.recommand = recommand;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String target) {
		this.url = target;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getPics() {
		return pics;
	}

	public void setPics(String pics) {
		this.pics = pics;
	}

	// 多对多定义
	@ManyToMany
	@JoinTable(name = "product_has_dest", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "dest_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序
	@OrderBy("name ASC")
	// 缓存策略
	// @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Dest> getDests() {
		return dests;
	}

	public void setDests(List<Dest> dests) {
		this.dests = dests;
	}

	// 多对多定义
	@ManyToMany
	@JoinTable(name = "product_has_tag", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
	// Fecth策略定义
	@Fetch(FetchMode.SUBSELECT)
	// 集合按id排序
	@OrderBy("name ASC")
	// 缓存策略
	// @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	@OneToMany(mappedBy = "product")
	@OrderBy("index ASC")
	public List<ProductDesc> getDescs() {
		return descs;
	}

	public void setDescs(List<ProductDesc> descs) {
		this.descs = descs;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	// tools method
	private final static List<String> EMPTY_PICS = Collections.emptyList();

	@Transient
	public List<String> getImages() {
		String[] urls = StringUtils.split(getPics(), PIC_SPLIT);
		return urls == null ? EMPTY_PICS : Lists.newArrayList(urls);
	}

	@Transient
	public void setImages(String[] images) {
		String pics = StringUtils.join(images, Product.PIC_SPLIT);
		this.setPics(pics);
	}

	@Transient
	@JsonIgnore
	public String getDefaultPic() {
		return getImages().isEmpty() ? "" : getImages().get(0);
	}

	@Transient
	public boolean isSeller(Long merchantId) {
		return this.merchantId != null && merchantId != null
				&& merchantId.equals(this.merchantId);
	}
	@Transient
	public boolean hasTagGroup(Long tagGroupId){
		for(Tag tag:getTags()){
			if(tag.getGroup().getId().equals(tagGroupId)){
				return true;
			}
		}
		return false;
	}

}
