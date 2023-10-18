public class Passenger {
    
    private String name;

    /* Constructor */
    public Passenger(String name) {
        this.name = name;
    }

    /* Accessor for name */
    public String getName(){
        return this.name;
    }

    /**
     * Adds the passenger to the car
     * @param c Car object to add passenger to
     */
    public void boardCar(Car c){
        try {
            c.addPassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Removes the passenger from the car
     * @param c Car object to remove passenger from
     */
    public void getOffCar(Car c){
        try {
            c.removePassenger(this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
