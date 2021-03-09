package com.gojek.parking.lot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.gojek.parking.inventory.InventoryPriority;
import com.gojek.parking.inventory.ParkingInventory;
import com.gojek.parking.inventory.exception.InventoryAllocationException;

/**
 * Maintains Parking Slot.
 * 
 * @author b0208696
 *
 */
public class Parking {

	private Map<Integer, Car> slotMap;
	private ParkingInventory parkingInv;

	private Map<String, Set<Integer>> carColorInfoMap;

	public Parking(int capacity, InventoryPriority comparator) throws InventoryAllocationException {
		parkingInv = new ParkingInventory(capacity, comparator);
		carColorInfoMap = new HashMap<>();
		slotMap = new HashMap<>();
	}

	public int park(Car car) throws InventoryAllocationException {
		ParkingSlot parkingSlot = parkingInv.removeInv();
		slotMap.put(parkingSlot.getParkingSeq(), car);
		Set<Integer> slotSeqSet = carColorInfoMap.getOrDefault(car.getColour().toLowerCase(), new HashSet<>());
		slotSeqSet.add(parkingSlot.getParkingSeq());
		carColorInfoMap.put(car.getColour().toLowerCase(), slotSeqSet);
		return parkingSlot.getParkingSeq();
	}

	public void leave(int slotSeq) throws InventoryAllocationException {
		Car car = slotMap.get(slotSeq);
		if (car == null) {
			throw new RuntimeException("Slot was not allocated.");
		}
		Set<Integer> slotSeqSet = carColorInfoMap.get(car.getColour().toLowerCase());
		slotSeqSet.remove(slotSeq);
		slotMap.remove(slotSeq);
		parkingInv.addInventory(new ParkingSlot(slotSeq));
	}

	public Car carInSlot(Integer seqNo) {
		return slotMap.get(seqNo);
	}

	public Set<Integer> slotForColour(String colour) {
		return carColorInfoMap.get(colour);
	}

	public void status() {
		for (Map.Entry<Integer, Car> slotMapStatusEntry : slotMap.entrySet()) {
			Car car = slotMapStatusEntry.getValue();
			System.out.println(slotMapStatusEntry.getKey() + " " + car.getRegistrationNo() + " " + car.getColour());
		}
	}

}