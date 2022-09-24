package io.spring.core.article;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "name")
@Table(name = "tags")
@Entity
public class Tag {
  @Id
  private String id;
  private String name;

  public Tag(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }
}
