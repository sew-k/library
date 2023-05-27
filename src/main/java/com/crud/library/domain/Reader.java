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
@Entity(name = "readers")
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    private Long readerId;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "SECOND_NAME", nullable = false)
    private String secondName;
    @Column(name = "ACCOUNT_CREATION_DATE", nullable = false)
    private LocalDate accountCreationDate;
    @OneToMany(
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
            //mappedBy = "reader"
    )
    @JoinColumn(name = "BORROWING_LIST")
    private List<Borrowing> borrowingList;
}
