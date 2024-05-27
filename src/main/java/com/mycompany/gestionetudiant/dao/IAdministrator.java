package com.mycompany.gestionetudiant.dao;

import com.mycompany.gestionetudiant.model.Administrator;

public interface IAdministrator {
    public boolean login(Administrator administrator);
    public boolean signup(Administrator administrator);
}
