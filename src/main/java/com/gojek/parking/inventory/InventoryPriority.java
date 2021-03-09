package com.gojek.parking.inventory;

import com.gojek.parking.lot.ParkingSlot;

public interface InventoryPriority {

	int compare(ParkingSlot val1, ParkingSlot val2);
	
}
