Scenario: remove books from store by given list

Given the books in store
author            | title                   | ISBN
J. R. R. Tolkien  | The Lord of the Rings   | 978-0451525556
George Orwell     | 1984                    | 978-0451524935
Stephen Hawking   | A Brief History of Time | 978-0553380163
Markus Zusak      | The Book Thief          | 978-0375842207
Margaret Atwood   | The Handmaid's Tale     | 978-0385490818
Suzanne Collins   | The Hunger Games        | 978-0439023528
William Golding   | Lord of the Flies       | 978-0399501487
When I remove a list of 978-0451524935, 978-0553380163, 978-0385490818, 978-0375842207
Then the books in store are
author            | title                   | ISBN
J. R. R. Tolkien  | The Lord of the Rings   | 978-0451525556
Suzanne Collins   | The Hunger Games        | 978-0439023528
William Golding   | Lord of the Flies       | 978-0399501487
