package pl.zsl;

import java.util.Scanner;

public class AccountsMgmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonManager oc = new PersonManager();
		
		Scanner scan = new Scanner (System.in);
		Boolean cont = true;
		do {
			System.out.println("Podaj operacj�:");
			System.out.println("[1]. Dodanie osoby");
			System.out.println("[2]. Usuni�cie osoby");
			System.out.println("[3]. Wy�wietlenie os�b");
			System.out.println("[4]. Koniec dzia�ania aplikacji");
			String operation = scan.nextLine();
			if ("1".equals(operation)) {
				System.out.println("Podaj nazw�");
				String name = scan.nextLine();
				Person p1 = new Person();
				p1.setName(name);
				try {
					oc.addPerson(p1);
				} catch (Exception e) {
					System.out.println("B��d w trakcie dodawania osoby: " + e);
					e.printStackTrace();
				}
			} else if ("2".equals(operation)) {
				System.out.println("Podaj nazw�");
				String name = scan.nextLine();
				try {
					if (!oc.removePerson(name))
						System.out.println("Osoby nie ma na li�cie");
					else
						System.out.println("Usuni�to osob� z listy");
				} catch (Exception e) {
					System.out.println("B��d w trakcie usuwania osoby: " + e);
					e.printStackTrace();
				}
			} else if ("3".equals(operation)) {
				System.out.println("Lista os�b:");
				try {
					for (Person p : oc.getPersons()) {
						System.out.println(p);
					}
				} catch (Exception e) {
					System.out.println("B��d w trakcie wy�wietlanian listy os�b: " + e);
					e.printStackTrace();
				}
			} else if ("4".equals(operation)) {
				System.out.println("Bye.");
				cont = false;
			} else {
				System.out.println("Nieprawid�owa operacja");
			}
		} while (cont);
		scan.close();
	}

}
