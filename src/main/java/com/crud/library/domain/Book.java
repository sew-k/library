package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long bookId;
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
//    @JoinColumn(name = "TITLE_ID", nullable = false)
    @JoinColumn(name = "TITLE_ID")
    private Title title;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "BORROWING_ID")
    private Borrowing borrowing;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private Status status;
}
