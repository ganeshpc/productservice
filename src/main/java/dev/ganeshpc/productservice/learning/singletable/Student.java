package dev.ganeshpc.productservice.learning.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_student")
public class Student extends User {

    private int psp;
    
}
