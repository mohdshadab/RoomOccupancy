package com.smarthost.rooms.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.smarthost.rooms.model.OccupancyResponse;
import com.smarthost.rooms.model.OccupancyStats;
import com.smarthost.rooms.service.OccupancyService;

public class OccupancyDelegate {

	private final OccupancyService occupancyService;

	@Autowired
	public OccupancyDelegate(OccupancyService occupancyService) {
		this.occupancyService = occupancyService;
	}

	public ResponseEntity<OccupancyResponse> getOccupancy(Integer economyRooms, Integer premiumRooms,
			List<Integer> customerPrices) {

		OccupancyStats roomUsage = occupancyService.findOccupancy(economyRooms, premiumRooms, customerPrices);

		OccupancyResponse occupancyResponse = OccupancyResponse.builder().economyCount(roomUsage.getEconomyCount())
				.economyUsage(roomUsage.getEconomyUsage()).premiumCount(roomUsage.getPremiumCount())
				.premiumUsage(roomUsage.getPremiumUsage()).build();

		return ResponseEntity.ok(occupancyResponse);
	}
}
