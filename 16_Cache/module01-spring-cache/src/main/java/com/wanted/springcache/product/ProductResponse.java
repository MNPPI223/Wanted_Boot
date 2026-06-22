package com.wanted.springcache.product;

import java.util.List;

public record ProductResponse(

        String keyword,
        String category,
        Integer minPrice,
        Integer maxPrice,
        int totalCount,
        List<Product> products

) {
}
