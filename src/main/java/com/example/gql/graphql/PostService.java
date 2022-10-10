package com.example.gql.graphql;

import com.example.gql.domain.Author;
import com.example.gql.domain.Post;
import com.example.gql.repository.AuthorRepository;
import com.example.gql.repository.PostRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final AuthorRepository authorRepository;
    private final PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(int idx) {
        return postRepository.findByIdx(idx);
    }

    public Post createPost(String title, String content, String category, int authorIdx) {
        //author
        Author findAuthor = authorRepository.findByIdx(authorIdx);

        //post
        Post post = Post.builder()
                .title(title)
                .contents(content)
                .category(category)
                .author(findAuthor)
                .build();
        post = postRepository.save(post);

        return post;
    }

    public Post updatePostTitle(int idx, String title) {
        //post
        Post post = postRepository.findByIdx(idx);

        //update title
        post.setTitle(title);
        post = postRepository.save(post);

        return post;
    }
}
