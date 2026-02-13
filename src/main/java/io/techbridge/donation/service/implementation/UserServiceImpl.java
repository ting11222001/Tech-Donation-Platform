package io.techbridge.donation.service.implementation;

import io.techbridge.donation.domain.User;
import io.techbridge.donation.dto.UserDTO;
import io.techbridge.donation.dtoMapper.UserDTOMapper;
import io.techbridge.donation.repository.UserRepository;
import io.techbridge.donation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 02/2026
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository<User> userRepository;
    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
