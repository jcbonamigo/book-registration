package com.jcbonamigo.librarysystem.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;


@Entity
@Table(name = Book.TABLE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Book {

    public static final String TABLE_NAME = "book";
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", length = 300, nullable = false)
    @Size(min = 2, max = 300)
    @NotBlank
    private String title;

    @Column(name = "publisher", length = 100, nullable = false)
    @Size(min = 2, max = 100)
    @NotBlank
    private String publisher;

    @ManyToMany
    @JoinTable(name = "books_authors",
                joinColumns = @JoinColumn (name="book_fk"),
                inverseJoinColumns = @JoinColumn (name="author_fk"))
    private Set<Author> authors = new HashSet<>();

/*  @ManyToMany
    @JoinTable(name = "books_users",
                joinColumns = @JoinColumn (name="book_fk"),
                inverseJoinColumns = @JoinColumn (name="user_fk"))
    Set<User> users;
*/

}
