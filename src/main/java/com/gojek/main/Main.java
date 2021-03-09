package com.gojek.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.gojek.main.instruction.Instruction;
import com.gojek.main.instruction.InstructionProcessor;
import com.gojek.main.validator.Validator;

public class Main {

	public static void main(String args[]) {
		args = new String[] { "/Users/b0208696/Downloads/parking_lot/functional_spec/fixtures/file_input.txt" };
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
					String command[] = str.split(" ");
					Instruction instruction = Instruction.getInstruction(command[0]);
					processor.execute(instruction, command);
				}
			}
		} catch (Exception ex) {
				System.err.println("Some Invalid Command received.");
				ex.printStackTrace();
		} finally {
			try {
				bfRead.close();
			} catch (Exception ex) {
				System.err.println("Buffered File Read exception");
				ex.printStackTrace();
			}
			try {
				fRead.close();
			} catch (Exception ex) {
				System.err.println("File Read exception");
				ex.printStackTrace();
			}
		}

	}

}
