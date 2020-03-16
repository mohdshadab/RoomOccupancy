package com.smarthost.service.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.smarthost.rooms.model.OccupancyStats;
import com.smarthost.rooms.service.OccupancyService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { OccupancyService.class })
public class OccupancyServiceTest {

	@Autowired
	private OccupancyService occupancyService;
	private final List<Integer> guests = Arrays.asList(23, 45, 155, 374, 22, 99, 100, 101, 115, 209);

	@Test
	public void occupancyTest1() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(3, 3, guests);
		assertMatches(occupancyStats, 3, 3, 738, 167);
	}

	@Test
	public void occupancyTest2() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(5, 7, guests);
		assertMatches(occupancyStats, 6, 4, 1054, 189);
	}

	@Test
	public void occupancyTest3() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(7, 2, guests);
		assertMatches(occupancyStats, 2, 4, 583, 189);
	}

	@Test
	public void occupancyTest4() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(1, 7, guests);
		assertMatches(occupancyStats, 7, 1, 1153, 45);
	}

	@Test
	public void occupancyTest5() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(1, 1, guests);
		assertMatches(occupancyStats, 1, 1, 374, 99);
	}

	@Test
	public void occupancyTest6() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(0, 0, guests);
		assertMatches(occupancyStats, 0, 0, 0, 0);
	}

	@Test
	public void occupancyTest7() {
		OccupancyStats occupancyStats = occupancyService.findOccupancy(-1, -1, guests);
		assertMatches(occupancyStats, 0, 0, 0, 0);
	}

	private void assertMatches(OccupancyStats occupancyStats, int premiumCount, int economyCount, int premiumUsage,
			int economyUsage) {
		assertThat(occupancyStats.getPremiumCount()).isEqualTo(premiumCount);
		assertThat(occupancyStats.getEconomyCount()).isEqualTo(economyCount);
		assertThat(occupancyStats.getPremiumUsage()).isEqualTo(premiumUsage);
		assertThat(occupancyStats.getEconomyUsage()).isEqualTo(economyUsage);
	}
}
