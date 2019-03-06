package lot;

import java.util.TreeSet;

public class Lot {
	private TreeSet<Double> lot = new TreeSet<Double>();

	public String toString() {
		return this.lot.toString();
	}

	public boolean setLot(double num) {
		return this.lot.add(num);
	}

	public TreeSet<Double> getLot() {
		return this.lot;
	}

	private void cloneLot(Lot newLot){
		this.lot.clear();
		this.lot.addAll(newLot.getLot());
    }

	public void unionLot(Lot lot1, Lot lot2) {//Объединение
		this.cloneLot(lot1);
		this.lot.addAll(lot2.getLot());
	}

	public void confLot(Lot lot1, Lot lot2) {//Пересечение
		this.diffLot(lot1, lot2);
		for(double x : lot1.getLot()) {
			if(!this.lot.add(x)) this.lot.remove(x);
		}
	}

	public void diffLot(Lot lot1, Lot lot2) {//Разность
		this.cloneLot(lot1);
		for(double x : lot2.getLot()) {
			this.lot.remove(x);
		}
	}
}
