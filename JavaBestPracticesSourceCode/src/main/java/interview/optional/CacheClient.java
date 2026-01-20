package interview.optional;

import java.util.Optional;

public class CacheClient {

    public Optional<OptionalExamples.User> getUser(int id) {
        return Optional.of(new OptionalExamples.User(1,"marcelo", 5));
    }
}
