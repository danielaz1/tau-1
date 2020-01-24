cmake_minimum_required(VERSION 3.5)

project(books-catch2-cmake LANGUAGES CXX VERSION 0.0.1)
set(CMAKE_CXX_FLAGS "-std=c++17 -Wall -Wextra")
include_directories("${PROJECT_SOURCE_DIR}/src")
file(GLOB_RECURSE lib_SOURCES "src/*.cpp" "src/*/*.cpp")
file(GLOB_RECURSE test_SOURCES "test/*.cpp")
add_library(db SHARED ${lib_SOURCES} src/Book.cpp src/Book.hpp)
install (TARGETS db DESTINATION lib)

find_package(Catch2 REQUIRED)

add_executable(books-catch2-cmake-test ${test_SOURCES})
target_link_libraries(books-catch2-cmake-test db Catch2::Catch2)

include(CTest)
include(Catch)
catch_discover_tests(books-catch2-cmake-test)
