
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author MECLEVAA
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("beolvasás");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2.feladat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jButton3.setText("3.feladat");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 482, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addGap(27, 27, 27)
                .addComponent(jButton3)
                .addContainerGap(274, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        neve();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        neve();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        neve();

    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void neve() {
        ArrayList<naplok> lista = new ArrayList<>();

        try {
            File adat = new File("naplo.txt");
            Scanner fileinput = new Scanner(adat);
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String tomb[] = data.split(" ");
                lista.add(new naplok(tomb[0], tomb[1], tomb[2]));

            }
            fileinput.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        System.out.println(lista.size());
        ArrayList<napok> naplista = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).tegvagykeresztnev.contains("#")) {
                naplista.add(new napok(lista.get(i).getTegvagykeresztnev(), Integer.parseInt(lista.get(i).getHonapvagyvezeteknev()), Integer.parseInt(lista.get(i).getNapvagykeresztnev())));
            }

        }

        ArrayList<hianyzok> nevlista = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (!(lista.get(i).tegvagykeresztnev.contains("#"))) {
                nevlista.add(new hianyzok(lista.get(i).tegvagykeresztnev, lista.get(i).honapvagyvezeteknev, lista.get(i).napvagykeresztnev));
            }

        }

        //2.feladat
        String kiir = "A naplóban " + nevlista.size() + " bejegyzés van";
        jLabel1.setText(kiir);

        //3.feladat
        int igazoltdb = 0;
        int igazolatlandb = 0;

        for (int i = 0; i < nevlista.size(); i++) {
            if (nevlista.get(i).azonosito.charAt(0) == 'I') {
                igazolatlandb++;
            }

            if (nevlista.get(i).azonosito.charAt(1) == 'I') {
                igazolatlandb++;
            }
            if (nevlista.get(i).azonosito.charAt(2) == 'I') {
                igazolatlandb++;
            }
            if (nevlista.get(i).azonosito.charAt(3) == 'I') {
                igazolatlandb++;
            }
            if (nevlista.get(i).azonosito.charAt(4) == 'I') {
                igazolatlandb++;
            }
            if (nevlista.get(i).azonosito.charAt(5) == 'I') {
                igazolatlandb++;
            }
            if (nevlista.get(i).azonosito.charAt(6) == 'I') {
                igazolatlandb++;
            }
        }
        System.out.println(igazolatlandb);

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
