package pl.mateusz.enums;

public class TicketMachine {

    public static double calculatePrice(Ticket ticket) {
        double ticketPriceBeforeDiscount = ticket.getPrice();
        return switch (ticket.getTicketType()) {
            case NORMAL -> ticketPriceBeforeDiscount;
            case STUDENT -> 0.7 * ticketPriceBeforeDiscount;
            case CHILD -> 0.5 * ticketPriceBeforeDiscount;
            case SENIOR -> 0.6 * ticketPriceBeforeDiscount;
        };
    }
}
