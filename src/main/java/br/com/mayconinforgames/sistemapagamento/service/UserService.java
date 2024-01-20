package br.com.mayconinforgames.sistemapagamento.service;

import br.com.mayconinforgames.sistemapagamento.entity.User;
import br.com.mayconinforgames.sistemapagamento.repository.UserRepository;
import br.com.mayconinforgames.sistemapagamento.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Este e-mail já existe");
        } else {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            String randomCode = RandomString.generateRandomString(64);
            user.setVerificationCode(randomCode);
            user.setEnabled(false);

            User savedUser = userRepository.save(user);

            return savedUser;
        }

    }

}
