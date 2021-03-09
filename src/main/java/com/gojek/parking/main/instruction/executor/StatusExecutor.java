package com.gojek.parking.main.instruction.executor;

import com.gojek.parking.lot.ParkingLot;
/**
 * 
 * @author Manish Swarnakar
 *
 */
public class StatusExecutor implements InstructionExecutor {

	private ParkingLot parkingLot;

	public StatusExecutor(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void execute(String[] additionArgs) {
		parkingLot.status();
	}

	
}
