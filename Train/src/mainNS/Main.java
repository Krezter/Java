package mainNS;

import java.util.Scanner;
import train.Train;

public class Main {
	/*
	���������. ���������� �������� ���������� �������
	���������������� ����������. ������� ������������ �����.
	���������� ����� ����������� ���������� � ������.
	�������� ���������� ������� ������ �� ������ ������ ������������

	������� ���������
	*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int flag = 1;

		System.out.print("���������� �������: ");
		int countCar = scan.nextInt();
		Train train = new Train(countCar);

		System.out.print("������� 1-�� ������: ");
		int comfort = scan.nextInt();
		train.newCar(comfort);
		System.out.println("\n\n\n");

		while(flag != 0) {
			int numCar = train.getCarCount();
			System.out.println("\n\n\n\n\n\n���������� �������: " + numCar + " �� " + countCar);
			System.out.println("1) �������� �����\n2) �������� ���������\n3) ������������� ������\n"
					+ "4) �������� ����������\n5) ������� ���������\n0) �����");
			System.out.print("�������� ��������: ");
			flag = scan.nextInt();
			switch(flag) {
				case 1:
					System.out.print("������� ������: ");
					comfort = scan.nextInt();
					if(train.newCar(comfort)) {
						System.out.println("\n�����!\n");
					} else System.out.println("\n������! ����� �������!\n");
					break;
				case 2:
					System.out.print("����� ������: ");
					numCar = scan.nextInt();
					numCar--;
					if(train.getCarCount() < countCar) {
						System.out.print("�.�.�: ");
						String FIO = scan.next();
						System.out.print("���������� ������: ");
						int countl = scan.nextInt();
						System.out.print("����� ������: ");
						double luggage = scan.nextDouble();
						train.addPeople(numCar, FIO, luggage, countl);
					} else System.out.println("\n���� ���!\n");
					break;
				case 3:
					train.sortCars();
					break;
				case 4:
					for(int i = 0; i < train.getCarCount(); i++) {
						System.out.println("\n	����� �" + (i+1));
						for(int j = 0; j < train.getCarPlaces(i); j++) {
							System.out.println(train.toString(i, j));
						}
						System.out.println(train.infoCar(i));
					}
					break;
				case 5:
					System.out.print("����� ������: ");
					numCar = scan.nextInt();
					numCar--;
					System.out.print("����� ���������: ");
					int location = scan.nextInt();
					location--;
					train.delPassenger(numCar, location);
					break;
				case 0:
					flag = 0;
					break;
				case 22:
					System.out.println("����� ������: ");
					numCar = scan.nextInt();
					numCar--;
					if(train.addRandPeople(numCar)) {
						System.out.println("\n�����!\n");
					} else System.out.println("\n���� ���!\n");
					break;
				case 12:
					if(train.addRandCars()) {
						System.out.println("\n�����!\n");
					} else System.out.println("\n������! ����� �������!\n");
					break;
			}
		}
		scan.close();
	}
}