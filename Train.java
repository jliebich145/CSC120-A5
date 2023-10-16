import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;

    /* Constructor */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        for(int i = 0; i < nCars;){
            this.cars.add(i, new Car(passengerCapacity));
        }
    }

    /* Accessor for engine */
    public Engine getEngine(){
        return this.engine;
    }

    /* Accessor for cars */
    public Car getCar(int i){
        return this.cars.get(i+1);
    }

    /* Accessor for maxCapacity */
    public int getMaxCapacity(){
        int maxCapacity = 0;
        for(int i = 0; i < this.cars.size();){
            maxCapacity += this.cars.get(i).getMaxCapacity();
        }
        return maxCapacity;
    }

    /*
     * Finds the total number of remaining seats
     * @return an int for remaining seats
     */
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for(int i = 0; i < this.cars.size();){
            seatsRemaining += this.cars.get(i).seatsRemaining();
        }
        return seatsRemaining;
    }

    /*
     * Prints out a complete manifest for the entire train
     */
    public void printManifest(){
        System.out.println("Passenger Manifest:");
        for(int i = 0; i < this.cars.size();){
            System.out.println("Passengers in car " + (i+1) +":");
            this.cars.get(i).printManifest();
        }
    }
} 

