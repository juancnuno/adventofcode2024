package com.juancnuno.adventofcode2024.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

final class Update {

    private final List<Integer> pages;
    private final Comparator<Integer> comparator;

    Update(String pages, Comparator<Integer> comparator) {
        this(toPages(pages), comparator);
    }

    private Update(List<Integer> pages, Comparator<Integer> comparator) {
        this.pages = pages;
        this.comparator = comparator;
    }

    private static List<Integer> toPages(String pages) {
        return Arrays.stream(pages.split(","))
                .map(Integer::valueOf)
                .toList();
    }

    boolean isInRightOrder() {
        return pages.equals(sort(pages, comparator));
    }

    Update sortPages() {
        return new Update(sort(pages, comparator), comparator);
    }

    private static <E> List<E> sort(Collection<E> collection, Comparator<E> comparator) {
        var list = new ArrayList<>(collection);
        list.sort(comparator);

        return list;
    }

    int getMiddlePage() {
        assert pages.size() % 2 == 1 : pages;
        return pages.get(pages.size() / 2);
    }
}
