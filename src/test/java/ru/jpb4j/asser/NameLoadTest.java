package ru.jpb4j.asser;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameLoadTest {

    @Test
    public void addMapTest() {
        NameLoad nameLoad = new NameLoad();
        nameLoad.parse("one=1", "two=2", "three=3");
        Map<String, String> expected = new HashMap<>();
        expected.put("one", "1");
        expected.put("two", "2");
        expected.put("three", "3");
        assertThat(nameLoad.getMap()).containsKeys("one", "two", "three");
    }

}