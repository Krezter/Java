package nspace;

import java.util.*;
import java.io.*;

public class Main {
	/*
	Во входном текстовом файле дан текст, содержащий слова.
	Подсчитать частоты вхождения каждого слова; затем
	список слов и их частот (в порядке убывания) записать
	в выходной файл.
	
	Данилов Ростислав
	*/
	
	public static void main(String[] args) {
		String name[] = new String[100];
		File f = new File("in.txt");
		int count = 0;
		
		try {
			FileReader fr = new FileReader(f);
			Scanner scan = new Scanner(fr);
			
			while (scan.hasNext()) {
				name[count++] = scan.next();
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		
		String sort[] = new String[100];
		int num[] = new int[100];
		boolean flag;
		int temp, key = 0;
		for(int i = 0; i < count; i++) {
			num[key] = 0;
			for(int k = 0; k < count; k++) {
				if(name[i].equals(name[k])) num[key]++;
			}
			flag = true;
			temp = key + 1;
			for(int t = 0; t < temp; t++) {
				if(name[i].equals(sort[t])) flag = false;
			}
			if(flag) sort[key++] = name[i];
		}

		for (int i = 1; i < key; i++) {
			for(int j = 0; j < i; j++) {
				if(num[j] < num[j+1]) {
					temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;

					String str = sort[j];
					sort[j] = sort[j+1];
					sort[j+1] = str;
				}
			}
		}

		try {
			PrintWriter pw = new PrintWriter(
				new BufferedWriter(
						new FileWriter(
								new File("out.txt"), true
						)
				)
			);
			for(int i = 0; i < key; i++) {
				pw.println(sort[i] + " " + num[i]);
			}
			pw.close();
			System.out.println("Файл создан!");
		} catch (IOException e) {
			System.err.println("Ошибка: " + e);
			System.exit(1);
		}
	}
}