
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CadastroAutor extends javax.swing.JFrame {

    BeanDiversos dv = new BeanDiversos();

    /**
     * Creates new form Autor
     */
    public CadastroAutor() {
        dv.passaCamposComEnter(this);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        Sair = new javax.swing.JButton();
        Apagar = new javax.swing.JButton();
        Gravar = new javax.swing.JButton();
        Novo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Autor");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nome");

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });

        Apagar.setText("Apagar");
        Apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApagarActionPerformed(evt);
            }
        });

        Gravar.setText("Gravar");
        Gravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GravarActionPerformed(evt);
            }
        });

        Novo.setText("Novo");
        Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Novo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Gravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Sair)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sair)
                    .addComponent(Apagar)
                    .addComponent(Gravar)
                    .addComponent(Novo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusGained
        codigo.setText("");
        nome.setText("");
    }//GEN-LAST:event_codigoFocusGained

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        try {
            dv.Conexao();
            if (codigo.getText().equals("")) {
                codigo.setText("NOVO");
            } else {
                dv.sttm = dv.con.prepareStatement("Select nome from autor where id_autor = ?");
                dv.sttm.setString(1, codigo.getText());
                ResultSet rs = dv.sttm.executeQuery();
                if (rs.next()) {
                    nome.setText(dv.RetString(rs.getString("nome"), "C"));

                } else {
                    codigo.setText("NOVO");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                dv.con.close();
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_codigoFocusLost

    private void NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoActionPerformed
        codigo.grabFocus();
        nome.grabFocus();
    }//GEN-LAST:event_NovoActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        this.dispose();
    }//GEN-LAST:event_SairActionPerformed

    private void GravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GravarActionPerformed
        String msg = "";
        try {
            dv.Conexao();
            if (codigo.getText().equals("NOVO")) {
                dv.sttm = dv.con.prepareStatement("Insert into autor(nome) values(?)");
                dv.sttm.setString(1, nome.getText());
                msg = "Dados cadastrado com sucesso...";
            } else {
                dv.sttm = dv.con.prepareStatement("Update autor set nome = ? Where id_autor = ?");
                dv.sttm.setString(1, nome.getText());
                dv.sttm.setInt(2, Integer.parseInt(codigo.getText()));
                msg = "Dados alterado com sucesso...";
            }
            dv.sttm.executeUpdate();
            dv.con.commit();
            JOptionPane.showMessageDialog(null, msg);
            codigo.grabFocus();
        } catch (Exception e) {
            try {
                dv.con.rollback();
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro no cadastro de uauário...");
            } catch (SQLException ex) {
            }
        } finally {
            try {
                dv.con.close();
            } catch (Exception ex) {
            }
        }
    }

    /*
    }//GEN-LAST:event_GravarActionPerformed
*/
    private void ApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApagarActionPerformed
int resp = 0;        
        try {             
            dv.Conexao();             
            resp = JOptionPane.showConfirmDialog(null, "Confirma Exclusão desse autor ?"); 
            if (resp == 0) {   
                dv.sttm = dv.con.prepareStatement("Delete from autor Where id_autor = ?");     
                dv.sttm.setInt(1, Integer.parseInt(codigo.getText()));   
                dv.sttm.executeUpdate();              
                dv.con.commit();           
                JOptionPane.showMessageDialog(null, "autor excluido com sucesso...");     
            }          
            codigo.grabFocus();   
        } catch (Exception e) {   
            try {                
                dv.con.rollback();      
                e.printStackTrace();            
                JOptionPane.showMessageDialog(null, "Erro na exclusão do autor...");           
            } catch (SQLException ex) {     
            }         
        } finally {          
            try {                
                dv.con.close();         
            } catch (Exception ex) {    
            }         
        }


    }//GEN-LAST:event_ApagarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apagar;
    private javax.swing.JButton Gravar;
    private javax.swing.JButton Novo;
    private javax.swing.JButton Sair;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
