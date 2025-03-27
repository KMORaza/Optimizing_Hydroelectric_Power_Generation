public class Main {
    public static void main(String[] args) {
        // Instanzen von Turbine, Generator, Wasserfluss und Reservoir
        // Instances of turbine, generator, water flow, & reservoir
        /// Maximale Effizienz (max. efficiency) = 90%
        /// Minimale Effizienz (min. efficiency) = 60%
        /// Altersfaktor (age factor) = 5%
        /// Wartungsfaktor (maintenance factor) = 95%
        Turbine turbine = new Turbine(0.90, 0.60, 0.05, 0.95); 
        /// Maximale Effizienz (max. efficiency) = 95%
        /// Minimale Effizienz (min. efficiency) = 75%
        /// Betriebsstunden (operational hours) = 5000
        /// Wartungsfaktor (maintenance factor) = 90%
        Generator generator = new Generator(0.95, 0.75, 5000, 0.90); 
        /// Durchflussrate (Flow rate) = 500 m^3/s
        WaterFlow waterFlow = new WaterFlow(500, 150); 
        /// Fassungsvermögen (capacity) = 1 Million m^3
        /// Anfangsniveau (initial level) = 800 
        Reservoir reservoir = new Reservoir(1000000, 800000); 
        PowerOptimizer optimizer = new PowerOptimizer();
        double energyPrice = 0.08; /// Strompreis pro Kilowattstunde in Dollar (Cost of electricty per kilowatt-hour in Dollars)
        HydroelectricPlant plant = new HydroelectricPlant(turbine, generator, waterFlow, optimizer, reservoir, energyPrice);
        /// Optimierung über einen bestimmten Zeitraum (Optimizing over a time period)
        for (int month = 1; month <= 12; month++) {
            waterFlow.estimateFlowRate(month); /// Schätzung der Durchflussrate basierend auf der Jahreszeit (Flow rate estimation as per season)
            waterFlow.estimateHead(200); /// Schätzen Sie die Fallhöhe basierend auf den Bedingungen stromaufwärts (Estimationf of head as per upstream conditions)
            plant.optimizeAndGenerate(); /// Optimierung der Erzeugungsleistung für den aktuellen Monat (Optimize generation power for current month)
            generator.setOperationalHours(generator.getOperationalHours() + 100); /// Betriebszeiten (Operational hours)
            plant.updateReservoir(50000);  /// Nach der Erzeugung 50000 m^3 zum Reservoir hinzufügen (Add 50000 m^3 to the reservoir after generation)
        }
    }
}
