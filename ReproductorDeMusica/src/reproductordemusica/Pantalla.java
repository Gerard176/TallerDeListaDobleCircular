package reproductordemusica;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Pantalla extends javax.swing.JFrame {

    Operaciones op = new Operaciones();
    Scanner sc;
    public int valor;
    Nodo nodoReferencia;

    public Pantalla() {
        initComponents();
        inicializarCanciones();
        cargarCanciones();
        nodoReferencia = op.cabeza;
        CancionReproduciendose.setText(op.cabeza.getCancion());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Pausar = new javax.swing.JToggleButton();
        CancionReproduciendose = new javax.swing.JLabel();
        siguienteCancion = new javax.swing.JButton();
        CancionAnterior = new javax.swing.JButton();
        ListaDeCanciones = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Reproductor de musica");

        Pausar.setText(">");

        CancionReproduciendose.setText("Cualquier");

        siguienteCancion.setText(">>");
        siguienteCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteCancionActionPerformed(evt);
            }
        });

        CancionAnterior.setText("<<");
        CancionAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancionAnteriorActionPerformed(evt);
            }
        });

        ListaDeCanciones.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(CancionReproduciendose, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(ListaDeCanciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(CancionAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(Pausar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(siguienteCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(26, 26, 26)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ListaDeCanciones, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(CancionReproduciendose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pausar)
                    .addComponent(siguienteCancion)
                    .addComponent(CancionAnterior))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancionAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancionAnteriorActionPerformed
        if (validarPosicion(nodoReferencia.getAnterior())) {
        CancionReproduciendose.setText(nodoReferencia.getCancion());
            nodoReferencia = nodoReferencia.getAnterior();
        }else{
        CancionReproduciendose.setText("no hay mas canciones hacia atras");
            
        }
    }//GEN-LAST:event_CancionAnteriorActionPerformed

    private void siguienteCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteCancionActionPerformed
        if (validarPosicion(nodoReferencia.getSiguente())) {
        CancionReproduciendose.setText(nodoReferencia.getCancion());
            nodoReferencia = nodoReferencia.getSiguente();
        }else{
        CancionReproduciendose.setText("no hay mas canciones hacia adelante");
            
        }
    }//GEN-LAST:event_siguienteCancionActionPerformed

    private void inicializarCanciones() {
        try {
            File jugadores = new File("src/reproductordemusica/Canciones.txt");
            sc = new Scanner(jugadores);
            while (sc.hasNext()) {
                op.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error " + e);
        } finally {
            sc.close();
        }
    }

    private void cargarCanciones() {

        Nodo cola = op.cabeza;

        String canciones = "<html>";
        if (cola == null) {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");

        } else {
            do {
                canciones += cola.getCancion() + "<p>";
                cola = cola.getSiguente();

            } while (cola != null);

        }
        canciones += "<html>";
        this.ListaDeCanciones.setText(canciones);
        System.out.println("--------------------------------");

    }

    public boolean validarPosicion(Nodo tem) {
        return (tem == null) ? false : true;
    }

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
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancionAnterior;
    private javax.swing.JLabel CancionReproduciendose;
    private javax.swing.JLabel ListaDeCanciones;
    private javax.swing.JToggleButton Pausar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton siguienteCancion;
    // End of variables declaration//GEN-END:variables
}
