package com.integration.integracion_despliegues.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.integracion_despliegues.models.User;

@Repository
public interface RepositorioUser extends JpaRepository<User, Integer>{
    
}
