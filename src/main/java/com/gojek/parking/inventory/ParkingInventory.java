package com.gojek.parking.inventory;

import com.gojek.parking.lot.ParkingSlot;

/**
 * Min Heap Registered here for Parking Inventory.
 * 
 * @author b0208696
 *
 */
public class ParkingInventory {

	private int capacity;
	ParkingSlot inv[];
	int count = 0;
	InventoryPriority comparator;

	public ParkingInventory(int capacity, InventoryPriority comparator) {
		this.comparator = comparator;
		this.capacity = capacity;
		this.inv = new ParkingSlot[capacity];
		for (int i = 0; i < capacity; i++) {
			ParkingSlot parkingSlot = new ParkingSlot();
			parkingSlot.setParkingSeq(i + 1);
			addInventory(parkingSlot);
		}
	}

	public ParkingSlot removeInv() throws RuntimeException {
		if (count == 0) {
			throw new RuntimeException("Inventory Exhausted");
		}
		ParkingSlot res = inv[0];
		inv[0] = inv[count - 1];
		count--;
		inv[count] = null;
		perlocateDown(0);
		return res;
	}

	public void perlocateDown(int index) {
		int leftChildIdx = 2 * index + 1;
		int rightChildIdx = 2 * index + 2;
		int min = index;
		if (leftChildIdx < capacity && inv[leftChildIdx] != null
				&& comparator.compare(inv[leftChildIdx], inv[index]) < 0) {
			min = leftChildIdx;
		}
		if (rightChildIdx < capacity && inv[rightChildIdx] != null
				&& comparator.compare(inv[rightChildIdx], inv[min]) < 0) {
			min = rightChildIdx;
		}
		if (min != index) {
			ParkingSlot tmp = inv[min];
			inv[min] = inv[index];
			inv[index] = tmp;
			perlocateDown(min);
		}
	}

	public void addInventory(ParkingSlot parkingSlot) {
		inv[count] = parkingSlot;
		int index = count;
		while (index > 0 && comparator.compare(inv[(index - 1) / 2], inv[index]) > 0) {
			ParkingSlot tmp = inv[index];
			inv[index] = inv[(index - 1) / 2];
			inv[(index - 1) / 2] = tmp;
			index = (index - 1) / 2;
		}
		count++;
	}

}