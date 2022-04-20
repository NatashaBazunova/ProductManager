package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);
    Product first = new Product(1, "Keyboard", 890);
    Product second = new Book(2, "War and Peace", 500, "Leo Tolstoy");
    Product third = new Smartphone(3, "Xiaomi", 29990, "China");
    Product fourth = new Smartphone(4, "Xiaomi", 37990, "China");
    Product fifth = new Smartphone(5, "Lenovo", 35000, "China");


    @Test
    public void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        Product[] expected = new Product[] {first, second, third, fourth, fifth};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByName() {
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] expected = new Product[] {third, fourth};
        Product[] actual = manager.searchBy("Xiaomi");
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByNameOfProduct() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);

        Product[] expected = new Product[] {first};
        Product[] actual = manager.searchBy("Keyboard");
        assertArrayEquals(expected, actual);
    }


}