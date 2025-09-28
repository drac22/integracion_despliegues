package com.integration.integracion_despliegues.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.integration.integracion_despliegues.models.User;
import com.integration.integracion_despliegues.repo.RepositorioUser;

@Service
public class ServiceUserImpl implements ServiceUser{

    private RepositorioUser repositorioUser;

    public ServiceUserImpl(RepositorioUser repositorioUser){
        this.repositorioUser = repositorioUser;
    }

    @Override
    public User createUser(User user) {
        return repositorioUser.save(user);
    }

    @Override
    public Boolean deleteUser(int id) {
        if (repositorioUser.existsById(id)) {
            repositorioUser.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> usuarios() {
        return repositorioUser.findAll();
    }

}
