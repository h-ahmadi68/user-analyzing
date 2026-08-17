package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity(name = "simple_user")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class SimpleUser {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private String username;
    private String firstName;
    private String lastName;

}
