package com.gojek.main.instruction.executor;

import com.gojek.parking.lot.Parking;

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
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

}