package train;

import java.util.Arrays;
import java.util.Random;

public class Train {
	Random rand = new Random();
	private int numCar;
	private Car car[];

	public Train(int numCar) {
		car = new Car[numCar];
		this.numCar = 0;
	}

	public void sortCars() {
		Arrays.sort(car);
	}

	public String toString(int nCar, int seat) {
		return car[nCar].toString(seat);
	}

	public int getCarCount() {
		return this.numCar;
	}

	public int getCarPlaces(int numCar) {
		int places = 11 - car[numCar].getComfort();
		return places;
	}

	public boolean newCar(int comfort) {
		if(this.numCar < car.length) {
			car[this.numCar] = new Car(comfort);
			this.numCar++;
			return true;
		}
		return false;
	}

	public boolean addPeople(int numCar, String fio, double luggage, int countl) {
		return car[numCar].addPassenger(fio, luggage, countl);
	}

	public String infoCar(int nCar) {
		return "\nКомфортность: " + car[nCar].getComfort() + 
				"\nКоличество пассажиров: " + car[nCar].numberOfPeople() + 
				"\nКоличество багажа: " + car[nCar].luggageNum() + 
				"\nОбщая масса: " + car[nCar].luggageWeight();
	}

	public void delPassenger(int numCar, int location) {
		car[numCar].delPassenger(location);
	}

	public boolean addRandPeople(int numCar) {
		if(car[numCar].itsFree()) {
			int n = car[numCar].getComfort();
			n = 11 - n;
			for(int i = 0; i < n; i++) {
				String FIO = "RandName " + i;
				int countl = rand.nextInt(3) + 1;
				double luggage = rand.nextInt(10) + 1;
				if(car[numCar].itsFree())
					car[numCar].addPassenger(FIO, luggage, countl);
				else break;
			}
			return true;
		} else return false;
	}

	public boolean addRandCars() {
		if(this.numCar < car.length) {
			while(this.numCar < car.length) {
				int comfort = rand.nextInt(10) + 1;
				car[this.numCar] = new Car(comfort);
				addRandPeople(this.numCar);
				this.numCar++;
			}
			return true;
		} else return false;
	}
}
