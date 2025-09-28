package com.integration.integracion_despliegues.Service;

import java.util.List;

import com.integration.integracion_despliegues.models.User;

public interface ServiceUser{
    List<User> usuarios();
    User createUser(User user);
    Boolean deleteUser(int id);
}
