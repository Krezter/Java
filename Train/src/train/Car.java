package train;

public class Car implements Comparable<Car>{
	final int n; //количество мест
	private String[] passengers; //пассажиры(Инициалы)
	private double[] luggage; //багаж(кг)
	private int[] countl; //кол-во багажа
	private int comfort; //комфортность(1 - 10)

	Car(int comfort) {
		this.n = 11 - comfort;
		this.passengers = new String[n];
		this.luggage = new double[n];
		this.countl = new int[n];
		this.comfort = comfort;
	}

	public int compareTo(Car car) {
		if(this.comfort < car.getComfort())
            return 1;
        else if(this.comfort > car.getComfort())
            return -1;
        else
            return 0;
	}

	int getComfort() {
		return this.comfort;
	}

	double luggageWeight() {
		double sum = 0.0;
		for(double b : this.luggage) {
			sum += b;
		}
		return sum;
	}

	int luggageNum() {
		int sum = 0;
		for(int c : this.countl) {
			if(c != 0) sum += c;
		}
		return sum;
	}

	boolean addPassenger(String FIO, double luggage, int countl) {
		for(int i = 0; i < n; i++)
			if(this.passengers[i] == null) {
				this.passengers[i] = FIO;
				this.luggage[i] = luggage;
				this.countl[i] = countl;
				return true;
			}
		return false;
	}

	int numberOfPeople() {
		int sum = 0;
		for(String p : this.passengers) {
			if(p != null) sum++;
		}
		return sum;
	}

	boolean delPassenger(int location) {
		if(this.passengers[location] != null) {
			this.passengers[location] = null;
			this.luggage[location] = 0.0;
			this.countl[location] = 0;
			return true;
		}
		return false;
	}

	
	String toString(int i){
		if(this.passengers[i] == null)
			return (i+1) + " место: Свободно";
		else
			return (i+1) + " место: " + 
				this.passengers[i] + " | " + 
				this.countl[i] + " багаж(а) " + 
				this.luggage[i] + " кг";
	}

	boolean itsFree() {
		for(int i = 0; i < n; i++) {
			if(this.passengers[i] == null) return true;
		}
		return false;
	}
}
