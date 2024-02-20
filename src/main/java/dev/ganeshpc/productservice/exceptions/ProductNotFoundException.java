package dev.ganeshpc.productservice.exceptions;

// import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.ResponseStatus;


// Allows to handle exception and status code from here itself
// @ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ProductNotFoundException extends Exception {
    
    public ProductNotFoundException(String message) {
        super(message);
    }
}
