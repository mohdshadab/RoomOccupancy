package com.smarthost.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smarthost.rooms.delegate.OccupancyDelegate;
import com.smarthost.rooms.model.OccupancyResponse;

@RestController
@RequestMapping(value = "/room/occupancy")
public class OccupancyController {
	private final OccupancyDelegate occupancyDelegate;

	@Autowired
	public OccupancyController(OccupancyDelegate occupancyDelegate) {
		this.occupancyDelegate = occupancyDelegate;
	}

	@PostMapping(value = "/{allocations}")
	public ResponseEntity<OccupancyResponse> getRoomAllocations(@RequestParam Integer economyRooms,
			@RequestParam Integer premiumRooms, @RequestParam List<Integer> customerPrices) {
		return occupancyDelegate.getOccupancy(economyRooms, premiumRooms, customerPrices);
	}
}
