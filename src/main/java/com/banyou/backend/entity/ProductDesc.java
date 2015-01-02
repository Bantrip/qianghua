package com.banyou.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

//JPA标识
@Entity
@Table(name = "product_desc")
public class ProductDesc extends IdEntity {
	public final static int TYPE_DESC = 0;
	public final static int TYPE_IMG = 1;
	private String content;
	private int index;
	private int type = TYPE_DESC;
	private Product product;

	public ProductDesc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDesc(String content, int index) {
		this.content = content;
		this.index = index;
		// 图片
		if (StringUtils.isNotBlank(content)
				&& StringUtils.startsWithIgnoreCase(content, "http://")) {
			this.type = TYPE_IMG;
		}

	}
@Column(name="desc_index")
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
