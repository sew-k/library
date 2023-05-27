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
@Entity(name = "borrowings")
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long borrowingId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "READER_ID", nullable = false)
    private Reader reader;
    @OneToMany(
            targetEntity = Book.class,
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
            //mappedBy = "borrowing"
    )
    @JoinColumn(name = "BOOK_LIST")
    private List<Book> bookList;
    @Column(name = "BORROW_DATE", nullable = false)
    private LocalDate borrowDate;
    @Column(name = "RETURN_DATE", nullable = false)
    private LocalDate returnDate;
}
