package com.torutk.book.bean;

public record Product(Integer id, String name, int price) {
    public Product(String name, int price) {
        this(0, name, price);
    }
}
