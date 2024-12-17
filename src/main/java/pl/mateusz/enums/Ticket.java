package pl.mateusz.enums;

public class Ticket {
    private double price;
    private TicketType ticketType;

    public Ticket(double price, TicketType ticketType) {
        this.price = price;
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public TicketType getTicketType() {
        return ticketType;
    }
}
