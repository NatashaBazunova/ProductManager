package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repo = new Repository();
    Product first = new Product(1, "Keyboard", 890);
    Product second = new Book(2, "War and Peace", 500, "Leo Tolstoy");
    Product third = new Smartphone(3, "Xiaomi", 29990, "China");
    Product fourth = new Smartphone(4, "Xiaomi", 37990, "China");
    Product fifth = new Smartphone(5, "Lenovo", 35000, "China");

    @Test
    public void shouldFindAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        Product[] expected = new Product[]{first, second, third, fourth, fifth};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.removeById(5);
        Product[] expected = new Product[] {third, fourth};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);

        repo.save(fifth);

        Product[] expected = new Product[] {first, second, third, fourth, fifth};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.findById(3);
        Product expected = third;
        Product actual = repo.findById(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNull() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
       assertThrows(NotFoundException.class, () -> {
           repo.removeById(10);
       });
    }




}