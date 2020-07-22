package com.servus.db;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserve {
	Integer reserveId;
	String userId;
	Integer serviceId;
	LocalDate reserveDate;
	LocalTime reserveStart;
	LocalTime reserveEnd;
	String status;
	int score;

	public Reserve(Integer reserveId, String userId, Integer serviceId, LocalDate reserveDate, LocalTime reserveStart,
			LocalTime reserveEnd, String status, int score) {
		this.reserveId = reserveId;
		this.userId = userId;
		this.serviceId = serviceId;
		this.reserveDate = reserveDate;
		this.reserveStart = reserveStart;
		this.reserveEnd = reserveEnd;
		this.status = status;
		this.score = score;
	}

	public Reserve() {
	}

	public Integer getReserveId() {
		return reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public LocalDate getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
	}

	public LocalTime getReserveStart() {
		return reserveStart;
	}

	public void setReserveStart(LocalTime reserveStart) {
		this.reserveStart = reserveStart;
	}

	public LocalTime getReserveEnd() {
		return reserveEnd;
	}

	public void setReserveEnd(LocalTime reserveEnd) {
		this.reserveEnd = reserveEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}