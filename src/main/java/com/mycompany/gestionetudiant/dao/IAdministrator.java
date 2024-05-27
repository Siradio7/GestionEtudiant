package com.mycompany.gestionetudiant.dao;

import com.mycompany.gestionetudiant.model.Administrator;

public interface IAdministrator {
    public void login(Administrator administrator);
    public void signup(Administrator administrator);
}
