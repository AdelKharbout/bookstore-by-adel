package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private String id;
    private String name;
    private String country;
    private LocalDate birthDate;

    public Author() {
    }

    public Author(String id, String name, String country, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthDate = birthDate;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Author author)) {
            return false;
        } else {
            return Objects.equals(this.id, author.id) && Objects.equals(this.name, author.name) && Objects.equals(this.country, author.country) && Objects.equals(this.birthDate, author.birthDate);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name, this.country, this.birthDate});
    }

    public String toString() {
        return "Author{id=" + this.id + ", name='" + this.name + "', country='" + this.country + "', birthDate='" + this.birthDate + "'}";
    }
}
