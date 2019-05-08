package io.reflectoring.reviewapp.adapter.persistence;

import io.reflectoring.reviewapp.domain.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface BookRepository extends CrudRepository<BookJdbcEntity, Long> {

  @Query("select b.* from Book b where b.title = :title")
  Optional<BookJdbcEntity> findByTitle(@Param("title") String title);

}
