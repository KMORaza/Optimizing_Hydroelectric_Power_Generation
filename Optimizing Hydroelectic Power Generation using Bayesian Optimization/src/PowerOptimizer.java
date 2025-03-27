import java.util.Random;
public class PowerOptimizer {

    // Strompreis basierend auf Marktbedingungen (Cost of electricity as per market conditions)
    public double estimateElectricityPrice() {
        Random rand = new Random();
        return 0.05 + (rand.nextDouble() * 0.10); 
    }
    
    // Optimierung der Durchflussrate basierend auf Marktbedingungen, saisonalem Durchfluss und Reservoirpegeln
    // Optimizing flow rate as per market conditions, seasonal flow, and reservoir levels
    public double optimizeFlowRate(WaterFlow waterFlow, Reservoir reservoir) {
        double maxFlowRate = waterFlow.getFlowRate();
        double currentLevel = reservoir.getCurrentLevel();
        double optimalFlowRate;
        if (currentLevel > reservoir.getCapacity() * 0.8) {
            optimalFlowRate = maxFlowRate * 0.9;
        } else {
            optimalFlowRate = maxFlowRate * 0.7; 
        }
        double electricityPrice = estimateElectricityPrice();
        if (electricityPrice > 0.10) {
            optimalFlowRate *= 1.1; 
        }
        return Math.min(optimalFlowRate, maxFlowRate);
    }
}
