public class HydroelectricPlant {
    private Turbine turbine;
    private Generator generator;
    private WaterFlow waterFlow;
    private PowerOptimizer optimizer;
    private Reservoir reservoir;
    private double energyPrice;

    public HydroelectricPlant(Turbine turbine, Generator generator, WaterFlow waterFlow, PowerOptimizer optimizer, Reservoir reservoir, double energyPrice) {
        this.turbine = turbine;
        this.generator = generator;
        this.waterFlow = waterFlow;
        this.optimizer = optimizer;
        this.reservoir = reservoir;
        this.energyPrice = energyPrice;
    }

    public void optimizeAndGenerate() {
        double optimalFlowRate = optimizer.optimizeFlowRate(waterFlow, reservoir);
        waterFlow.setFlowRate(optimalFlowRate);
        double mechanicalPower = turbine.calculatePower(waterFlow); 
        double turbineEfficiency = turbine.estimateEfficiency(optimalFlowRate);
        double electricalPower = generator.convertToElectricalPower(mechanicalPower);
        double revenue = electricalPower * energyPrice; 
        System.out.println("Generated Power: " + electricalPower + " W");
        System.out.println("Revenue: $" + revenue);
    }
    public void updateReservoir(double waterUsed) {
        double newLevel = reservoir.getCurrentLevel() - waterUsed;
        reservoir.setCurrentLevel(newLevel);
    }
}
