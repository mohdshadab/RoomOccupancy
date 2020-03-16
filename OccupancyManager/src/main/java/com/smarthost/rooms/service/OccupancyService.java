package com.smarthost.rooms.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smarthost.rooms.model.OccupancyStats;

@Service
public class OccupancyService {
	public OccupancyStats findOccupancy(final int economyRooms, final int premiumRooms,
			final List<Integer> customerPrices) {

		Collections.sort(customerPrices, Collections.reverseOrder());
		int premium = 0, economy = 0, premiumUsage = 0, economyUsage = 0;
		int totalRooms = economyRooms + premiumRooms;
		int totalCustomers = customerPrices.size();

		for (Integer price : customerPrices) {
			if (totalRooms <= premium + economy)
				break;
			else if (price >= 100 && premium < premiumRooms) {
				premium++;
				premiumUsage += price;
			} else if (price < 100) {
				if (totalCustomers - premium > economyRooms && premium < premiumRooms) {
					premium++;
					premiumUsage += price;
				} else if (economy < economyRooms) {
					economy++;
					economyUsage += price;
				}
			}
		}

		return OccupancyStats.builder().premiumCount(premium).premiumUsage(premiumUsage).economyCount(economy)
				.economyUsage(economyUsage).build();
	}
}
