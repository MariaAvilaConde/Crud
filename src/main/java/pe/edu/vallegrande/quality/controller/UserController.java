
package pe.edu.vallegrande.quality.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import pe.edu.vallegrande.quality.dto.UserRequest;
import pe.edu.vallegrande.quality.model.User;
import pe.edu.vallegrande.quality.service.UserService;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = service.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest request) {
        User user = new User(null, request.getName(), request.getEmail(), request.getAge());
        User created = service.create(user);
        return ResponseEntity.ok(created);
    }


    @GetMapping("/user/{id}")
    public Object getOne(@PathVariable String id){
        Optional<User> u = service.find(id);
        if(u.isPresent()){
            return u.get();
        }
        return "not found";
    }

    @DeleteMapping("/del/{id}")
    public String delete(@PathVariable("id") String identifier){
        boolean ok = service.remove(identifier);
        if(ok){
            return "ok";
        }
        return "fail";
    }
}
