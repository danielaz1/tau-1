#include <utility>

//
// Created by daniela on 24.01.20.
//

#include "Book.hpp"

Book::Book(int id, std::string title, float price) {
    this->id = id;
    this->title = std::move(title);
    this->price = price;
}

bool Book::equals(const Book &secondBook) {
    return id == secondBook.id;
}

int Book::getId() const {
    return id;
}

const std::string &Book::getTitle() const {
    return title;
}

float Book::getPrice() const {
    return price;
}

Book::Book() = default;
