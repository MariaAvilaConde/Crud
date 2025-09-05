package pe.edu.vallegrande.quality.repository;

import pe.edu.vallegrande.quality.model.User;
import java.util.*;

public class UserRepository {

    // Almacenamiento en memoria, clave = id del usuario
    private static final Map<String, User> users = new HashMap<>();

    // Devuelve una lista inmutable de usuarios
    public List<User> getUsers() {
        return List.copyOf(users.values());
    }

    // Guarda o actualiza un usuario (reemplaza si el id ya existe)
    public User save(User u) {
        if (u == null || u.id == null) {
            throw new IllegalArgumentException("El usuario y su ID no pueden ser nulos.");
        }
        users.put(u.id, u);
        return u;
    }

    // Busca un usuario por ID
    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    // Elimina un usuario por ID
    public boolean delete(String id) {
        return users.remove(id) != null;
    }
}
