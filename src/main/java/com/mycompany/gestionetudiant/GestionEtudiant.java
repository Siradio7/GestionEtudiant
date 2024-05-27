/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionetudiant;

import com.mycompany.gestionetudiant.vue.Entry;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.*;

/**
 *
 * @author syntax-error
 */
public class GestionEtudiant {

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
