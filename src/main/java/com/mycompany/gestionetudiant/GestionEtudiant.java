/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionetudiant;

import com.mycompany.gestionetudiant.vue.Entry;
import com.mycompany.gestionetudiant.vue.Home;
import com.mycompany.gestionetudiant.vue.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.*;
import java.util.prefs.Preferences;

/**
 *
 * @author syntax-error
 */
public class GestionEtudiant {
    private static final Preferences preferences = Preferences.systemNodeForPackage(Login.class);

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException ex) {
            Logger.getLogger(Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            Entry fen = null;

            if (!preferences.get("name", "").isEmpty()) {

                Home home = null;
                try {
                    home = new Home();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                home.setLocationRelativeTo(null);
                home.setVisible(true);

                return;
            }

            try {
                fen = new Entry();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            assert fen != null;
            fen.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fen.setLocationRelativeTo(null);
            fen.setVisible(true);
        });
    }
}
