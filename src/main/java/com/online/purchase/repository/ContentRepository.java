package com.online.purchase.repository;


import com.online.purchase.model.Category;
import com.online.purchase.model.Content;
import com.online.purchase.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository("roleRepository")
public interface ContentRepository extends JpaRepository<Content,Long> {
}
