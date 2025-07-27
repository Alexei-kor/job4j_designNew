package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Balancer {

    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int x = 0;
        while (source.hasNext()) {
            if (x < nodes.size())
                nodes.get(x).add(source.next());
            if (x == nodes.size()-1)
                x= 0;
            else
                x++;
        }
    }

}
