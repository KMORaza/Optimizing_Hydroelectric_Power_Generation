import java.util.Random;
public class WaterFlow {
    private double flowRate; // m^3/s
    private double head; // m
    private double seasonalVariationFactor; // saisonale Veränderungen des Wasserflusses (Seasonal changes in flow of water)
    public WaterFlow(double flowRate, double head) {
        this.flowRate = flowRate;
        this.head = head;
        this.seasonalVariationFactor = 0.1; // Ich bin standardmäßig von 10% saisonalen Schwankungen ausgegangen (I'm assuming seasonal fluction of 10%)
    }

    // Durchflussrate basierend auf historischen Daten und Saisonalität
    // Rate of flow as per historical data and seasons
    public void estimateFlowRate(int month) {
        double estimatedFlow = flowRate;
        if (month >= 3 && month <= 5) {
            estimatedFlow += estimatedFlow * 0.20; // Frühling - Erhöhter Abfluss durch Schneeschmelze, +20% (Spring - Increased flow due to snowmelt, +20%)
        } else if (month >= 6 && month <= 8) { 
            estimatedFlow -= estimatedFlow * 0.10; // Sommer - Trockenzeit, verringerter Durchfluss, -10% (Summer - Dry season, decreased flow, -10%)
        } else if (month >= 9 && month <= 11) {
            estimatedFlow = flowRate; // Herbst - Mäßiger Fluss, normal (Fall - Moderate flow, normal)
        } else if (month == 12 || month <= 2) {
            estimatedFlow -= estimatedFlow * 0.15; // Winter - Verminderter Durchfluss, -15% (Winter - Decreased flow, -15%)
        }
        this.flowRate = estimatedFlow; 
    }

    // Schätzen Sie den Druck basierend auf den Bedingungen flussaufwärts und dem Dammniveau
    // Estimation of head as per upstream conditions and level of dam 
    public void estimateHead(double upstreamWaterLevel) {
        double estimatedHead = upstreamWaterLevel - 20; 
        this.head = estimatedHead > 0 ? estimatedHead : 0; 
    }
    public double getFlowRate() {
        return flowRate;
    }
    public double getHead() {
        return head;
    }
    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }
    public void setHead(double head) {
        this.head = head;
    }
}
