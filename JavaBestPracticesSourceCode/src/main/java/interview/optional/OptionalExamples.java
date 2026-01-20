package interview.optional;

import java.util.*;

public class OptionalExamples {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        CacheClient cacheClient = new CacheClient();
        testOptionals(userRepository, cacheClient);

    }

    private static void testOptionals(UserRepository userRepository,CacheClient cacheClient) {
        int id = 1;
        Optional<User> primary = userRepository.findById(id);
        Optional<User> cache = cacheClient.getUser(id);
        var name=  primary.or(() -> cache).orElseThrow(() -> new NoSuchElementException("Not found"));
        System.out.println(name);
    }

    public record User(int id, String name, int age) {}


}
