package com.gojek.parking.inventory;

import org.junit.Assert;
import org.junit.Test;

import com.gojek.parking.inventory.exception.InventoryAllocationException;
import com.gojek.parking.lot.ParkingSlot;

public class InventroryAllocationTest {

	/**
	 * 1. Test for SeqNo Order. 
	 * Add 5 seqNo and Allocate all 5 inventory. 
	 * Release SeqNo 5 then 2 then Allocate 1 inventory.
	 * Assertion: SeqNo should be 2. 
	 * Entry Gate Priority applied.
	 */
	@Test
	public void inventoryOrderTest() throws Exception {
		ParkingInventory parkInv = new ParkingInventory(5, new EntryGatePriority());
		ParkingSlot slot1 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 1", slot1.getParkingSeq(), 1);

		ParkingSlot slot2 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 2", slot2.getParkingSeq(), 2);

		ParkingSlot slot3 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 3", slot3.getParkingSeq(), 3);

		ParkingSlot slot4 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 4", slot4.getParkingSeq(), 4);

		ParkingSlot slot5 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 5", slot5.getParkingSeq(), 5);

		// Add back SeqNo.5
		parkInv.addInventory(new ParkingSlot(5));

		// Add back SeqNo.2
		parkInv.addInventory(new ParkingSlot(2));

		ParkingSlot slotTest = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 2", slotTest.getParkingSeq(), 2);
	}

	/**
	 * 2. Test for Invalid SeqNo Order. Add 5 seqNo and Allocate all 5
	 * inventory. Release SeqNo 6 - Invalid SeqNo.
	 */
	@Test(expected = InventoryAllocationException.class)
	public void inventoryInvalidSeqNoAdded() throws Exception {
		ParkingInventory parkInv = new ParkingInventory(5, new EntryGatePriority());
		ParkingSlot slot1 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 1", slot1.getParkingSeq(), 1);

		ParkingSlot slot2 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 2", slot2.getParkingSeq(), 2);

		ParkingSlot slot3 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 3", slot3.getParkingSeq(), 3);

		ParkingSlot slot4 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 4", slot4.getParkingSeq(), 4);

		ParkingSlot slot5 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 5", slot5.getParkingSeq(), 5);

		// Add back Invalid SeqNo.6
		parkInv.addInventory(new ParkingSlot(6));
	}

	/**
	 * 
	 * 3. Test for Invalid SeqNo Order. Add 5 seqNo and Allocate all 5 inventory
	 * Release SeqNo 5, then release seqNo 5 again. - Invalid SeqNo.
	 */
	@Test(expected = InventoryAllocationException.class)
	public void inventoryAddAlreadyPresentSeqNo() throws Exception {
		ParkingInventory parkInv = new ParkingInventory(5, new EntryGatePriority());
		ParkingSlot slot1 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 1", slot1.getParkingSeq(), 1);

		ParkingSlot slot2 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 2", slot2.getParkingSeq(), 2);

		ParkingSlot slot3 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 3", slot3.getParkingSeq(), 3);

		ParkingSlot slot4 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 4", slot4.getParkingSeq(), 4);

		ParkingSlot slot5 = parkInv.removeInv();
		Assert.assertEquals("SeqNo should be 5", slot5.getParkingSeq(), 5);

		// Add back SeqNo.5
		parkInv.addInventory(new ParkingSlot(5));

		// Add again SeqNo.5
		parkInv.addInventory(new ParkingSlot(5));

	}

}