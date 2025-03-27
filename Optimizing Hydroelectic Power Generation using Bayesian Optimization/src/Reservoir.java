public class Reservoir {
    private double capacity;      // Maximales Fassungsvermögen des Reservoirs in Kubikmetern (Maximum capacity of reservoir in cubic meters)
    private double currentLevel;  // Aktueller Wasserstand im Stausee in Kubikmetern (Current level of water in reservoir in cubic meters)
    public Reservoir(double capacity, double currentLevel) {
        this.capacity = capacity;
        this.currentLevel = currentLevel;
    }
    public double getCurrentLevel() {
        return currentLevel;
    }
    public void setCurrentLevel(double currentLevel) {
        if (currentLevel < 0) {
            this.currentLevel = 0; 
        } else if (currentLevel > capacity) {
            this.currentLevel = capacity;  
        } else {
            this.currentLevel = currentLevel;
        }
    }
    public double getCapacity() {
        return capacity;
    }
    public void decreaseWaterLevel(double amount) {
        setCurrentLevel(this.currentLevel - amount);
    }
}
