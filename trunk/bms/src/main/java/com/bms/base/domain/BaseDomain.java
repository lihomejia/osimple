package com.bms.base.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.bms.base.util.BaseDto;
import com.bms.base.util.Dto;


@MappedSuperclass
public class BaseDomain {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer 	id;
	
	@Column(name="cuser_id", columnDefinition="int default 0")
	private Integer 	cuserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 		cdate;
	
	@Column(name="uuser_id", columnDefinition="int default 0")
	private Integer 	uuserId;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date 		udate;
	
	@Transient
	private Dto  disp = new BaseDto();

	@Override
	public String toString() {
		return BaseDomainlUtil.toString(this);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCuserId() {
		return cuserId;
	}

	public void setCuserId(Integer cuserId) {
		this.cuserId = cuserId;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Integer getUuserId() {
		return uuserId;
	}

	public void setUuserId(Integer uuserId) {
		this.uuserId = uuserId;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public Dto getDisp() {
		return disp;
	}

	public void setDisp(Dto disp) {
		this.disp = disp;
	}
}
