package com.gojek.parking.inventory;

import com.gojek.parking.lot.ParkingSlot;
/**
 * 
 * @author Manish Swarnakar
 *
 */
public interface InventoryAllocationStrategy {

	int compare(ParkingSlot val1, ParkingSlot val2);
	
}
