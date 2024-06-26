/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gestionetudiant.vue;

import com.mycompany.gestionetudiant.Interfaces.EventsListener;

import java.sql.SQLException;

/**
 *
 * @author syntax-error
 */
public class Entry extends javax.swing.JFrame implements EventsListener {
    private final Login login = new Login();
    private final Signup signup = new Signup();

    /**
     * Creates new form Entry
     */
    public Entry() throws SQLException {
        initComponents();
        login.setListener(this);
        signup.setListener(this);
        this.setContentPane(login);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 907, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void onClickLogin() {
        this.setContentPane(login);
        this.setVisible(true);
    }

    @Override
    public void onClickSignup() {
        this.setContentPane(signup);
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
