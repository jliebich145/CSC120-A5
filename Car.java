import java.util.ArrayList;

public class Car {
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /* Constructor */
    public Car(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<>(maxCapacity);
    }

    /* Accessor for maxCapacity */
    public int getMaxCapacity(){
        return this.maxCapacity;
    }

    /**
     * Finds the number of remaining seats
     * @return an int (remaining seats)
     */
    public int seatsRemaining(){
        return this.maxCapacity - this.passengersOnboard.size();
    }

    /**
     * Adds a Passenger object to the car
     * @param p the Passenger to add
     */
    public void addPassenger(Passenger p){
        if(this.passengersOnboard.contains(p)){
            throw new RuntimeException(p.getName() + " is already in this car.");
        }
        if(seatsRemaining() == 0){
            throw new RuntimeException(p.getName() + " not added, no seats remaining.");
        }
        this.passengersOnboard.add(p);
    }

    /**
     * Removes a Passenger object from the car
     * @param p the Passenger to remove
     */
    public void removePassenger(Passenger p){
        if(!this.passengersOnboard.contains(p)){
            throw new RuntimeException(p.getName() + " is not in this car.");
        }
        this.passengersOnboard.remove(p);
    }

    /**
     * Prints out a list of all Passenger objects in the Car or prints "This car is EMPTY." if none.
     */
    public void printManifest(){
        if(this.passengersOnboard.isEmpty()){
            System.out.println("This car is EMPTY.");
        } 
        else{
            for(int i=0; i < this.passengersOnboard.size();){
                System.out.println("Passenger " + (i+1) + ": " + this.passengersOnboard.get(i).getName());
                i++;
            }
        }
    }
}