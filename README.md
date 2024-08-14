# Library System

## Overview
* The Library Management System is designed to efficiently manage library operations including books, patrons, and borrowing records. The system provides librarians with tools to handle book inventories, track patron activities, and manage borrowing transactions.



## Features
* Book Management: Manage books in the library by adding, updating, and removing book records. Each book includes details such as title, author, publication year, and ISBN.
* Patron Management: Manage library patrons by adding new patrons, updating their information, and removing them when needed. Each patron record includes details like name and contact information.
* Borrowing Records: Track borrowing transactions between books and patrons. The system records borrowing and return dates to manage book availability and ensure timely returns.


## Installation
* Clone the repository
* `Install Java on your system`
* [`Follow This Link`]([sfsdf](https://code.visualstudio.com/docs/java/java-spring-boot))
* Enjoy!

## More Information

> Database Schema Models
 
![Model](./src/main/resources/imgs/ERD%20Library%20System.png)

## Build The System

> The system is designed to manage a library's book inventory, patron records, and borrowing transactions. Librarians can add, update, and remove books, as well as manage patron information. Users can borrow books and track their return status. The system ensures that book availability and borrowing records are accurately maintained.



---


### Main API Endpoints

### 1. Book Management

> **Retrieve all books**
* **URL**: `/api/books`
* **Method**: `GET`
* **Description**: Retrieve a list of all books in the library.

> **Retrieve a specific book by ID**
* **URL**: `/api/books/{id}`
* **Method**: `GET`
* **Description**: Retrieve details of a specific book by its ID.

> **Add a new book**
* **URL**: `/api/books`
* **Method**: `POST`
* **Body**: 
```json
{
  "title": "Book Title",
  "author": "Author Name",
  "publicationYear": "2023",
  "isbn": "978-3-16-148410-0"
}
```

> **Update a new book**
* **URL**: `/api/books/id`
* **Method**: `PUT`
* **Body**: 
```json
{
  "title": "Book Title",
  "author": "Author Name",
  "publicationYear": "2023",
  "isbn": "978-3-16-148410-0"
}
```

> **Delete a book**
* **URL**: `/api/books/id`
* **Method**: `DELETE`

### 2. Patron Management

> **Retrieve all Patrons**
* **URL**: `/api/patrons`
* **Method**: `GET`
* **Description**: Retrieve a list of all patrons in the library.

> **Retrieve a specific patron by ID**
* **URL**: `/api/patrons/{id}`
* **Method**: `GET`
* **Description**: Retrieve details of a specific ptrons by its ID.

> **Add a new patron**
* **URL**: `/api/ptarons`
* **Method**: `POST`
* **Body**: 
```json
{
  "name": "Patron Title",
  "email": "Author Name",
  "phoneNumber": "2023"
}
```

> **Update a new patron**
* **URL**: `/api/patrons/id`
* **Method**: `PUT`
* **Body**: 
```json
{
  "name": "Patron Title",
  "email": "Author Name",
  "phoneNumber": "2023"
}
```

> **Delete a patron**
* **URL**: `/api/patrons/id`
* **Method**: `DELETE`


### 3. Borrow-Record Management

> **Borrow Book**
* **URL**: `/api/borrow/{bookId}/patron/{patronId}`
* **Method**: `POST`


> **Return Book**
* **URL**: `/api/return/{bookId}/patron/{patronId}`
* **Method**: `PUT`



[Full API Documentation](https://documenter.getpostman.com/view/29993767/2sA3s6Gq3S)

