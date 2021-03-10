package com.gojek.parking.main.validator;

import com.gojek.parking.main.instruction.Instruction;

/**
 * 
 * @author Manish Swarnakar
 *
 */
public class Validator {

	public static boolean validateCommand(String str) {
		String command[] = str.split(" ");
		Instruction key = isRegisteredInstruction(command[0]);
		if (key != null) {
			switch (key) {
			case CREATE:
				if (command.length != 2) {
					return false;
				} else {
					 try{
						 int lotCount = Integer.parseInt(command[1]);
						 if(lotCount < 1){
							 return false;
						 }
					 } catch(Exception ex){
						 return false;
					 }
				}
				break;
			case PARK:
				if (command.length != 3) {
					/**
					 * Can also keep RegExp validation for Car registration No.
					 * And Colour check as well.
					 */
					return false;
				}
				break;
			case LEAVE:
				if (command.length != 2){
					return false;
				} else {
					try{
						 int lotCount = Integer.parseInt(command[1]);
						 if(lotCount < 1){
							 return false;
						 }
					 } catch(Exception ex){
						 return false;
					 }
				}
				break;
			case COLOR_CAR_REGISTRATION_STATUS:
				if (command.length != 2) {
					return false;
				}
				break;
			default:
				return true;
			}
		}  else{
			return false;
		}
		return true;
	}

	static Instruction isRegisteredInstruction(String keyword) {
		try {
			return Instruction.getInstruction(keyword);
		} catch (Exception ex) {
			// If instruction is not valid, an Exception can occur.
			// Do Nothing.
		}
		return null;
	}

}
