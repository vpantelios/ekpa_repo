
package com.registry.client;

import java.util.Scanner;

public class CitizenClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Citizen Registry Menu ===");
            System.out.println("1. Προσθήκη πολίτη");
            System.out.println("2. Διαγραφή πολίτη");
            System.out.println("3. Ενημέρωση πολίτη");
            System.out.println("4. Αναζήτηση όλων");
            System.out.println("5. Αναζήτηση με ΑΤ");
            System.out.println("Οποιοδήποτε άλλο -> Έξοδος");
            System.out.print("Επιλογή: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                    System.out.println("Λειτουργία υπό ανάπτυξη (Mock).");
                    break;
                default:
                    running = false;
                    System.out.println("Έξοδος από το πρόγραμμα.");
                    break;
            }
        }

        scanner.close();
    }
}
