package io.techbridge.donation.repository.implementation;

import io.techbridge.donation.domain.Role;
import io.techbridge.donation.domain.User;
import io.techbridge.donation.exception.ApiException;
import io.techbridge.donation.repository.RoleRepository;
import io.techbridge.donation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static io.techbridge.donation.enumeration.RoleType.ROLE_USER;
import static io.techbridge.donation.query.UserQuery.*;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 02/2026
 */

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;

    @Override
    public User create(User user) {
        // Check the email is unique
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) {
            throw new ApiException("Email already in use. Please use a different email.");
        }
        // Save new user
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(Objects.requireNonNull(holder.getKey()).longValue());

            // Add role to the user
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());

            // Send verification URL
            // Save URL in the verification table
            // Send email to user with the verification URL
            // Return the newly created user
            // If any errors, throw exception with a proper msg
        } catch (EmptyResultDataAccessException exception) {

        } catch (Exception exception) {
            throw new ApiException("An error occurred. Please try again.");
        };
        return null;
    }


    @Override
    public Collection<User> list(int page, int pageSize) {
        return List.of();
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
    }
}
