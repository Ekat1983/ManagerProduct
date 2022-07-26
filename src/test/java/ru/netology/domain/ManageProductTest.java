package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManageProductTest {
    Book book1 = new Book(1, 100, "1", "1");
    Book book2 = new Book(2, 200, "2", "2");
    Book book3 = new Book(3, 300, "3", "3");
    Smartphone smartphone = new Smartphone(4, 400, "М4", "4");
    Smartphone smartphone2 = new Smartphone(5, 500, "М5", "5");
    Smartphone smartphone3 = new Smartphone(6, 600, "М6", "6");
    Smartphone smartphone4 = new Smartphone(7, 700, "М7", "7");

    @Test
    public void managerSaveAndFindAll() {
        ManageProduct manager = new ManageProduct();
        manager.save(book1);
        manager.save(book2);

        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void managerSearchBy() {
        ManageProduct manager = new ManageProduct();
        manager.save(book1);
        manager.save(smartphone3);

        Product[] expected = new Product[]{book1};

        Product[] actual = manager.searchBy("1");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void managerNoFoundResults() {
        ManageProduct manager = new ManageProduct();
        manager.save(book1);
        manager.save(smartphone3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("9999");
        Assertions.assertArrayEquals(expected, actual);
    }
}