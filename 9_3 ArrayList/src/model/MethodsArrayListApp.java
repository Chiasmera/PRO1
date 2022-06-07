package model;

import java.util.ArrayList;

public class MethodsArrayListApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(19);
		list.add(35);
		list.add(14);
		list.add(7);
		MethodsArrayList methods = new MethodsArrayList();
		System.out.println(list);
		System.out.println("Summen af tallene i listen med for "
				+ methods.sumListe(list));
		System.out.println("Summen af tallene i listen med forEach "
				+ methods.sumListe2(list));

		System.out.println("Indeks for det første lige tal: "
				+ methods.hasEvenAtIndex(list));

		System.out.println("mindste tal i liste:");
		System.out.println(methods.min((list)));

		System.out.println("Gennemsnit");
		System.out.println(methods.average(list));

		System.out.println("antal nuller");
		System.out.println(methods.countZeros(list));

		System.out.println("print alle lige tal fra liste");
		System.out.println(methods.aEvenList(list));

		System.out.println("Erstat alle lige tal med 0, og print liste");
		methods.swapEvenWithZero(list);
		System.out.println(list);



	}

}
