package ru.netology.javaqa.hwsort.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldSortTicketsMoreOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11);
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 19);
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 15, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Orsk", "MSK");
        Ticket[] expected = {ticket4, ticket7, ticket6, ticket1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsNotFromTo() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11);
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 19);
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 15, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("LA", "MSK");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11);
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 19);
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 15, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Sochi", "SPB");
        Ticket[] expected = {ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithComparatorMoreOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11); //3
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 22);//6
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);//2
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 10, 18);//8
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Orsk", "MSK", comparator);
        Ticket[] expected = {ticket6, ticket1, ticket4, ticket7};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortTicketsWithComparatorOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11);
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 22);
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 10, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("UFA", "KAZAN", comparator);
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortTicketsWithComparatorNot() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Orsk", "MSK", 850, 8, 11);
        Ticket ticket2 = new Ticket("Omsk", "MSK", 1200, 12, 18);
        Ticket ticket3 = new Ticket("UFA", "KAZAN", 200, 9, 10);
        Ticket ticket4 = new Ticket("Orsk", "MSK", 150, 16, 22);
        Ticket ticket5 = new Ticket("Sochi", "SPB", 350, 8, 10);
        Ticket ticket6 = new Ticket("Orsk", "MSK", 185, 10, 12);
        Ticket ticket7 = new Ticket("Orsk", "MSK", 150, 10, 18);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "KAZAN", comparator);
        Ticket[] expected = { };
        Assertions.assertArrayEquals(expected, actual);
    }
}
