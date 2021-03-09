package com.gojek.main.instruction.executor;

import com.gojek.main.instruction.Instruction;
import com.gojek.parking.lot.Parking;

/**
 * 
 * @author Manish Swarnakar
 *
 */
public class InstructionExecutorFactory {

	public static InstructionExecutor instantiate(Parking parkingLot, 
			Instruction instruction) {
			switch(instruction){
				case PARK:
					return new ParkExecutor(parkingLot);
				case LEAVE:
					return new LeaveExecutor(parkingLot);
				case STATUS:
					return new StatusExecutor(parkingLot);
				case COLOR_CAR_REGISTRATION_STATUS:
					return new ColorCarStatusExecutor(parkingLot);
				default: 
					return null;
			}
	}

}
