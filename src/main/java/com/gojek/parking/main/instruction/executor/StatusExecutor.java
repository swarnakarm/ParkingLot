package com.gojek.parking.main.instruction.executor;

import com.gojek.parking.lot.Parking;
/**
 * 
 * @author Manish Swarnakar
 *
 */
public class StatusExecutor implements InstructionExecutor {

	private Parking parkingLot;

	public StatusExecutor(Parking parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void execute(String[] additionArgs) {
		parkingLot.status();
	}

	
}
