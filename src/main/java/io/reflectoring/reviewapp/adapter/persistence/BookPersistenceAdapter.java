package io.reflectoring.reviewapp.adapter.persistence;

import io.reflectoring.reviewapp.application.port.out.FindBookByTitlePort;
import io.reflectoring.reviewapp.application.port.out.PersistBookPort;
import io.reflectoring.reviewapp.domain.Book;
import io.reflectoring.reviewapp.domain.Book.BookId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class BookPersistenceAdapter implements FindBookByTitlePort, PersistBookPort {

  private final BookRepository bookRepository;

  @Override
  public Optional<Book> findBookByTitle(String title) {
    return bookRepository.findByTitle(title)
            .map(this::toDomainObject);
  }

  @Override
  public Book saveBook(Book book) {
    return toDomainObject(bookRepository.save(toJdbcEntity(book)));
  }

  private BookJdbcEntity toJdbcEntity(Book book) {
    return new BookJdbcEntity(book.getId() == null ? null : book.getId().getValue(), book.getTitle(), book.getAuthorId());
  }

  private Book toDomainObject(BookJdbcEntity jdbcEntity) {
    return new Book(new BookId(jdbcEntity.getId()), jdbcEntity.getTitle(), jdbcEntity.getAuthorId());
  }
}
