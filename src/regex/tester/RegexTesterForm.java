/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex.tester;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 *
 * @author RIDDHI DUTTA
 */
public class RegexTesterForm extends javax.swing.JFrame 
{
    /**
     * Creates new form RegexTesterForm
     */
   
    public void checkPhoneNumber()
    {
        /* Actual Regex - (((((\+?\d{2})?[\s\-]?((\d{3})|(\(\d{3}\)))[\s\-]?))?((\d{5}[\s\-]?\d{5})|(\d{4}[\s\-]?\d{4})))\s*,\s*)+ */
        String pattern = "(((((\\+?\\d{2})?[\\s\\-]?((\\d{3})|(\\(\\d{3}\\)))[\\s\\-]?))?((\\d{5}[\\s\\-]?\\d{5})|(\\d{4}[\\s\\-]?\\d{4})))\\s*,\\s*)+";
        Pattern pat = Pattern.compile(pattern);
        Matcher mat = pat.matcher(tfPhNo.getText()+",");
        if(mat.matches())
        {
            lblPhNo.setText("Valid Phone Number");
            lblPhNo.setForeground(Color.green.darker());
            lblPhNo.setBackground(Color.green.brighter().brighter());
        }
        else
        {
            lblPhNo.setText("Invalid Phone Number");
            lblPhNo.setForeground(Color.red.darker());
            lblPhNo.setBackground(Color.red.brighter().brighter());
        }
    }
    
    public void showPasswordStrength()
    {
        String password = tfPassword.getText();
        if(password.isEmpty())
        {
            lblPassStrength.setText("Empty");
            lblPassStrength.setForeground(Color.red);
            lblPassStrength.setBackground(new Color(255, 204, 204));
            return;
        }
        if(password.length()<8)
        {
            lblPassStrength.setText("Weak");
            lblPassStrength.setForeground(Color.PINK.darker().darker());
            lblPassStrength.setBackground(new Color(235, 153, 255));
            return;
        }
        String[] comment = {"Feeble","Good","Strong"};
        Color[] fcolor = {Color.BLUE,new Color(35,144,35), Color.green.darker() };
        Color[] bcolor = {new Color(179, 209, 255),new Color(173, 235, 173), new Color(255, 255, 153).brighter()};
        int length = password.length();
        String patstr;
        Pattern pat;
        Matcher mat;
        int i;
        for(i=0;i<3;i++)
        {
           if(i==0)
           {
               /*-------  Combination of upper and lower case --------*/
               patstr = "[A-Z]+";
               String patstr1 = "[a-z]+";
               pat = Pattern.compile(patstr);
               Pattern pat1 = Pattern.compile(patstr1);
               mat = pat.matcher(password);
               Matcher mat1= pat1.matcher(password);
               if(!mat.find() || !mat1.find())
                   break;
           }
           else if(i==1)
           {
               patstr = "\\d+";
               pat = Pattern.compile(patstr);
               mat = pat.matcher(password);
               if(!mat.find())
                   break;
           }
           else
           {
               patstr = "[^0-9A-Za-z]";
               pat = Pattern.compile(patstr);
               mat = pat.matcher(password);
               if(!mat.find())
                   break;
           }
        }
        if(i==0)
            return;
        lblPassStrength.setText(comment[i-1]);
        lblPassStrength.setForeground(fcolor[i-1]);
        lblPassStrength.setBackground(bcolor[i-1]);
    }
    public RegexTesterForm()
    {
        initComponents();
        
        lblPassStrength.setForeground(Color.red);
        lblPassStrength.setBackground(new Color(255, 204, 204));
        lblPhNo.setForeground(Color.red.darker());
        lblPhNo.setBackground(Color.red.brighter().brighter());
        
        Document doc = tfPassword.getDocument();
        doc.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                showPasswordStrength();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                showPasswordStrength();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                showPasswordStrength();
            }
        }
                
                
        );
        
        doc = tfPhNo.getDocument();
        doc.addDocumentListener(new DocumentListener()
                {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkPhoneNumber();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkPhoneNumber();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkPhoneNumber();
            }
                });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfPassword = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfPhNo = new javax.swing.JTextField();
        lblPassStrength = new javax.swing.JLabel();
        lblPhNo = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("TESTER");

        jLabel4.setText("Password");

        jLabel6.setText("Phone Number");

        lblPassStrength.setBackground(new java.awt.Color(204, 0, 0));
        lblPassStrength.setForeground(new java.awt.Color(255, 255, 255));
        lblPassStrength.setText("Empty!");
        lblPassStrength.setOpaque(true);

        lblPhNo.setText("Empty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(69, 69, 69)
                        .addComponent(tfPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(lblPhNo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(95, 95, 95)
                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(lblPassStrength)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassStrength))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfPhNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhNo))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(RegexTesterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegexTesterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegexTesterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegexTesterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegexTesterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblPassStrength;
    private javax.swing.JLabel lblPhNo;
    private javax.swing.JTextField tfPassword;
    private javax.swing.JTextField tfPhNo;
    // End of variables declaration//GEN-END:variables
}
