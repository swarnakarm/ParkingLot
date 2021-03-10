package com.gojek.parking.main.instruction;

import com.gojek.parking.inventory.EntryGateSeqNoPriority;
import com.gojek.parking.inventory.exception.InventoryAllocationException;
import com.gojek.parking.lot.ParkingLot;
import com.gojek.parking.main.instruction.exception.InvalidInstructionException;
import com.gojek.parking.main.instruction.executor.InstructionExecutor;
import com.gojek.parking.main.instruction.executor.InstructionExecutorFactory;

/**
 * 
 * @author Manish Swarnakar
 *
 */
public class InstructionProcessor {

	private ParkingLot parkingLot = null;

	public void process(Instruction instruction, String[] additionArgs)
			throws InvalidInstructionException, InventoryAllocationException {
		switch (instruction) {
		case CREATE:
			int parkingLotCount = Integer.parseInt(additionArgs[1]);
			if (parkingLot == null) {
				// Since Entry Gate Priority is Required.
				this.parkingLot = new ParkingLot(parkingLotCount, new EntryGateSeqNoPriority());
			} else {
				throw new InvalidInstructionException("Parking Lot is already created.");
			}
			System.out.println("Created a parking lot with " + parkingLotCount + " slots");
			break;
		case EXIT:
			System.exit(1);
			break;
		default:
			InstructionExecutor instructionExecutor = InstructionExecutorFactory.instantiate(this.parkingLot,
					instruction);
			instructionExecutor.execute(additionArgs);
			break;
		}
	}

}