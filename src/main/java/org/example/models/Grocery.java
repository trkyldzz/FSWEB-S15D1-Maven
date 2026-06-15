package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("0 - Çıkış");
        System.out.println("1 - Ürün Ekle");
        System.out.println("2 - Ürün Sil");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
            addItems(scanner.nextLine());
        } else if (choice == 2) {
            System.out.println("Çıkarılmasını istediğiniz elemanları giriniz.");
            removeItems(scanner.nextLine());
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();

            if (!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmedItem = item.trim();

            if (!trimmedItem.isEmpty()) {
                groceryList.remove(trimmedItem);
            }
        }

        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}