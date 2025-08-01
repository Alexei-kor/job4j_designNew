package ru.job4j.iterator;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class MatrixIteratorTest {

    @Test
    void whenStandard() {
        int[][] input = {{1, 2}, {3, 4}};
        MatrixIterator iterator = new MatrixIterator(input);
        StringBuilder str = new StringBuilder();
        String expected = "1234";
        String fact = str
                .append(iterator.next())
                .append(iterator.next())
                .append(iterator.next())
                .append(iterator.next()).toString();
        assertThat(fact).isEqualTo(expected);
    }

    @Test
    void when4El() {
        int[][] input = {
                {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
    }

    @Test
    void whenFirstEmptyThenHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenRowHasDiffSize() {
        int[][] input = {
                {1}, {2, 3}, {}, {}, {4}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.next()).isEqualTo(3);
        assertThat(iterator.next()).isEqualTo(4);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenFewEmpty() {
        int[][] input = {
                {1}, {}, {}, {}, {2}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenEmpty() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }

    @Test
    void whenEmptyThenNext() {
        int[][] input = {
                {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThatThrownBy(iterator::next)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void whenMultiHasNext() {
        int[][] input = {
                {}, {1}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.hasNext()).isTrue();
    }

    @Test
    void whenNoElements() {
        int[][] input = {
                {}, {}, {}
        };
        MatrixIterator iterator = new MatrixIterator(input);
        assertThat(iterator.hasNext()).isFalse();
    }
}