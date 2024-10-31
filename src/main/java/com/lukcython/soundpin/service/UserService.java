package com.lukcython.soundpin.service;

import com.lukcython.soundpin.domain.User;
import com.lukcython.soundpin.dto.UserCreateDto;
import com.lukcython.soundpin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Boolean createUser(UserCreateDto userCreateDto) {
        Optional<User> user = userRepository.findByEmail(userCreateDto.getEmail());
        //여기서 .isEmpty 사용해도 되는지 확인 필요
        if (user.isEmpty()){
            userRepository.save(User.of(userCreateDto));
            return true;
        }
        else{
            return false;
        }
    }
}
