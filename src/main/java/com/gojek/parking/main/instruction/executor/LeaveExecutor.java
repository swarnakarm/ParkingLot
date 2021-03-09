package com.gojek.parking.main.instruction.executor;

import com.gojek.parking.inventory.exception.InventoryAllocationException;
import com.gojek.parking.lot.Parking;


/**
 * 
 * @author Manish Swarnakar
 *
 */
public class LeaveExecutor implements InstructionExecutor {

	private Parking parkingLot;

	public LeaveExecutor(Parking parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void execute(String[] additionArgs) {
		try{
			int invSlot = Integer.parseInt(additionArgs[1]);
			parkingLot.leave(invSlot);
			System.out.println("Slot number " + invSlot + " is free");
		} catch(InventoryAllocationException ex){
			System.out.println(ex.getMessage());
		} 
	}

}