/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.SimpleBeanInfo;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class democompoxbox extends JFrame{
    private JLabel lbNum1, lbNum2, lpOp, lbResult;
    private JTextField txtNum1, txtNum2, txtresult;
    private JButton btTinh, btNhapLai;
    private JRadioButton rdCong, rdTru, rdNhan,rdChia;
    private JComboBox<String> cboPhepTinh;
    public democompoxbox(String title) {
        super(title);
        
        createGUI();
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,2,10,10));
        
        p.add(lbNum1 = new JLabel("Num1"));
        p.add(txtNum1 = new JTextField(10));
        
        //add dong2
        p.add(lbNum2 = new JLabel("Num2"));
        p.add(txtNum2 = new JTextField(10));
        
        JPanel pPheptinh = new JPanel();
        pPheptinh.add(rdCong = new JRadioButton("+"));
        pPheptinh.add(rdTru = new JRadioButton("-"));
        pPheptinh.add(rdNhan = new JRadioButton("*"));
        pPheptinh.add(rdChia = new JRadioButton("/"));
        
        //add dòng3
        p.add(lpOp = new JLabel("phép tính"));
        p.add(cboPhepTinh = new JComboBox<>());
        
        //add dòng 4
        p.add(lbResult = new JLabel("Result"));
        p.add(txtresult = new JTextField(10));
        txtresult.setEditable(false);
        
       //add dong 5
        p.add(btTinh = new JButton("Tính"));
        p.add(btNhapLai = new JButton("Nhập lại"));
        add(p);
         
        cboPhepTinh.addItem("Cộng");
        cboPhepTinh.addItem("Trừ");
        cboPhepTinh.addItem("Nhân");
        cboPhepTinh.addItem("Chia");
               
        
        btTinh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    int selectedIndex = cboPhepTinh.getSelectedIndex();
                            
                    if(selectedIndex==0){
                        kq = x + y;
                    }else if(selectedIndex==1){
                        kq = x - y;
                    }else if(selectedIndex==2){
                        kq = x * y;
                    }else {
                        kq = x/y;
                    } 
                    String op = (String)cboPhepTinh.getSelectedItem();
                    txtresult.setText(String.valueOf(kq));     
                } catch (Exception ex) {
                    JOptionPane.showConfirmDialog(null, "lỗi nhập liệu","Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } 
        });
        btNhapLai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNum1.setText("");
                txtNum2.setText("");
                txtresult.setText("");
                txtNum1.requestFocus();

            }
        });
    }
    public static void main(String[] args) {
        democompoxbox frm = new democompoxbox("Simple Calculator");
        frm.setVisible(true);

    }
}
