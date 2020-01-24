#include <utility>

#include <utility>

//
// Created by daniela on 12.01.20.
//

#include <db.hpp>
#include "db.hpp"

std::map<int, Book> getAll() {
    return database;
}

void add(int id, std::string title, float price) {
    database.emplace(id, Book(id, std::move(title), price));
}

Book findById(int id) {
    return database.at(id);
}

std::list<Book> findByPrice(float price) {
    std::list<Book> books = std::list<Book>();
    for (auto &it : database) {
        if (it.second.getPrice() == price)
            books.push_back(it.second );
    }
    return books;
}

void removeById(int id) {
    unsigned long result = database.erase(id);
    if (result == 0) {
        throw std::invalid_argument( "Element not exists in db" );
    }
}

