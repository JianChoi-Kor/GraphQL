package com.example.gql.repository;

import com.example.gql.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByIdx(int idx);
}
