package ru.jpb4j.asser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void getAreaTest() {
        Box box = new Box(4, 2);
        double area = box.getArea();
        double expected = 6.929d;
        assertThat(area).isEqualTo(expected, withPrecision(0.001d));
    }
}