package com.smarthost.rooms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OccupancyStats {
	private int premiumCount;
	private int economyCount;
	private double premiumUsage;
	private double economyUsage;
}
