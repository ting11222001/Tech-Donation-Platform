package io.techbridge.donation.service;

import io.techbridge.donation.domain.User;
import io.techbridge.donation.dto.UserDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 02/2026
 */
public interface UserService {
    UserDTO createUser(User user);
}
