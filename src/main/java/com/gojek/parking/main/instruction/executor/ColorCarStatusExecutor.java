package com.gojek.parking.main.instruction.executor;

import java.util.Set;

import com.gojek.parking.lot.Car;
import com.gojek.parking.lot.Parking;


/**
 * 
 * @author Manish Swarnakar
 *
 */
public class ColorCarStatusExecutor implements InstructionExecutor {

	private Parking parkingLot;

	public ColorCarStatusExecutor(Parking parkingLot) {
		this.parkingLot = parkingLot;
	}

	@Override
	public void execute(String[] additionArgs) {
		Set<Integer> seqNoSet = parkingLot.slotForColour(additionArgs[1].toLowerCase());
		for (Integer seqNo : seqNoSet) {
			Car car = parkingLot.carInSlot(seqNo);
			System.out.print(car.getRegistrationNo() + " ");
		}
	}
}
