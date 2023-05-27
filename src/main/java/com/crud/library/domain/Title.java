package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Entity(name = "titles")
@AllArgsConstructor
@NoArgsConstructor
public class Title {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long titleId;
    @Column(name = "TITLE_NAME", nullable = false)
    private String titleName;
    @Column(name = "AUTHOR", nullable = false)
    private String author;
    @Column(name = "PUBLICATION_DATE", nullable = false)
    private LocalDate publicationDate;
    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
            //mappedBy = "title"
    )
    @JoinColumn(name = "BOOKS")
    private List<Book> bookList;
}
