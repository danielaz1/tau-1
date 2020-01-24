#include <catch2/catch.hpp>

#include <db.hpp>

void insertExample();
void insertExamples();

TEST_CASE("Get all from db") {
    REQUIRE_NOTHROW(getAll());
}

TEST_CASE("Get all - empty") {
    REQUIRE(getAll().empty());
}

TEST_CASE("Add element") {
    REQUIRE_NOTHROW(insertExample());
}

TEST_CASE("Insert and get all") {
    insertExample();
    REQUIRE(getAll().size() == 1);
}

TEST_CASE("Find book by id") {
    insertExample();
    Book book = findById(0);
    REQUIRE(book.getId() == 0);
}

TEST_CASE("Find books by price") {
    insertExamples();
    std::list<Book> books = findByPrice(15.99);
    REQUIRE(books.size() == 2);
}

TEST_CASE("Delete book by id") {
    insertExamples();
    removeById(1);
    REQUIRE(getAll().size() == 2);
}

TEST_CASE("Delete book by id - throw exception") {
    insertExamples();
    REQUIRE_THROWS(removeById(4));
}

void insertExample() {
    add(0, "Title1", 20.49);
}

void insertExamples() {
    add(0, "Title1", 15.99);
    add(1, "Title2", 20.49);
    add(2, "Title3", 15.99);
}