package Polymorphism;

// Vehicle Class
class Vehicle {

    // Attributes
    protected int numOfDoors;
    protected double price;
    private static int numOfCreatedObjects = 0;



    // Constructors
    public Vehicle()    // default constructor
    {
        System.out.println("\nCreating a vehicle object using default constructor ....");

        numOfDoors = 4;
        price = 10000;
        numOfCreatedObjects++;
    }

    public Vehicle(int nd, double pr) {
        System.out.println("\nCreating a vehicle object using parameterized constructor ....");

        numOfDoors = nd;
        price = pr;
        numOfCreatedObjects++;
    }


    public Vehicle(Vehicle vec)    // copy constructor
    {
        System.out.println("\nCreating a vehicle object using copy constructor ....");

        numOfDoors = vec.numOfDoors;
        price = vec.price;
        numOfCreatedObjects++;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int nd) {
        numOfDoors = nd;
    }

    public double getPrice(){
        // Obtain the class name just for display purposes
        String s = this.getClass().toString();
        s = s.substring(6); // Remove the word "class" to get only the class name

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public void setPrice(double pr)
    {
        price = pr;
    }

    public String toString()
    {
        return "This Vehicle has " + numOfDoors +
                " doors and it price is " + price + "$.";
    }

    // Find out if that vehicle has a cheaper price than the passed vehicle
    public boolean isCheaper(Vehicle v)
    {
        // Obtain the class names just for display purposes
        String s1 = this.getClass().toString(), s2 = v.getClass().toString();
        s1 = s1.substring(19); // Remove the word "class" to get only the class name
        s2 = s2.substring(19);

        if(getPrice() < v.getPrice())
        {

            System.out.println("The price of this " + s1 +
                    " object is cheaper than the price of the passed " +
                    s2 + " object.");
            return true;
        }
        else
        {
            System.out.println("The price of this " + s1 +
                    " object is NOT cheaper than the price of the passed " +
                    s2 + " object.");
            return false;
        }
    }
    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created Vehicle objects so far is " + numOfCreatedObjects + ".");
    }


}

// Bus Class - This is a derived class from the Vehicle Class; that is it
// inherits the Vehicle class
class Bus extends Vehicle {

    // Attributes
    private int passengerCapacity;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public Bus()    // default constructor
    {
        System.out.println("Creating a bus object using default constructor ....");

        passengerCapacity = 10;
        numOfCreatedObjects++;
    }

    public Bus(int pc) {
        System.out.println("Creating a bus object using parameterized constructor ....");

        passengerCapacity = pc;
        numOfCreatedObjects++;
    }

    public Bus(Bus b) {
        System.out.println("Creating a bus object using copy constructor ....");

        setNumOfDoors(b.getNumOfDoors());
        setPrice(b.getPrice());
        passengerCapacity = b.passengerCapacity;
        numOfCreatedObjects++;
    }


    // A constructor that would allow the setting of the price and the number of doors
    // and the passenger capacity
    public Bus(int nd, double pr, int pc) {

        this(pc);    // Call the constructor that sets the passenger capacity

        System.out.println("Creating a bus object using parameterized constructor for full settings....\n");

        // Notice that we now cannot call super to set the other two attributes
        // (i.e. super(nd, pr);) since either "this" or 'super" must be the first
        // statement, and it is not possible to have both of them as such!
        setPrice(pr);
        setNumOfDoors(nd);

    }


    public int getPassangerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int pc) {
        passengerCapacity = pc;
        ;
    }

    public String toString() {
        return "This Bus has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The passenger capacity of this bus is " + passengerCapacity + ".";
    }

    public void setPrice(double pr)
    {
        if(pr < getPrice())
            System.out.println("The price of this bus will be reduced from " + getPrice() + "$ to " + pr + "$.");
        else if (pr > getPrice())
            System.out.println("The price of this bus will be increased from " + getPrice() + "$ to " + pr + "$.");
        else
            System.out.println("No change will be applied to this price of the bus.");

        super.setPrice(pr);
        // Notice that you cannot access "price" directly  since it is private to the base class
        // i.e. price = pr; would be illegal

    }

    public double getPrice()
    {
        // Obtain the class name
         String s = this.getClass().toString();
         s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created Bus objects so far is " + numOfCreatedObjects + ".");
    }

} // end of Bus class

//Car Class - This is a derived class from the Vehicle Class.
//For a Car object, we are interested in its number of seats
class Car extends Vehicle {

    // Attributes
    private int numOfSeats;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public Car()    // default constructor
    {
        System.out.println("Creating a car object using default constructor ....");

        numOfSeats = 5;
        numOfCreatedObjects++;

    }

    public Car(int nd, double pr, int ns) {
        super(nd, pr);
        System.out.println("Creating a car object using parameterized constructor ....");

        numOfSeats = ns;
        numOfCreatedObjects++;

    }

    public Car(Car c) {
        System.out.println("Creating a car object using copy constructor ....");
        setNumOfDoors(c.getNumOfDoors());
        setPrice(c.getPrice());
        numOfSeats = c.numOfSeats;
        numOfCreatedObjects++;

    }


    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int ns) {
        numOfSeats = ns;
        ;
    }

    public String toString() {
        return "This Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this car is " + numOfSeats + ".";
    }

    public double getPrice() {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "Car";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created Car objects so far is " + numOfCreatedObjects + ".");
    }

} // end of Car class


//SportCar Class - This is a derived class from the Car Class
//For a SportCar object, we are interested in its gas consumption
// as gallon per 100 miles
class SportCar extends Car{

    // Attributes
    private double gasConsumption;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public SportCar()	// default constructor
    {
        System.out.println("Creating a sport car object using default constructor ....");

        gasConsumption = 4;
        numOfCreatedObjects++;

    }

    public SportCar(int nd, double pr, int ns, double gc)
    {
        super(nd, pr, ns);
        System.out.println("Creating a sport car object using parameterized constructor ....");
        gasConsumption = gc;
        numOfCreatedObjects++;

    }

    public SportCar(SportCar sc)
    {
        System.out.println("Creating a sport car object using copy constructor ....");

        setNumOfDoors(sc.getNumOfDoors());
        setPrice(sc.getPrice());
        setNumOfSeats(sc.getNumOfSeats());

        gasConsumption = sc.gasConsumption;
        numOfCreatedObjects++;

    }


    public double getGasConsumption()
    {
        return gasConsumption;
    }

    public void setGasConsumption(double gc)
    {
        gasConsumption = gc;;
    }

    public String toString()
    {
        return "This Sport Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Sport Car is " + getNumOfSeats() +
                "\nand its gas consumption is " + gasConsumption + " gallons/100-mile.";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "SportCar";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created SportCar objects so far is " + numOfCreatedObjects + ".");
    }

}   // end of Sport Car class


//RaceCar Class - This is a derived class from the SportCar Class
//For a RaceCar object, we are interested in its horse power
class RaceCar extends SportCar{

    // Attributes
    private int horsePower;
    private static int numOfCreatedObjects = 0;

    // Constructors
    public RaceCar()	// default constructor
    {
        System.out.println("Creating a race car object using default constructor ....");

        horsePower = 400;
        numOfCreatedObjects++;

    }

    public RaceCar(int nd, double pr, int ns, double gc, int hp)
    {
        super(nd, pr, ns, gc);
        System.out.println("Creating a race car object using parameterized constructor ....");
        horsePower = hp;
        numOfCreatedObjects++;

    }

    public RaceCar(RaceCar rc)
    {
        System.out.println("Creating a race car object using copy constructor ....");

        setNumOfDoors(rc.getNumOfDoors());
        setPrice(rc.getPrice());
        setNumOfSeats(rc.getNumOfSeats());
        setGasConsumption(rc.getGasConsumption());

        horsePower = rc.horsePower;
        numOfCreatedObjects++;

    }


    public int getHorsePower()
    {
        return horsePower;
    }

    public void setHorsePower(int hp)
    {
        horsePower = hp;
    }

    public String toString()
    {
        return "This Race Car has " + getNumOfDoors() + " doors and its price is: " + getPrice() +
                "$. The number of seats of this Race Car is " + getNumOfSeats() +
                "\nand its gas consumption is " + getGasConsumption() + " gallons/100-mile." +
                "The horse power of this Race Car is: " + horsePower + ".";
    }

    public double getPrice()
    {
        // Obtain the class name
        // String s = this.getClass().toString();
        // s = s.substring(6);
        // We can surely execute the above code, but let us just hard-code it to
        // see clearly that the method is different than the one in the other classes
        String s = "RaceCar";

        System.out.println("Executing getPrice() from the " + s +
                " class. The price is " + price + "$.");
        return price;
    }

    public static void DisplayNumberOfCreatedObjects()
    {
        System.out.println("The number of created RaceCar objects so far is " + numOfCreatedObjects + ".");
    }

}   // end of Race Car class


public class Polymorphism1 {

    // A method that would accept any vehicle object and displays its information
    public static void showVehicleInfo(Vehicle v)
    {
        System.out.println("Here is the information of this vehicle");
        System.out.println(v);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Will create two Vehicle objects");

        Vehicle v1 = new Vehicle(), v2 = new Vehicle(4, 5000);

        v1.DisplayNumberOfCreatedObjects();


        System.out.println();
        System.out.println("Will create three Bus objects");

        Bus b1 = new Bus(2, 55000, 37), b2 = new Bus(3, 62000, 55), b3 = new Bus(b1);

        b1.DisplayNumberOfCreatedObjects();
        v1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Car objects");

        Car c1 = new Car(4, 12000, 5), c2 = new Car(2, 26000, 2);

        c1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Sport Car objects");

        SportCar sc1 = new SportCar(4, 12000, 5, 3), sc2 = new SportCar(3, 18500, 4, 4);

        sc1.DisplayNumberOfCreatedObjects();

        System.out.println();
        System.out.println("Will create two Race Car objects");

        RaceCar rc1 = new RaceCar(4, 67000, 2, 4, 400), rc2 = new RaceCar(3, 85000, 4, 4, 450);

        rc1.DisplayNumberOfCreatedObjects();
        v1.DisplayNumberOfCreatedObjects();
        v1 = b1;
        System.out.println("\n ============= After executing v1 = b1; =============\n");
        v1.DisplayNumberOfCreatedObjects(); // Will still call the method from the Vehicle class
        b1.DisplayNumberOfCreatedObjects();


    }
}
