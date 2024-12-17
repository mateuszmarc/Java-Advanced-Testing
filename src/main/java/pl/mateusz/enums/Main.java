package pl.mateusz.enums;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isProgramActive = true;
        while (isProgramActive) {
            System.out.println("Please enter ticket type( enter q to quit)");
            String stringTicketType = scanner.nextLine();

            if (stringTicketType.trim().equalsIgnoreCase("q")) {
                System.out.println("Thank you");
                isProgramActive = false;
            } else {
                TicketType ticketType;
                try {
                    ticketType = TicketType.valueOf(stringTicketType.trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("There is no such ticket type");
                    continue;
                }

                Ticket ticket = new Ticket(10.0, ticketType);
                double priceAfterDiscount = TicketMachine.calculatePrice(ticket);
                System.out.printf("Ticket price: %.2f%n", priceAfterDiscount);
            }

        }
    }
}
