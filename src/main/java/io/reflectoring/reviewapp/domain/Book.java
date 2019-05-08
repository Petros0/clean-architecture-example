package io.reflectoring.reviewapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
public class Book {

  @Id
  private BookId id;
  private String title;
  private Long authorId;

  @Value
  public static class BookId {
    private final Long value;
  }

  // imagine some insanely complex business logic methods ...

}
