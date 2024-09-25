package com.react.kodbook.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.react.kodbook.entities.Post;
public interface PostRepository extends JpaRepository<Post,Long>{

}

