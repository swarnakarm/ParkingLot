package com.gojek.parking.main.instruction.executor;

import com.gojek.parking.inventory.exception.InventoryAllocationException;
import com.gojek.parking.lot.Car;
import com.gojek.parking.lot.ParkingLot;


/**
 * 
 * @author Manish Swarnakar
 *
 */
public class ParkExecutor implements InstructionExecutor{

	private ParkingLot parkingLot;
	
	public ParkExecutor(ParkingLot parkingLot){
		this.parkingLot = parkingLot;
	}
	
	@Override
	public void execute(String[] additionArgs){
		try{
			Car car = new Car(additionArgs[1], additionArgs[2]);
			int invSlot = this.parkingLot.park(car);
			System.out.println("Allocated slot number: " + invSlot);
		} catch(InventoryAllocationException ex){
			System.out.println("Sorry, parking lot is full");
		}
	}
	
}
