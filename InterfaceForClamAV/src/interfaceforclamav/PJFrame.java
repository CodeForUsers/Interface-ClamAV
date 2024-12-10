
package interfaceforclamav;

import com.formdev.flatlaf.FlatDarkLaf;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author David C.G. 
 */
public class PJFrame extends javax.swing.JFrame {


    public PJFrame() {
        initComponents();
        llenarcombox();
    }
    // Declaraciones de Metodos Generales
    EjecutarComando sc = new EjecutarComando();
    String comando = ".\\clamscan.exe -r ";

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_unit = new javax.swing.JLabel();
        units = new javax.swing.JComboBox<>();
        scan = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        deletevirus = new javax.swing.JCheckBox();
        STOP = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        folder = new javax.swing.JTextField();
        folderb = new javax.swing.JButton();
        option = new javax.swing.JToggleButton();
        option_label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 10)); // NOI18N
        setIconImage(new ImageIcon(getClass().getResource("/img/clamav.png")).getImage());
        setResizable(false);

        label_unit.setText("Unit: ");

        units.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        units.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitsActionPerformed(evt);
            }
        });

        scan.setText("SCAN");
        scan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scanActionPerformed(evt);
            }
        });

        deletevirus.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        deletevirus.setText("Delete Virus automatically");
        deletevirus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletevirusActionPerformed(evt);
            }
        });

        STOP.setText("STOP");
        STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STOPActionPerformed(evt);
            }
        });
        folderb.setEnabled(false);
        units.setEnabled(false);
        STOP.setEnabled(false);
        scan.setEnabled(false);
        deletevirus.setEnabled(false);
        jSpinner1.setEnabled(true);

        jTextPane1.setEditable(false);
        jTextPane1.setText(" ClamAV is an open source antivirus,\n this program is only a graphical interface for this,\n for use it requires the installation of clamAV\n download here: https://www.clamav.net/ \n\n");
        jScrollPane2.setViewportView(jTextPane1);
        new color(jTextPane1);

        folder.setEditable(false);
        folder.setText("Folder");

        folderb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-folder-128.png"))); // NOI18N
        folderb.setBorderPainted(false);
        folderb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                folderbActionPerformed(evt);
            }
        });

        option.setBackground(java.awt.Color.gray);
        option.setText("Click");
        folderb.setEnabled(false);
        units.setEnabled(false);
        option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionActionPerformed(evt);
            }
        });

        option_label.setText("Analyze option: ");

        jLabel1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jLabel1.setText("Max File Size (MB)");

        jMenu2.setText("Options");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setText("Create Database");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Update Database");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem5.setText("Scan log");
        jMenuItem5.setActionCommand("");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("About");

        jMenuItem4.setText("Info");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setText("ClamAV- info");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_unit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(units, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                                .addComponent(folderb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(folder, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(option_label)
                                .addGap(18, 18, 18)
                                .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(deletevirus)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scan, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(STOP, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option)
                    .addComponent(option_label))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(folder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(folderb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(units, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_unit)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deletevirus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scan)
                    .addComponent(STOP))
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Salir del programa
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void unitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitsActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_unitsActionPerformed
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
    Updater update = new Updater(); 
    String resultado = update.updateDatabase("C:\\Program Files\\ClamAV"); 
    jTextPane1.setText(resultado);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CrearDataBase data = new CrearDataBase();
        data.crearArchivoFreshclamConf();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void scanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scanActionPerformed

        if(units.isEnabled()){
            sc.ejecutarComando(comando,units.getSelectedItem().toString(),jTextPane1,jProgressBar1);
        }else{
            sc.ejecutarComando(comando,folder.getText(),jTextPane1,jProgressBar1);
        }      
    }//GEN-LAST:event_scanActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "ClamAV GUI\n" + "Version: 2.0 - 101224\n" + "Author: David C.G.\n" + " 2024-2025 ClamAV Interface Proyect\n\n"+"github.com/CodeForUsers", "About", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void deletevirusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletevirusActionPerformed
        // TODO add your handling code here:
           if (deletevirus.isSelected()) {
            comando = comando.concat(" --remove"); } 
            else { comando = comando.concat(""); 
        } 
    }//GEN-LAST:event_deletevirusActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    try {
        File file = new File("../resultData/result.txt"); // Ruta del archivo
        if (file.exists()) {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(this, "Apertura de archivo no soportada en tu sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "There's no analysis", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STOPActionPerformed
        // TODO add your handling code here:
        taskiller killer = new taskiller();
        killer.killProcessByName("clamscan.exe");
        
    }//GEN-LAST:event_STOPActionPerformed

    private void folderbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_folderbActionPerformed
        // TODO add your handling code here:
       JFileChooser fileChooser = new JFileChooser(); 
       fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(folderb);
       int result = fileChooser.showOpenDialog(frame);
       if (result == JFileChooser.APPROVE_OPTION) { 
           File selectedFolder = fileChooser.getSelectedFile();
          folder.setText(selectedFolder.toString());
       }
    }//GEN-LAST:event_folderbActionPerformed

    private void optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionActionPerformed
        // TODO add your handling code here:            
           if(option.isSelected()){
           option.setBackground(Color.DARK_GRAY);
           option.setText("Unit");
           folderb.setEnabled(false);
           units.setEnabled(true);
            STOP.setEnabled(true);
            scan.setEnabled(true);
            deletevirus.setEnabled(true);
            jSpinner1.setEnabled(true);
            label_unit.setForeground(Color.BLUE);
           }else{
            option.setBackground(Color.GRAY);
            option.setText("Folder");
            folderb.setEnabled(true);
            units.setEnabled(false);
            label_unit.setForeground(null);
            STOP.setEnabled(true);
            scan.setEnabled(true);
            deletevirus.setEnabled(true);
            jSpinner1.setEnabled(true);
        } 
        
    }//GEN-LAST:event_optionActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        comando = ".\\clamscan.exe ";
        sc.ejecutarComando(comando,"--version "+jSpinner1.getValue(), jTextPane1, jProgressBar1);
        comando = ".\\clamscan.exe -r ";
    }//GEN-LAST:event_jMenuItem6ActionPerformed
    private void llenarcombox(){
       // Obtener las raíces del sistema de archivos 
       File[] unidades = File.listRoots();
       //Limpiar Items
       units.removeAllItems();
       //Añadir las unidades
       for (File unidad : unidades){
           units.addItem(unidad.getAbsolutePath()); 
       }
    }
        // Método personalizado para añadir texto al final del JTextPane 
    private static void appendToPane(JTextPane textPane, String texto, Color color)
    { StyledDocument doc = textPane.getStyledDocument(); 
    Style style = textPane.addStyle("Estilo", null); 
    if (color != null) { 
        StyleConstants.setForeground(style, color); 
    } 
    try { 
        doc.insertString(doc.getLength(), texto, style); 
    } catch (BadLocationException e) {
        e.printStackTrace(); } 
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the FlatLaf Dark look and feel */
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
            java.util.logging.Logger.getLogger(PJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         try { UIManager.setLookAndFeel(new FlatDarkLaf());
         } catch (UnsupportedLookAndFeelException e) { 
             e.printStackTrace(); 
         }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton STOP;
    private javax.swing.JCheckBox deletevirus;
    private javax.swing.JTextField folder;
    private javax.swing.JButton folderb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel label_unit;
    private javax.swing.JToggleButton option;
    private javax.swing.JLabel option_label;
    private javax.swing.JButton scan;
    private javax.swing.JComboBox<String> units;
    // End of variables declaration//GEN-END:variables
}
