package com.hotelManagement.hotelManagement.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceUsage {
	
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_usage_ID")
    private long serviceUsageID;

    @Column(name = "time_in")
    private LocalDateTime timeIn;

    @Column(name = "time_out")
    private LocalDateTime timeOut;

    @JsonBackReference(value = "guest-serviceUsage")
    @ManyToOne
    @JoinColumn(name = "guest_ID", referencedColumnName = "guest_ID")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "service_ID", referencedColumnName = "service_ID")
    private Services service;

    @JsonBackReference(value = "reservation-serviceUsage")
    @ManyToOne
    @JoinColumn(name = "staff_ID", referencedColumnName = "staff_ID")
    private Staff staff;

	

    public long getServiceUsageID() {
		return serviceUsageID;
	}

	public void setServiceUsageID(long serviceUsageID) {
		this.serviceUsageID = serviceUsageID;
	}

	public LocalDateTime getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(LocalDateTime timeIn) {
		this.timeIn = timeIn;
	}

	public LocalDateTime getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(LocalDateTime timeOut) {
		this.timeOut = timeOut;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Services getService() {
		return service;
	}

	public void setService(Services service) {
		this.service = service;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}
