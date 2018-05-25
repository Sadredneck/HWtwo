package com.epam.hwtwo.Services;

import com.epam.hwtwo.Entity.Horse;
import com.epam.hwtwo.Entity.Race;
import com.epam.hwtwo.Entity.Rider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class EmulationService {

    private Random random;
    private RaceService raceService;
    private HorseService horseService;
    private RiderService riderService;

    public RaceService getRaceService() {
        return raceService;
    }

    public void setRaceService(RaceService raceService) {
        this.raceService = raceService;
    }

    public HorseService getHorseService() {
        return horseService;
    }

    public void setHorseService(HorseService horseService) {
        this.horseService = horseService;
    }

    public RiderService getRiderService() {
        return riderService;
    }

    public void setRiderService(RiderService riderService) {
        this.riderService = riderService;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void startRace(int betSumm, String betHorse) throws InterruptedException {
        Race race = raceService.getRace();

        startEmulation(race);

        Map.Entry<Horse, Integer> maxEntry = raceService.maxResult(race);

        if (maxEntry.getKey().getNickName().equals(betHorse)) {
            System.out.println("You've won: " + betSumm);
        } else {
            System.out.println("You've lost: " + betSumm);
        }
    }

    public void startEmulation(Race race) throws InterruptedException {
        System.out.println("Track: " + race.getTrackName());
        boolean noWinner = true;
        int second = 1;
        while (noWinner) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Second: " + second++);
            for (Map.Entry<Horse, Integer> horseResult : race.getResults().entrySet()) {
                if (horseResult.getValue() == null) {
                    horseResult.setValue(0);
                } else if (horseResult.getValue() >= race.getLength()) {
                    noWinner = false;
                } else {
                    horseResult.setValue(horseResult.getValue() + 3 + random.nextInt(8));
                }
                System.out.println(
                    horseResult.getKey().getNickName() + "'s time: " + horseResult.getValue());
            }
            System.out.println("-------------------");
        }
    }
}
