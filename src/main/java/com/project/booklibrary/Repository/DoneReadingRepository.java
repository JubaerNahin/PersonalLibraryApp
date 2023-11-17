package com.project.booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.booklibrary.Entity.DoneReading;

@Repository
public interface DoneReadingRepository extends JpaRepository<DoneReading,Long> {
  
}