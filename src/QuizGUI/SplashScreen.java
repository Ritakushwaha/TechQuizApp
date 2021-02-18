                   
package QuizGUI;

import java.util.Random;
import javax.swing.JOptionPane;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        jProgressBar1.setStringPainted(true);
        SplashThread sp=new SplashThread();
        sp.start();
    }
    
    class SplashThread extends Thread
    {
        public void run()
        {
        int count=1;
        Random r=new Random();
        while(jProgressBar1.getValue()<jProgressBar1.getMaximum())
        {
            try
            {
                jProgressBar1.setValue(count);
                Thread.sleep(1200);
                count=count+r.nextInt(100);
            } 
            catch (InterruptedException ex) 
            {
                 JOptionPane.showMessageDialog(null, "Exception In Thread:"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
            }
        }
        dispose();
        LoginFrame loginFrame=new LoginFrame();
        loginFrame.setVisible(true);    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TechQuizApp (TQA)");
        setResizable(false);

        jProgressBar1.setBackground(new java.awt.Color(255, 51, 255));
        jProgressBar1.setForeground(new java.awt.Color(0, 0, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon("I:\\NetBeansProjects\\TechQuizApp\\images\\onlinelogo.jpg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
  
}
