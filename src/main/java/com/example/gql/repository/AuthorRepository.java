package com.example.gql.repository;

import com.example.gql.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByIdx(int idx);
}
