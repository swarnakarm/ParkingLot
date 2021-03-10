package com.gojek.parking.instruction;

import org.junit.Test;

import com.gojek.parking.main.instruction.Instruction;
import com.gojek.parking.main.instruction.InstructionProcessor;
import com.gojek.parking.main.instruction.exception.InvalidInstructionException;

public class InstructionProcessorTest {

	
	@Test(expected = InvalidInstructionException.class)
	public void instructionTest_create2ParkingLot() throws Exception {
		InstructionProcessor processor = new InstructionProcessor();
		processor.process(Instruction.CREATE, new String[]{"create_parking_lot","6"});
		processor.process(Instruction.CREATE, new String[]{"create_parking_lot","6"});
	}
	
	@Test
	public void instructionTest_createParkingValid() throws Exception {
		InstructionProcessor processor = new InstructionProcessor();
		processor.process(Instruction.CREATE, new String[]{"create_parking_lot","6"});
	}
	
	@Test
	public void instructionTest_OtherValidInstruction() throws Exception {
		InstructionProcessor processor = new InstructionProcessor();
		processor.process(Instruction.CREATE, new String[]{"create_parking_lot","6"});
		processor.process(Instruction.PARK, new String[]{"park","KA-01-P-333", "White"});
		processor.process(Instruction.LEAVE, new String[]{"leave","4"});
		processor.process(Instruction.STATUS, new String[]{"status"});
		processor.process(Instruction.STATUS, 
				new String[]{"registration_numbers_for_cars_with_colour","White"});
	}
	
	
}
