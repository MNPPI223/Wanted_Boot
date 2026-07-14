package com.wanted.b_collection.a_list.compare;

import com.wanted.b_collection.a_list.dto.BookDTO;

import java.util.Comparator;

public class PriceLowerFirst implements Comparator<BookDTO> {
    @Override
    public int compare(BookDTO o1, BookDTO o2) {

        int result = 0;

        if (o1.getPrice() > o2.getPrice()) {
            result = -1;
        } else if (o2.getPrice() > o1.getPrice()) {
            result = 1;
        } else {
            result =0;
        }

        return result;

    }
}
