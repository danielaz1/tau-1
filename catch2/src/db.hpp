//
// Created by daniela on 12.01.20.
//

#ifndef __DB___
#define __DB___

#include <bits/stdc++.h>
#include "Book.hpp"


std::map<int, Book> database = std::map<int, Book>();

std::map<int, Book> getAll();

void add(int, std::string, float);

Book findById(int);

std::list<Book> findByPrice(float);

void removeById(int);

#endif
