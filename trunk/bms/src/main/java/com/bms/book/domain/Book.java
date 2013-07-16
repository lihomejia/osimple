package com.bms.book.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.bms.base.domain.BaseDomain;

@Entity(name="t_book")
public class Book extends BaseDomain {
	
	@Column(name="book_name", length=100)
	private String bookName;
	
	@Column(name="front_img", columnDefinition="longblob")
	private byte[] frontImg;

}