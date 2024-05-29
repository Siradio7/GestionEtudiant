package com.mycompany.gestionetudiant.dao;

import com.mycompany.gestionetudiant.model.Administrator;

public interface IAdministrator {
    public Administrator login(Administrator administrator);
    public boolean signup(Administrator administrator);
}
