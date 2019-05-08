package io.reflectoring.reviewapp.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("BOOK")
class BookJdbcEntity {

  @Id
  private Long id;
  private String title;
  private Long authorId;

}
