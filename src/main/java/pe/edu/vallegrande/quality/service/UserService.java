package pe.edu.vallegrande.quality.service;

import pe.edu.vallegrande.quality.model.User;
import pe.edu.vallegrande.quality.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public List<User> getAll() {
        return repo.getUsers().stream()
                .sorted(Comparator.comparing(User::getName, Comparator.nullsLast(String::compareToIgnoreCase)))
                .toList();
    }

    public User create(User user) {
        validateUser(user);
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(UUID.randomUUID().toString());
        }
        return repo.save(user);
    }

    private void validateUser(User user) {
        if (user == null) throw new IllegalArgumentException("User cannot be null");
        if (user.getName() == null || user.getName().isBlank()) throw new IllegalArgumentException("Name is required");
        if (user.getEmail() == null || user.getEmail().isBlank()) throw new IllegalArgumentException("Email is required");
        if (user.getAge() == null) throw new IllegalArgumentException("Age is required");
        if (user.getAge() < 0) throw new IllegalArgumentException("Age cannot be negative");
    }

    public Optional<User> find(String id) {
        return repo.findById(id);
    }

    public boolean remove(String id) {
        return repo.delete(id);
    }
}
