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
public class demoJRadio extends JFrame{
    private JLabel lbNum1, lbNum2, lpOp, lbResult;
    private JTextField txtNum1, txtNum2, txtresult;
    private JButton btTinh, btNhapLai;
    private JRadioButton rdCong, rdTru, rdNhan,rdChia;
    
    public demoJRadio(String title) {
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
        p.add(pPheptinh);
        
        //add dòng 4
        p.add(lbResult = new JLabel("Result"));
        p.add(txtresult = new JTextField(10));
        txtresult.setEditable(false);
        
       //add dong 5
        p.add(btTinh = new JButton("Tính"));
        p.add(btNhapLai = new JButton("Nhập lại"));
        add(p);
         
        ButtonGroup btgPheptinh = new ButtonGroup();
        btgPheptinh.add(rdCong);
        btgPheptinh.add(rdTru);
        btgPheptinh.add(rdNhan);
        btgPheptinh.add(rdChia);
       
        
        btTinh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq=0;
                            
                    if(rdCong.isSelected()){
                        kq = x+y;
                    }else if(rdTru.isSelected()){
                        kq = x - y;
                    }else if(rdNhan.isSelected()){
                        kq = x * y;
                    }else {
                        kq = x/y;
                    } 
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
        demoJRadio frm = new demoJRadio("Simple Calculator");
        frm.setVisible(true);

    }
}
