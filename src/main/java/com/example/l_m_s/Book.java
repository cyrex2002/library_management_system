package com.example.l_m_s;

public class Book {
    int id;

    public Book(int id, String name, String cat, String author, int copies) {
        this.id = id;
        this.name = name;
        this.cat = cat;
        this.author = author;
        this.copies = copies;
    }

    String name;
    String cat;
    String author;
    int copies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
