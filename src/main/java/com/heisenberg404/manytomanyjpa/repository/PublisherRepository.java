package com.heisenberg404.manytomanyjpa.repository;

import com.heisenberg404.manytomanyjpa.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
