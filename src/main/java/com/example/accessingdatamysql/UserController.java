package com.example.accessingdatamysql;

import java.math.BigInteger;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    private CountryRepository countryRepository;

    UserController(UserRepository userRepository, CountryRepository countryRepository) {
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }

    @PostMapping("/add")
    public User addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam BigInteger countryId) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        Optional<Country> optionalCountry = countryRepository.findById(countryId);
        if(optionalCountry.isPresent()){
            Country country = optionalCountry.get();
            user.setCountry(country);
        }

        userRepository.save(user);

        return user;
    }

    @GetMapping("/get")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
