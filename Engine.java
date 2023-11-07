public class Engine {
    private FuelType f;
    private double currentFuelLevel = 0.0;
    private double maxFuelLevel;

    /* Accessor for f */
    public FuelType getFuelType(){
        return this.f;
    }

    /* Accessor for currentFuelLevel */
    public double getCurrentFuelLevel(){
        return this.currentFuelLevel;
    }

    /* Accessor for maxFuelLevel */
    public double getMaxFuelLevel(){
        return this.maxFuelLevel;
    }

    /* Constructor */
    public Engine(FuelType f, double maxFuelLevel){
        this.f = f;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = maxFuelLevel;
    }

    /**
     * Refuels the train by setting fuel level to max
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * Runs train in increments of 10 until not enough fuel
     */
    public void go(){
        if(this.currentFuelLevel >= 10){
            this.currentFuelLevel -= 10;
            System.out.println("Current Fuel Level : " + this.currentFuelLevel);
        } else throw new RuntimeException("Out of Fuel");
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }

}