package com.smarthost.rooms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class OccupancyResponse {
	private int premiumCount;
	private int economyCount;
	private double premiumUsage;
	private double economyUsage;
}
