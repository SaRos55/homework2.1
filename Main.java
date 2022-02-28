package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] products = {"Насос", "Двигатель", "Контактор", "Переключатель", "Кнопка"};
        int[] prices = {10_500, 2_800, 350, 180, 75};
        System.out.println("Каталог товаров: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        int[] shoppingCart = new int[products.length];
        Scanner scanner = new Scanner(System.in);
        int sumProducts = 0;
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = scanner.nextLine();
            if (inputString.equals("end")) {
                break;
            }
            String[] parts = inputString.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            int currentPrice = prices[productNumber];
            sumProducts += currentPrice * productCount;
            shoppingCart[productNumber] += productCount;
        }
        System.out.println("Ваша корзина:");
        System.out.println("Наименование товара   Количество  Цена/за.ед  Общая стоимость");
        for (int i = 0; i < products.length; i++) {
            if (shoppingCart[i] > 0) {
                System.out.println(products[i] + "   " + shoppingCart[i] + "   " + prices[i] + "   " + prices[i] * shoppingCart[i]);
            }
        }
        System.out.println("ИТОГО   " + sumProducts);
    }
}