package dev.ganeshpc.productservice.learning.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_ta")
public class Ta extends User {

    private String className;
    
}
