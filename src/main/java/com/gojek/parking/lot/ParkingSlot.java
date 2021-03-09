package com.gojek.parking.lot;

public class ParkingSlot {

	public ParkingSlot() {
	}

	public ParkingSlot(int parkingSeq) {
		this.parkingSeq = parkingSeq;
	}

	private int parkingSeq;

	public int getParkingSeq() {
		return parkingSeq;
	}

	public void setParkingSeq(int parkingSeq) {
		this.parkingSeq = parkingSeq;
	}

}