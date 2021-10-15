package com.example.acmdemo;

public class Book {
    private String name, author, imageURL;

    public Book(String name, String author, String imageURL) {
        this.name = name;
        this.author = author;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
