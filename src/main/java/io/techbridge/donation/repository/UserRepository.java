package io.techbridge.donation.repository;

import io.techbridge.donation.domain.User;

import java.util.Collection;

/**
 * @author Li-Ting Liao
 * @version 1.0
 * @since 02/2026
 */

public interface UserRepository <T extends User> {
    /* Basic CRUD Operations */
    T create(T data);
    Collection<T> list(int page, int pageSize);
    T get(Long id);
    T update(T data);
    Boolean delete(Long id);

    /* More Complex Operations */
}
