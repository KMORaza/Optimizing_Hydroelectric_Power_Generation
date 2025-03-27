public class Turbine {
    private double maxEfficiency;  // Maximale Effizienz bei Ideallast (Maximum efficiency at ideal load)
    private double minEfficiency;  // Minimale Effizienz bei geringer Last (Minimum efficiency at low load)
    private double ageFactor; // Abnehmende Effizienz mit zunehmendem Alter der Turbine (Efficiency reduction based on turbine age)
    private double maintenanceFactor; // Effizienzfaktor basierend auf dem Wartungsplan (Efficiency factor as per maintenance schedule)

    public Turbine(double maxEfficiency, double minEfficiency, double ageFactor, double maintenanceFactor) {
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
        this.ageFactor = ageFactor;
        this.maintenanceFactor = maintenanceFactor;
    }

    // Von der Turbine erzeugte mechanische Leistung
    // Mechanical power produced by the turbine
    public double calculatePower(WaterFlow waterFlow) {
        double density = 1000; // kg/m^3 
        double gravity = 9.81; // m/s^2 
        double flowRate = waterFlow.getFlowRate(); // m^3/s
        double head = waterFlow.getHead(); // m
        double power = density * gravity * flowRate * head; // Mechanische Leistung (mechanical power):- P = ρ*g*Q*H
        return power; // Mechanische Leistung in Watt (mechanical power in Watts)
    }

    // Schätzen Sie die Effizienz in Abhängigkeit von Belastung, Alter und Wartung
    // Estimation of efficiency as a function of load, age, and maintenance
    public double estimateEfficiency(double flowRate) {
        double baseEfficiency = calculateEfficiency(flowRate);
        double adjustedEfficiency = baseEfficiency * (1 - ageFactor) * maintenanceFactor;
        return adjustedEfficiency;
    }

    private double calculateEfficiency(double flowRate) {
        double efficiency = maxEfficiency - (flowRate / 1000) * (maxEfficiency - minEfficiency);
        return efficiency;
    }
    public double getMaxEfficiency() {
        return maxEfficiency;
    }
    public double getMinEfficiency() {
        return minEfficiency;
    }
}
