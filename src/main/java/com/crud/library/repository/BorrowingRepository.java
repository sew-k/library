package com.crud.library.repository;

import com.crud.library.domain.Borrowing;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowingRepository extends CrudRepository<Borrowing, Long> {
    @Override
    List<Borrowing> findAll();
    @Override
    Optional<Borrowing> findById(Long id);
    @Override
    Borrowing save(Borrowing borrowing);
    @Override
    void deleteById(Long id);
}
