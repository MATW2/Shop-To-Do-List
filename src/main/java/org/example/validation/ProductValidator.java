package org.example.validation;

import org.example.client.AbstractClientGui;

import javax.swing.*;

public class ProductValidator {
    public static String validateName(String initialValue, String message, AbstractClientGui clientGui) {
        String name;
        do {
            name = JOptionPane.showInputDialog(clientGui, "Podaj " + message, initialValue);
            if (name == null) {
                JOptionPane.showMessageDialog(clientGui, "Anulowano operację");
                return null;
            } else if (name.isEmpty()) {
                JOptionPane.showMessageDialog(clientGui, "Wprowadzone dane nie mogą być puste");
            }
        } while (name.isEmpty());
        return name;
    }

    public static String validateQuantity(String initialValue, String message, AbstractClientGui clientGui) {
        String quantity;
        boolean isInteger;
        do {
            quantity = JOptionPane.showInputDialog(clientGui, "Podaj " + message, initialValue);
            if (quantity == null) {
                JOptionPane.showMessageDialog(clientGui, "Anulowano operację");
                return null;
            } else if (quantity.isEmpty()) {
                JOptionPane.showMessageDialog(clientGui, "Wprowadzone dane nie mogą być puste");
                isInteger = false;
            } else {
                try {
                    Integer.parseInt(quantity);
                    isInteger = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(clientGui, "Wprowadzone dane muszą być liczbą całkowitą");
                    isInteger = false;
                }
            }
        } while (!isInteger);
        return quantity;
    }

    public static String validatePrice(String initialValue, String message, AbstractClientGui clientGui) {
        String price;
        boolean isDouble;
        do {
            price = JOptionPane.showInputDialog(clientGui, "Podaj " + message, initialValue);
            if (price == null) {
                JOptionPane.showMessageDialog(clientGui, "Anulowano operację");
                return null;
            } else if (price.isEmpty()) {
                JOptionPane.showMessageDialog(clientGui, "Wprowadzone dane nie mogą być puste");
                isDouble = false;
            } else {
                try {
                    Double.parseDouble(price.replace(",", "."));
                    isDouble = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(clientGui, "Wprowadzone dane muszą być typu zmiennoprzecinkowego");
                    isDouble = false;
                }
            }
        } while (!isDouble);
        return price;
    }
}
