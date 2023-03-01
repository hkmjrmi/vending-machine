package com.uob.repository;

import com.uob.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SlotRepository extends JpaRepository <Slot, Long> {

    Optional<Slot> findBySize(String size);
}
