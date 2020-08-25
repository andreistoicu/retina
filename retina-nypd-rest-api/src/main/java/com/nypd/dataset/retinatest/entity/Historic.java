package com.nypd.dataset.retinatest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="historic")
public class Historic {
	
	//define fields
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id ;
	
	@Column(name="cmplnt_num")
	private int cmplntNum ;
	
	@Column(name="ky_cd")
	private int kyCd ;
	

	public Historic() {
	}

	public Historic(int cmplntNum, int kyCd) {
		this.cmplntNum = cmplntNum;
		this.kyCd = kyCd;
	}
	
	//Region transient

	@Transient
	@Column(name="total_events")
	private int totalEvents ;
	
	public Historic(int id, int cmplntNum, int kyCd, int totalEvents) {
		this.id = id;
		this.cmplntNum = cmplntNum;
		this.kyCd = kyCd;
		this.totalEvents = totalEvents;
	}

	public int getTotalEvents() {
		return totalEvents;
	}

	public void setTotalEvents(int totalEvents) {
		this.totalEvents = totalEvents;
	}
	
	//endtransient 
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCmplntNum() {
		return cmplntNum;
	}

	public void setCmplntNum(int cmplntNum) {
		this.cmplntNum = cmplntNum;
	}

	public int getKyCd() {
		return kyCd;
	}

	public void setKyCd(int kyCd) {
		this.kyCd = kyCd;
	}

	@Override
	public String toString() {
		return "Historic3 [id=" + id + ", cmplntNum=" + cmplntNum + ", kyCd=" + kyCd + "]";
	}
	
}
