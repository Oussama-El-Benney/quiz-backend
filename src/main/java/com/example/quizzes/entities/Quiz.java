package com.example.quizzes.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
//, fetch = FetchType.EAGER
    @OneToMany(mappedBy = "quizFather", fetch = FetchType.LAZY)
    private List<Question> questions;


}
