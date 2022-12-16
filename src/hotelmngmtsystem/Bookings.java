/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotelmngmtsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ardpe
 */
public class Bookings extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    Statement st,st1 = null;
    ResultSet rs,rs1 = null;
    
    public Bookings() {
        initComponents();
        GetRooms();
        GetCustomers();  
        ShowBooks();
        CostTb.setEditable(false);
    }
    int Bid =1;
    
    private void UpdateRoom(){
    

            try {
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
                PreparedStatement save = con.prepareStatement("update RoomTbl set RStatus = ? where RNum = ?");
                
                save.setInt(2, Integer.valueOf(RoomCb.getSelectedItem().toString())); // 5 because in update statement RNum is assigned the 5th question mark
                save.setString(1, "Booked" );
                
                int row = save.executeUpdate();

                con.close();

            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    private void UpdateFree(){
    

            try {
                
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
                PreparedStatement save = con.prepareStatement("update RoomTbl set RStatus = ? where RNum = ?");
                
                save.setInt(2, R); // 5 because in update statement RNum is assigned the 5th question mark
                save.setString(1, "Free" );
                
                int row = save.executeUpdate();

                con.close();

            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    
    private void CountBooks(){
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("select Max(BNum) from BookingTbl");
            
            rs.next();
            Bid = rs.getInt(1)+1;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private void ShowBooks(){
    
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
            st = con.createStatement();
            rs = st.executeQuery("select * from Bookingtbl");
            BList.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            
        }
    }
    int Cost;
    private void GetCost(){
    
         try {
            
            st1 = con.createStatement();
            rs1 = st1.executeQuery("select Price from RoomTbl where RNum = " +RoomCb.getSelectedItem().toString());
            
            rs1.next();
            
            Cost = rs1.getInt(1);
            
           
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    private void GetCustomers(){
    
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
            st = con.createStatement();
            rs = st.executeQuery("select * from Customer");
            
            while(rs.next()){
            
                int C = rs.getInt("CustNum");
                CustomerCb.addItem(C); //if type error then remove type parameter from the properties of the RoomCb in design in event tab
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Rooms.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void GetRooms(){
    
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
            st = con.createStatement();
            rs = st.executeQuery("select * from RoomTbl  where RStatus = 'Free'");
            
            while(rs.next()){
            
                int R = rs.getInt("RNum");
                RoomCb.addItem(R); 
            }
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        RoomsBtn = new javax.swing.JLabel();
        CusBtn = new javax.swing.JLabel();
        BookBtn = new javax.swing.JLabel();
        DashBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DurationTb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CustomerCb = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BList = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        CostTb = new javax.swing.JTextField();
        RoomCb = new javax.swing.JComboBox();
        BDate = new com.toedter.calendar.JDateChooser();
        FetchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        RoomsBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        RoomsBtn.setForeground(new java.awt.Color(255, 255, 255));
        RoomsBtn.setText("Rooms");
        RoomsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RoomsBtnMouseClicked(evt);
            }
        });

        CusBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        CusBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusBtn.setText("Customers");
        CusBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CusBtnMouseClicked(evt);
            }
        });

        BookBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        BookBtn.setForeground(new java.awt.Color(255, 255, 255));
        BookBtn.setText("Bookings");

        DashBtn.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 16)); // NOI18N
        DashBtn.setForeground(new java.awt.Color(255, 255, 255));
        DashBtn.setText("Dashboard");
        DashBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashBtnMouseClicked(evt);
            }
        });

        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Log Out");
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomsBtn)
                            .addComponent(CusBtn)
                            .addComponent(BookBtn)
                            .addComponent(DashBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logoutBtn)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(RoomsBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CusBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BookBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DashBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Room");

        DurationTb.setBackground(new java.awt.Color(255, 255, 255));
        DurationTb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Duration in Days");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Customer");

        CustomerCb.setBackground(new java.awt.Color(255, 255, 255));
        CustomerCb.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Booked Date");

        AddBtn.setBackground(new java.awt.Color(0, 102, 102));
        AddBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        CancelBtn.setBackground(new java.awt.Color(0, 102, 102));
        CancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Manage Bookings");

        BList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Room", "Customer", "Date", "Duration", "Cost"
            }
        ));
        BList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BList);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cost");

        CostTb.setBackground(new java.awt.Color(255, 255, 255));
        CostTb.setForeground(new java.awt.Color(0, 0, 0));

        RoomCb.setBackground(new java.awt.Color(255, 255, 255));
        RoomCb.setForeground(new java.awt.Color(0, 0, 0));
        RoomCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomCbActionPerformed(evt);
            }
        });

        FetchBtn.setBackground(new java.awt.Color(0, 102, 102));
        FetchBtn.setForeground(new java.awt.Color(255, 255, 255));
        FetchBtn.setText("Fetch");
        FetchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FetchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2)
                                        .addComponent(CustomerCb, 0, 145, Short.MAX_VALUE)
                                        .addComponent(DurationTb, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(FetchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(CostTb, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                        .addComponent(RoomCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RoomCb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CustomerCb, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DurationTb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FetchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(7, 7, 7)
                        .addComponent(CostTb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutBtnMouseClicked
int key=0;
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        if(key == 0){
            
            //print
            JOptionPane.showMessageDialog(this, "Select a Booking");
        }else{
        
            try {
               
//       no longer necessarry -->      Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
                PreparedStatement save = con.prepareStatement("delete from BookingTbl where BNum = ?");
                save.setInt(1, key);
                int row = save.executeUpdate();
                JOptionPane.showMessageDialog(this, "Booking Cancelled");
                con.close();
                ShowBooks();
                UpdateFree();
                RoomCb.removeAllItems();
                GetRooms();
                
                
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this, ex);
                
            }
        }
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void CusBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CusBtnMouseClicked
        new Customers().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CusBtnMouseClicked

    private void RoomsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RoomsBtnMouseClicked
        new Rooms().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RoomsBtnMouseClicked

    private void RoomCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomCbActionPerformed
        GetCost();
    }//GEN-LAST:event_RoomCbActionPerformed
    
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        
        if(RoomCb.getSelectedIndex() == -1 || CustomerCb.getSelectedIndex() == -1 || DurationTb.getText().isEmpty()){
            
            //print
            JOptionPane.showMessageDialog(this, "Missing Details");
        }else{
        
            try {
                
                String Bdate = BDate.getDate().toString().substring(0,11);
                CountBooks();
//       no longer necessarry -->      Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb", "root", "admin");
                PreparedStatement save = con.prepareStatement("insert into BookingTbl values(?, ?, ?, ?, ?, ?)");
                save.setInt(1, Bid);
                save.setInt(2, Integer.valueOf(RoomCb.getSelectedItem().toString()));
                save.setInt(3, Integer.valueOf(CustomerCb.getSelectedItem().toString()));
                save.setString(4, Bdate);
                save.setInt(5, Integer.valueOf(DurationTb.getText()));
                save.setInt(6, Integer.valueOf(CostTb.getText()));
                
                int row = save.executeUpdate();
                JOptionPane.showMessageDialog(this, "Booking Added");
                con.close();
                ShowBooks();
                UpdateRoom();
                RoomCb.removeAllItems();
                GetRooms();
               
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_AddBtnActionPerformed
    
    private void FetchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FetchBtnActionPerformed
        int Total = Cost* Integer.valueOf(DurationTb.getText().toString());
        CostTb.setText(""+ Total);
    }//GEN-LAST:event_FetchBtnActionPerformed
int R;
    private void BListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BListMouseClicked
       DefaultTableModel model = (DefaultTableModel)BList.getModel();
        int MyIndex = BList.getSelectedRow();
        key =  Integer.valueOf(model.getValueAt(MyIndex, 0).toString());
        R = Integer.valueOf(model.getValueAt(MyIndex, 1).toString());
        RoomCb.setSelectedItem(model.getValueAt(MyIndex, 1).toString());
        CustomerCb.setSelectedItem(model.getValueAt(MyIndex, 2).toString());
        DurationTb.setText(model.getValueAt(MyIndex, 4).toString());
        CostTb.setText(model.getValueAt(MyIndex, 5).toString());

    }//GEN-LAST:event_BListMouseClicked

    private void DashBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashBtnMouseClicked
        new Dashboard().setVisible(true);
         this.dispose();
    }//GEN-LAST:event_DashBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private com.toedter.calendar.JDateChooser BDate;
    private javax.swing.JTable BList;
    private javax.swing.JLabel BookBtn;
    private javax.swing.JButton CancelBtn;
    private javax.swing.JTextField CostTb;
    private javax.swing.JLabel CusBtn;
    private javax.swing.JComboBox CustomerCb;
    private javax.swing.JLabel DashBtn;
    private javax.swing.JTextField DurationTb;
    private javax.swing.JButton FetchBtn;
    private javax.swing.JComboBox RoomCb;
    private javax.swing.JLabel RoomsBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logoutBtn;
    // End of variables declaration//GEN-END:variables

}
