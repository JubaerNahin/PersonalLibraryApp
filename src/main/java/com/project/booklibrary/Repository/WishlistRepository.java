package com.project.booklibrary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.booklibrary.Entity.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Long> {
  
}