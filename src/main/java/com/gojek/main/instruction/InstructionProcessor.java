package com.gojek.main.instruction;

import com.gojek.main.instruction.executor.InstructionExecutor;
import com.gojek.main.instruction.executor.InstructionExecutorFactory;
import com.gojek.parking.inventory.EntryGatePriority;
import com.gojek.parking.lot.Parking;

public class InstructionProcessor {

	private Parking parkingLot;

	public void execute(Instruction instruction, String[] additionArgs) {
		switch (instruction) {
		case CREATE:
			int parkingLotCount = Integer.parseInt(additionArgs[1]);
			//Since Entry Gate Priority is Required.
			this.parkingLot = new Parking(parkingLotCount, new EntryGatePriority());
			System.out.println("Created a parking lot with " + parkingLotCount + " slots");
			break;
		case EXIT:
			System.exit(1);
			break;
		default:
			InstructionExecutor instructionExecutor = InstructionExecutorFactory.instantiate(this.parkingLot, instruction);
			instructionExecutor.execute(additionArgs);
			break;
		}
	}

}