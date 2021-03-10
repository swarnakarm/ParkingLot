package com.gojek.parking.inventory;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parking.main.validator.Validator;


public class ValidatorTest {

	//1. Test Create Command
	@Test
	public void testCreateCommand(){
		boolean flag = Validator.validateCommand("create_parking_lot 6");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	@Test
	public void testCreateCommand_false(){
		boolean flag = Validator.validateCommand("create_parking_lot");
		Assert.assertEquals("Flag should be false", flag, false);
	}
	
	@Test
	public void testCreateCommand_false2(){
		boolean flag = Validator.validateCommand("create_parking_lot 0");
		Assert.assertEquals("Flag should be false", flag, false);
	}
	
	@Test
	public void testCreateCommand_false3(){
		boolean flag = Validator.validateCommand("create_parking_lot a");
		Assert.assertEquals("Flag should be false", flag, false);
	}
	
	//2. Test park command.
	@Test
	public void testParkCommand(){
		boolean flag = Validator.validateCommand("park KA-01-HH-1234 White");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	@Test
	public void testParkCommand_noCarDetail(){
		boolean flag = Validator.validateCommand("park");
		Assert.assertEquals("Flag should be true", flag, false);
	}
	
	@Test
	public void testParkCommand_noCarColor(){
		boolean flag = Validator.validateCommand("park KA-01-HH-1234");
		Assert.assertEquals("Flag should be true", flag, false);
	}
	
	
	//3. Test leave command.
	@Test
	public void testLeaveCommand(){
		boolean flag = Validator.validateCommand("leave 4");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	@Test
	public void testLeaveCommand_noSlotDetail(){
		boolean flag = Validator.validateCommand("leave");
		Assert.assertEquals("Flag should be true", flag, false);
	}
	
	@Test
	public void testLeaveCommand_invalidSlotDetail(){
		boolean flag = Validator.validateCommand("leave a");
		Assert.assertEquals("Flag should be true", flag, false);
	}
	
	//4. Color Status.
	@Test
	public void testColorStatusCommand(){
		boolean flag = Validator.validateCommand("registration_numbers_for_cars_with_colour White");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	@Test
	public void testColorStatusCommand_noColor(){
		boolean flag = Validator.validateCommand("registration_numbers_for_cars_with_colour");
		Assert.assertEquals("Flag should be true", flag, false);
	}
	
	
	@Test
	public void testStatusCommand(){
		boolean flag = Validator.validateCommand("status");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	@Test
	public void testExitCommand(){
		boolean flag = Validator.validateCommand("exit");
		Assert.assertEquals("Flag should be true", flag, true);
	}
	
	
}