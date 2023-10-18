import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;

    /* Constructor */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity){
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<>(nCars);
        for(int i = 0; i < nCars;){
            this.cars.add(i, new Car(passengerCapacity));
            i++;
        }
    }

    /* Accessor for engine */
    public Engine getEngine(){
        return this.engine;
    }

    /* Accessor for cars */
    public Car getCar(int i){
        return this.cars.get(i-1);
    }

    /* Accessor for maxCapacity */
    public int getMaxCapacity(){
        int maxCapacity = 0;
        for(int i = 0; i < this.cars.size();){
            maxCapacity += this.cars.get(i).getMaxCapacity();
            i++;
        }
        return maxCapacity;
    }

    /**
     * Finds the total number of remaining seats
     * @return an int for remaining seats
     */
    public int seatsRemaining(){
        int seatsRemaining = 0;
        for(int i = 0; i < this.cars.size();){
            seatsRemaining += this.cars.get(i).seatsRemaining();
            i++;
        }
        return seatsRemaining;
    }

    /**
     * Prints out a complete manifest for the entire train
     */
    public void printManifest(){
        System.out.println("Passenger Manifest:");
        for(int i = 0; i < this.cars.size();){
            System.out.println("Passengers in car " + (i+1) +":");
            this.cars.get(i).printManifest();
            i++;
        }
    }
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 100, 3, 2);
        Passenger a = new Passenger("Jordan");
        Passenger b = new Passenger("Johanna");
        Passenger c = new Passenger("Taylor Swift");

        a.boardCar(myTrain.getCar(1));
        b.boardCar(myTrain.getCar(2));
        c.boardCar(myTrain.getCar(1));
        b.boardCar(myTrain.getCar(1));

        myTrain.printManifest();
        System.out.println("Maximum Train Capacity: " + myTrain.getMaxCapacity());
        System.out.println("Seats Remaining: " + myTrain.seatsRemaining());
        

        try {
            while (true) {
                myTrain.engine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    } 
} 

