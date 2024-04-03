package org.example;


import org.example.core.Inventory;
import org.example.core.Item;

import java.util.List;
import java.util.Scanner;

public class Program {
    public List<Item> items;

    public static void main(String[] args) throws Exception
    {
        var app = new Program();
        app.items = Inventory.load();
        Inventory.print("INVENTORY BEFORE UPDATE.", app.items);
        Inventory.update(app.items);
        Inventory.print("INVENTORY AFTER UPDATE.", app.items);
        exitProgram();
    }

    private static void exitProgram() {
        System.out.println("Press enter to exit...");
        var scan = new Scanner(System.in);
        scan.nextLine();
        scan.close();
    }

}