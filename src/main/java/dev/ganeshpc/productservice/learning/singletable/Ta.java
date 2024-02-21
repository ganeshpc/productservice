package dev.ganeshpc.productservice.learning.singletable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "st_ta")
public class Ta extends User {

    private String className;
    
}
