package com.hotelManagement.hotelManagement.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    public Long getRoomID() {
		return roomID;
	}

	public void setRoomID(Long roomID) {
		this.roomID = roomID;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPpn() {
		return ppn;
	}

	public void setPpn(double ppn) {
		this.ppn = ppn;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_ID")
    private Long roomID;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "room_status")
    private String roomStatus;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "price_per_night")
    private double ppn;

    @Column(name = "num_people")
    private int capacity;

    //    @JsonManagedReference(value = "reservation-room")
    @JsonBackReference(value = "reservation-room")
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;
}
