package com.gojek.main.instruction.executor;

import com.gojek.parking.lot.Car;
import com.gojek.parking.lot.Parking;

public class ParkExecutor implements InstructionExecutor{

	private Parking parkingLot;
	
	public ParkExecutor(Parking parkingLot){
		this.parkingLot = parkingLot;
	}
	
	@Override
	public void execute(String[] additionArgs){
		try{
			Car car = new Car(additionArgs[1], additionArgs[2]);
			int invSlot = parkingLot.park(car);
			System.out.println("Allocated slot number: " + invSlot);
		} catch(Exception ex){
			System.out.println("Sorry, parking lot is full");
		}
	}
	
}
