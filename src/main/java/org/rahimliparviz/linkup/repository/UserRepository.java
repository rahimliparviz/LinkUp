package org.rahimliparviz.linkup.repository;

import org.rahimliparviz.linkup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Integer, User> {
}
