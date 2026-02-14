package io.techbridge.donation.resource;

import io.techbridge.donation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 02/2026
 */

@RestController
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;
}
