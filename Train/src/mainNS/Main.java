package mainNS;

import java.util.Scanner;
import train.Train;

public class Main {
	/*
	Транспорт. Определить иерархию подвижного состава
	железнодорожного транспорта. Создать пассажирский поезд.
	Подсчитать общую численность пассажиров и багажа.
	Провести сортировку вагонов поезда на основе уровня комфортности

	Данилов Ростислав
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int flag = 1;

		System.out.print("Количество вагонов: ");
		int countCar = scan.nextInt();
		Train train = new Train(countCar);

		System.out.print("Комфорт 1-го вагона: ");
		int comfort = scan.nextInt();
		train.newCar(comfort);
		System.out.println("\n\n\n");

		while(flag != 0) {
			int numCar = train.getCarCount();
			System.out.println("\n\n\n\n\n\nКоличество вагонов: " + numCar + " из " + countCar);
			System.out.println("1) Добавить вагон\n2) Добавить пассажира\n3) Отсортировать вагоны\n"
					+ "4) Просмотр пассажиров\n5) Удалить пассажира\n0) Выход");
			System.out.print("Выберите действие: ");
			flag = scan.nextInt();
			switch(flag) {
				case 1:
					System.out.print("Комфорт вагона: ");
					comfort = scan.nextInt();
					if(train.newCar(comfort)) {
						System.out.println("\nУспех!\n");
					} else System.out.println("\nОшибка! Много вагонов!\n");
					break;
				case 2:
					System.out.print("Номер вагона: ");
					numCar = scan.nextInt();
					numCar--;
					if(train.getCarCount() < countCar) {
						System.out.print("Ф.И.О: ");
						String FIO = scan.next();
						System.out.print("Количество багажа: ");
						int countl = scan.nextInt();
						System.out.print("Масса багажа: ");
						double luggage = scan.nextDouble();
						train.addPeople(numCar, FIO, luggage, countl);
					} else System.out.println("\nМест нет!\n");
					break;
				case 3:
					train.sortCars();
					break;
				case 4:
					for(int i = 0; i < train.getCarCount(); i++) {
						System.out.println("\n	ВАГОН №" + (i+1));
						for(int j = 0; j < train.getCarPlaces(i); j++) {
							System.out.println(train.toString(i, j));
						}
						System.out.println(train.infoCar(i));
					}
					break;
				case 5:
					System.out.print("Номер вагона: ");
					numCar = scan.nextInt();
					numCar--;
					System.out.print("Место пассажира: ");
					int location = scan.nextInt();
					location--;
					train.delPassenger(numCar, location);
					break;
				case 0:
					flag = 0;
					break;
				case 22:
					System.out.println("Номер вагона: ");
					numCar = scan.nextInt();
					numCar--;
					if(train.addRandPeople(numCar)) {
						System.out.println("\nУспех!\n");
					} else System.out.println("\nМест нет!\n");
					break;
				case 12:
					if(train.addRandCars()) {
						System.out.println("\nУспех!\n");
					} else System.out.println("\nОшибка! Много вагонов!\n");
					break;
			}
		}
		scan.close();
	}
}