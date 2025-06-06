package com.mjmeal.mj_cafeteria_team_feedback_be.domain.store.repository;

import com.mjmeal.mj_cafeteria_team_feedback_be.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByName(String name);
}
