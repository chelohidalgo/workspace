package other.unittests;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class UserManager {
    private final Map<String, User> users = new HashMap<>();

    void addUser(User user) {
        users.put(user.username(), user);
    }

    Optional<User> getUser(String username) {
        User userToReturn = users.get(username);
        if (userToReturn == null) {
            return Optional.empty();
        }
        return Optional.of(userToReturn);
    }

    boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    void deleteUser(String username) {
        users.remove(username);
    }

    int getUserCount() {
        return users.size();
    }
}
