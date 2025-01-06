package pl.gornik.menadzer;

import pl.gornik.klient.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    private List<String> peakHours;

    public StatisticsManager() {
        this.peakHours = new ArrayList<>();
    }

    // Metoda do dodawania godzin największego ruchu
    public void addPeakHour(String peakHour) {
        peakHours.add(peakHour);
    }

    // Metoda do odczytu godzin z największym ruchem
    public List<String> getPeakHours() {
        return peakHours;
    }
}
