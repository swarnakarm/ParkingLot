package com.gojek.parking.main.instruction;

import com.gojek.parking.main.instruction.exception.InvalidInstructionException;

/**
 * 
 * @author Manish Swarnakar
 *
 */
public enum Instruction {

	CREATE("create_parking_lot"),PARK("park"), LEAVE("leave"), STATUS("status"), 
	COLOR_CAR_REGISTRATION_STATUS("registration_numbers_for_cars_with_colour"), EXIT("exit");
	
	private String instructionCode;
	
	private Instruction(String instructionCode){
		this.instructionCode = instructionCode;
	}

	public static Instruction getInstruction(String instr) throws Exception {
		for(Instruction ins :Instruction.values()){
			if(ins.instructionCode.equals(instr)){
				return ins;
			}
		}
		throw new InvalidInstructionException("Instruction Not Found - "+instr);
	}
	
}
