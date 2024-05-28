package com.init.spring.jpa.h2.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tutorials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;

  @Column(name = "title")
  String title;

  @Column(name = "description")
  String description;

  @Column(name = "published")
  boolean published;

}
