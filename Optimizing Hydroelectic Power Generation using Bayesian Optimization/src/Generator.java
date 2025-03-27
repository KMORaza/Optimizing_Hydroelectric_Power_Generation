public class Generator {
    private double maxEfficiency;  // Maximale Effizienz bei Ideallast (Maximum efficiency at ideal load)
    private double minEfficiency;  // Minimale Effizienz bei geringer Last (Minimum efficiency at low load)
    private int operationalHours;  // Gesamtbetriebsstunden des Generators (Total operational hours of the generator)
    private double maintenanceFactor; // Effizienzfaktor basierend auf dem Wartungsplan (Efficiency factor as per maintenance schedule)
    public Generator(double maxEfficiency, double minEfficiency, int operationalHours, double maintenanceFactor) {
        this.maxEfficiency = maxEfficiency;
        this.minEfficiency = minEfficiency;
        this.operationalHours = operationalHours;
        this.maintenanceFactor = maintenanceFactor;
    }
    public int getOperationalHours() {
        return operationalHours;
    }
    public void setOperationalHours(int operationalHours) {
        this.operationalHours = operationalHours;
    }
    public double estimateEfficiency(double mechanicalPower) {
        double ageFactor = (double) operationalHours / 10000; 
        double efficiency = maxEfficiency - ageFactor * (maxEfficiency - minEfficiency);
        efficiency *= maintenanceFactor;
        return efficiency;
    }
    public double convertToElectricalPower(double mechanicalPower) {
        double efficiency = estimateEfficiency(mechanicalPower);
        return mechanicalPower * efficiency; 
    }
}
