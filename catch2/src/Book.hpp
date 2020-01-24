//
// Created by daniela on 24.01.20.
//

#ifndef HELLO_CATCH2_CMAKE_BOOK_HPP
#define HELLO_CATCH2_CMAKE_BOOK_HPP


#include <string>

class Book {

private:
    int id;
    std::string title;
    float price;
public:
    Book(int, std::string, float);
    Book();
    bool equals(const Book&);

    int getId() const;

    const std::string &getTitle() const;

    float getPrice() const;

};


#endif //HELLO_CATCH2_CMAKE_BOOK_HPP
