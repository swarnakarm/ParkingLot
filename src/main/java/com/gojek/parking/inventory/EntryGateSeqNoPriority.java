package com.gojek.parking.inventory;

import com.gojek.parking.lot.ParkingSlot;

/**
 * 
 * @author Manish Swarnakar
 *
 */
public class EntryGateSeqNoPriority implements InventoryAllocationStrategy {

	@Override
	public int compare(ParkingSlot val1, ParkingSlot val2) {
		return Integer.compare(val1.getParkingSeq(), val2.getParkingSeq());
	}

}
