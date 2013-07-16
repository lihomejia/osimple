package com.bms.book.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.bms.base.domain.BaseDomain;

@Entity(name="t_book")
public class Book extends BaseDomain {
	
	@Column(name="book_name", length=100)
	private String bookName;
	
	@Column(length=100)
	private String author;
	
	@Column
	private Integer press;
	
	@Temporal(TemporalType.DATE)
	@Column(name="publication_date")
	private Date publicationDate;
	
	@Column(name="edition")
	private Integer edition;
	
	@Column(length=10)
	private String isbn;
	
	@Column(name="category_id")
	private Integer categoryId;
	
	@Column
	private Integer pages;
	
	@Column(name="editor_recommend", length=512)
	private String editorRecommend;

	@Column(length=512)
	private String description;

	@Column(name="author_desc", length=512)
	private String authorDesc;
	
	@Column(name="front_img", columnDefinition="longblob")
	private byte[] frontImg;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPress() {
		return press;
	}

	public void setPress(Integer press) {
		this.press = press;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getEditorRecommend() {
		return editorRecommend;
	}

	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthorDesc() {
		return authorDesc;
	}

	public void setAuthorDesc(String authorDesc) {
		this.authorDesc = authorDesc;
	}

	public byte[] getFrontImg() {
		return frontImg;
	}

	public void setFrontImg(byte[] frontImg) {
		this.frontImg = frontImg;
	}
}