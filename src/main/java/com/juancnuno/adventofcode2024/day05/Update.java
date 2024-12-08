package com.juancnuno.adventofcode2024.day05;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class Update {

    private final List<Integer> pages;

    Update(String pages) {
        this(toPages(pages));
    }

    private Update(List<Integer> pages) {
        this.pages = pages;
    }

    private static List<Integer> toPages(String pages) {
        return Arrays.stream(pages.split(","))
                .map(Integer::valueOf)
                .toList();
    }

    boolean isInRightOrder(Map<Integer, Collection<Integer>> multimap) {
        var count = pages.size();

        if (count == 1) {
            return true;
        }

        var pagesThatMustBeAfter = multimap.get(pages.getFirst());

        if (pagesThatMustBeAfter == null) {
            return false;
        }

        var subList = pages.subList(1, count);

        if (!subList.stream().allMatch(pagesThatMustBeAfter::contains)) {
            return false;
        }

        return new Update(subList).isInRightOrder(multimap);
    }

    int getMiddlePage() {
        assert pages.size() % 2 == 1 : pages;
        return pages.get(pages.size() / 2);
    }
}
