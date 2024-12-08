package com.juancnuno.adventofcode2024.day05;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class PageComparator implements Comparator<Integer> {

    private final Map<Integer, Collection<Integer>> multimap = new HashMap<>();

    public void addRule(String rule) {
        var pages = rule.split("\\|");
        var page1 = Integer.parseInt(pages[0]);
        var page2 = Integer.parseInt(pages[1]);

        multimap.computeIfAbsent(page1, p1 -> new HashSet<>()).add(page2);
    }

    @Override
    public int compare(Integer page1, Integer page2) {
        var pagesThatMustBeAfter = multimap.get(page1);

        if (pagesThatMustBeAfter != null && pagesThatMustBeAfter.contains(page2)) {
            return -1;
        }

        pagesThatMustBeAfter = multimap.get(page2);

        if (pagesThatMustBeAfter.contains(page1)) {
            return 1;
        }

        assert page1.equals(page2) : page1 + ", " + page2;
        return 0;
    }
}
