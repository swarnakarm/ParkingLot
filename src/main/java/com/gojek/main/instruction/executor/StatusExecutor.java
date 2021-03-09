package com.gojek.main.instruction.executor;

import com.gojek.parking.lot.Parking;

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
