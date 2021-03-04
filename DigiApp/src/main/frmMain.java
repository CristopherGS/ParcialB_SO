/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import clases.*;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miguel Matul <https://github.com/MigueMat4>
 */
public class frmMain extends javax.swing.JFrame {

    HiloObtener elegircmb = new HiloObtener();//El hilo especialmente solo para obtener los datos
    HiloObtenerBatalla obtenerBatalla;

    Digimon peleador1, peleador2; // digimons que van a pelear
    String[] columnas = {"Nombre", "Nivel"}; // columnas para la tabla
    DefaultTableModel model = new DefaultTableModel(columnas, 0); // tabla a usar
    DigiWorld yggdrasill; // clase para conectarse a la API y descargar el listado de objetos
    RumbleArena estadio; // clase para elegir a los digimon que van a pelar, carga la imagen de ellos
    Reloj reloj = new Reloj(); // objeto para la hora del sistema. ¡No modificar!

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        setLocationRelativeTo(null);
        tblDigimon.setModel(model); // diseña la tabla en base a las columnas definidas
        btnBatalla.setEnabled(false); // no se puede batallar si no hay digimons peleadores
        reloj.start(); // objeto iniciado para la hora del sistema. ¡No modificar!
    }

    // clase para elegir a los peleadores
    public class RumbleArena {

        public void elegirDigimon() {
            btnElegir.setEnabled(false);
            btnBatalla.setEnabled(false);
            System.out.println("Eligiendo a los combatientes...");
            // código para elegir al primer peleador
            int digielecto1 = (int) ((Math.random() * ((yggdrasill.getDigimons().size() - 1) - 0)) + 0);
            peleador1 = yggdrasill.getDigimons().get(digielecto1);
            try {
                URL url = new URL(peleador1.getImg());
                Image img = ImageIO.read(url);
                img = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                lblDigimon1.setIcon(new ImageIcon(img));
            } catch (MalformedURLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblDigimon1.setText(peleador1.getName());
            // código para elegir al segundo peleador
            // <Inserte su código aquí>
            int digielecto2 = (int) ((Math.random() * ((yggdrasill.getDigimons().size() - 1) - 0)) + 0);
            peleador2 = yggdrasill.getDigimons().get(digielecto2);
            try {
                URL url = new URL(peleador2.getImg());
                Image img = ImageIO.read(url);
                img = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
                lblDigimon2.setIcon(new ImageIcon(img));
            } catch (MalformedURLException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblDigimon2.setText(peleador2.getName());
            System.out.println("¡Peladores listos para la batalla!");
            btnElegir.setEnabled(true);
            btnBatalla.setEnabled(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnGetDigimon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDigimon = new javax.swing.JTable();
        btnElegir = new javax.swing.JButton();
        lblDigimon1 = new javax.swing.JLabel();
        lblDigimon2 = new javax.swing.JLabel();
        btnBatalla = new javax.swing.JButton();
        lblHH = new javax.swing.JLabel();
        lblMM = new javax.swing.JLabel();
        lblSS = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Digi App");

        btnGetDigimon.setText("Obtener digimon");
        btnGetDigimon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetDigimonActionPerformed(evt);
            }
        });

        tblDigimon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblDigimon);

        btnElegir.setText("Elegir combatientes");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });

        lblDigimon1.setText("Digimon 1");

        lblDigimon2.setText("Digimon 2");

        btnBatalla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBatalla.setText("Batallar");
        btnBatalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatallaActionPerformed(evt);
            }
        });

        lblHH.setText("HH:");

        lblMM.setText("MM:");

        lblSS.setText("SS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblDigimon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDigimon2)
                .addGap(70, 70, 70))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(120, 120, 120)
                .addComponent(lblHH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMM)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSS)
                .addGap(56, 56, 56))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnElegir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(btnGetDigimon))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(btnBatalla, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblHH)
                    .addComponent(lblMM)
                    .addComponent(lblSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetDigimon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnElegir)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigimon1)
                    .addComponent(lblDigimon2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(btnBatalla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatallaActionPerformed
        // código para elegir un ganador en la batalla
        int nivel1 = 1, nivel2 = 1; // variables que representarán los niveles de los digimon
        System.out.println("Pelea en curso ...");
        // Peleador 1
        if (peleador1.getLevel().equals("Mega")) // nivel más alto
        {
            nivel1 = 7;
        }
        if (peleador1.getLevel().equals("Ultimate")) {
            nivel1 = 6;
        }
        if (peleador1.getLevel().equals("Champion")) {
            nivel1 = 5;
        }
        if (peleador1.getLevel().equals("Armor")) {
            nivel1 = 4;
        }
        if (peleador1.getLevel().equals("Rookie")) {
            nivel1 = 3;
        }
        if (peleador1.getLevel().equals("In Training")) {
            nivel1 = 2;
        }
        if (peleador1.getLevel().equals("Fresh")) // nivel más bajo
        {
            nivel1 = 1;
        }
        // Peleador 2
        if (!peleador2.getLevel().equals("Mega")) {
        } else {
            nivel2 = 7;
        }
        if (peleador2.getLevel().equals("Ultimate")) {
            nivel2 = 6;
        }
        if (peleador2.getLevel().equals("Champion")) {
            nivel2 = 5;
        }
        if (peleador2.getLevel().equals("Armor")) {
            nivel2 = 4;
        }
        if (peleador2.getLevel().equals("Rookie")) {
            nivel2 = 3;
        }
        if (peleador2.getLevel().equals("In Training")) {
            nivel2 = 2;
        }
        if (peleador2.getLevel().equals("Fresh")) {
            nivel2 = 1;
        }
        if (nivel2 < nivel1) {
            JOptionPane.showMessageDialog(null, "Gano el peleador: "+peleador1.getName()+"\n"+"Puntos: "+nivel1);
        }
        if (nivel2 > nivel1) {
            JOptionPane.showMessageDialog(null, "Gano el peleador: "+peleador2.getName()+"\n"+"Puntos: "+nivel2);
        }
        if (nivel2 == nivel1) {
            JOptionPane.showMessageDialog(null, "Es un empate de los peleadores: "+peleador1.getName()+" y "+peleador2.getName()+"\n"+
                     "Puntos "+peleador1.getName()+": "+nivel1+"\n"+"Puntos "+peleador2.getName()+": "+nivel2);
        }

        System.out.println("¡Resultado de la batalla!");
    }//GEN-LAST:event_btnBatallaActionPerformed

    private void btnGetDigimonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetDigimonActionPerformed
        
        elegircmb.start();
    }//GEN-LAST:event_btnGetDigimonActionPerformed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        obtenerBatalla = new HiloObtenerBatalla();
        obtenerBatalla.start();
        /*
        estadio = new RumbleArena(); // un nuevo estadio para cada clic en el botón de batalla
        estadio.elegirDigimon(); // código de la clase para elegir a los digimon que pelearán*/
    }//GEN-LAST:event_btnElegirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
        System.out.println("LOGS:");
    }

    // clase para la hora del sistema. ¡No modificar!
    public class Reloj extends Thread {

        Calendar calendario;

        @Override
        public void run() {
            while (true) {
                calendario = Calendar.getInstance();
                if (calendario.get(Calendar.HOUR_OF_DAY) < 10) {
                    lblHH.setText(String.valueOf("0" + calendario.get(Calendar.HOUR_OF_DAY)) + " :");
                } else {
                    lblHH.setText(String.valueOf(calendario.get(Calendar.HOUR_OF_DAY)) + " :");
                }
                if (calendario.get(Calendar.MINUTE) < 10) {
                    lblMM.setText(String.valueOf("0" + calendario.get(Calendar.MINUTE)) + " :");
                } else {
                    lblMM.setText(String.valueOf(calendario.get(Calendar.MINUTE)) + " :");
                }
                if (calendario.get(Calendar.SECOND) < 10) {
                    lblSS.setText(String.valueOf("0" + calendario.get(Calendar.SECOND)) + " hrs");
                } else {
                    lblSS.setText(String.valueOf(calendario.get(Calendar.SECOND)) + " hrs");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public class HiloObtener extends Thread {
        @Override
        public void run() {
            yggdrasill = new DigiWorld(model);
            try {
                yggdrasill.descargarDatos();
            } catch (IOException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnGetDigimon.setEnabled(false);
        }
    }
    public class HiloObtenerBatalla extends Thread {
        @Override
        public void run() {
        estadio = new RumbleArena(); // un nuevo estadio para cada clic en el botón de batalla
        estadio.elegirDigimon(); // código de la clase para elegir a los digimon que pelearán
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatalla;
    private javax.swing.JButton btnElegir;
    private javax.swing.JButton btnGetDigimon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblDigimon1;
    private javax.swing.JLabel lblDigimon2;
    private javax.swing.JLabel lblHH;
    private javax.swing.JLabel lblMM;
    private javax.swing.JLabel lblSS;
    private javax.swing.JTable tblDigimon;
    // End of variables declaration//GEN-END:variables
}
