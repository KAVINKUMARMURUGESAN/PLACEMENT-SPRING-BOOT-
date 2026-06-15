package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.DTO.CartitemRequestDTO;
import com.example.demo.Model.Cartitem;
import com.example.demo.Service.CartService;
import java.util.List;
@RestController

@RequestMapping("/api/v1/cart")
public class CartContoller {
    @Autowired
    CartService cartservice;
    @PostMapping
   public ResponseEntity<String> addTocart(@RequestHeader("X-Student-ID") String studentId,@RequestBody CartitemRequestDTO  request ){
    if(cartservice.addToCart(studentId,request)) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
else{
                return ResponseEntity.badRequest().body("Product is out of Stock or Student not found");
    }
   }
   
   @DeleteMapping("/items/{productid}")
   public ResponseEntity<Void> removeFromcart(@RequestHeader("X-Student-ID") String studentID,@PathVariable Long productid ){
     boolean deleted=cartservice.deleteItemFromcart(studentID,productid);
     return deleted? ResponseEntity.noContent().build():ResponseEntity.notFound().build();
   }

   @GetMapping
   public ResponseEntity<List<Cartitem>> getcart(@RequestHeader("X-Student-ID") String studentID){
  return ResponseEntity.ok(cartservice.getcart(studentID));
   }
}
    

