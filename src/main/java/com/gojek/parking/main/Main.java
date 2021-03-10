package com.gojek.parking.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.gojek.parking.main.instruction.Instruction;
import com.gojek.parking.main.instruction.InstructionProcessor;
import com.gojek.parking.main.validator.Validator;

/**
 * 
 * @author Manish Swarnakar
 *
 */

public class Main {

	public static void main(String args[]) {
//		args = new String[] { "/Users/b0208696/Downloads/parking_lot/functional_spec/fixtures/file_input.txt" };
		File file = new File(args[0]);
		FileReader fRead = null;
		BufferedReader bfRead = null;
		try {
			fRead = new FileReader(file);
			bfRead = new BufferedReader(fRead);
			String str;
			InstructionProcessor processor = new InstructionProcessor();
			while ((str = bfRead.readLine()) != null) {
				System.out.println(str);
				if(Validator.validateCommand(str)){
					String instructionLine[] = str.split(" ");
					Instruction instruction = Instruction.getInstruction(instructionLine[0]);
					processor.process(instruction, instructionLine);
				} else {
					System.out.println("Invalid Command.");
				}
			}
		}  catch (Exception ex) {
				System.err.println("Some Exception occurred.");
				ex.printStackTrace();
		} finally {
			try {
				bfRead.close();
			} catch (Exception ex) {
				System.err.println("Buffered File Read exception");
			}
			try {
				fRead.close();
			} catch (Exception ex) {
				System.err.println("File Read exception");
			}
		}

	}

}