package com.example.gql.domain;

import lombok.*;

import javax.persistence.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @Column(name = "idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idx;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "contents", nullable = false)
    private String contents;

    @Column(name = "category", nullable = false)
    public String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_idx", referencedColumnName = "idx")
    private Author author;
}
