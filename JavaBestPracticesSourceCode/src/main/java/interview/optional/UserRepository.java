package interview.optional;

import java.util.Optional;

public class UserRepository {
    Optional<OptionalExamples.User> findById(int id) {
        return Optional.of(new OptionalExamples.User(id,"chelo", 50));
    }

}
