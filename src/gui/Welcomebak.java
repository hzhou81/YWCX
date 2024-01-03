package gui;

import java.awt.*;

import javax.swing.*;

import common.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ImgButton;
import control.ImageButton;
import control.ImagePanel;
import java.lang.String;
import com.borland.jbcl.layout.XYLayout;
import com.borland.jbcl.layout.*;
import java.net.URL;

/**
 * <p>标题: 欢迎界面</p>
 *
 * <p>描述: 显示一副画面，最好有动态的帮助</p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 王嘉彦,叶熬东,孙汇洲
 * @版本 1.0
 */
public class Welcomebak extends SucemFrame {
    JPanel contentPane;
    //JButton jButton1 = new JButton();
    ImageButton jButton_KSSY;     //开始使用
   // ImagePanel jPanel1;           //背景图片
    JLabel jLabel1 = new JLabel();

    BorderLayout borderLayout1 = new BorderLayout();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel6 = new JLabel();
    XYLayout xYLayout1 = new XYLayout();
    ImagePanel BackgroundPanel = new ImagePanel();

    public Welcomebak() {
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(xYLayout1);
        this.getContentPane().setBackground(Color.white);
        this.setForeground(Color.white);
        setTitle("欢迎界面");

        BackgroundPanel=new ImagePanel("background.jpg");
        jButton_KSSY = new ImageButton("Run.jpg",140,120);
        jButton_KSSY.repaint();
        jButton_KSSY.setBackground(Color.white);
        jLabel1.setFont(new java.awt.Font("宋体", Font.BOLD, 50));
        jLabel1.setText("欢迎使用客户服务系统");
        jLabel2.setFont(new java.awt.Font("宋体", Font.BOLD, 25));
        //jLabel2.setToolTipText("发");
        jLabel2.setText("使用说明:");
        contentPane.setBackground(UIManager.getColor("Button.background"));
        jLabel3.setFont(new java.awt.Font("宋体", Font.BOLD, 20));
        jLabel3.setText("1)本系统仅供客户查询业务操作时间,不做其他用途.");
        jLabel4.setFont(new java.awt.Font("宋体", Font.BOLD, 20));
        jLabel4.setText("2)查询结果仅供用户参考,公司保留最终解释权.");
        jLabel5.setFont(new java.awt.Font("宋体", Font.BOLD, 20));
        jLabel5.setToolTipText("");
        jLabel5.setText("3)为了保护客户信息,每个界面将会在不操作后的一");
        jLabel6.setFont(new java.awt.Font("宋体", Font.BOLD, 20));
        jLabel6.setText("  定时间内自动退出.");
        BackgroundPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.getContentPane().add(jButton_KSSY, null);
        //ImageIcon imgIcon = new ImageIcon("背景.jpg");
        //jPanel1.setLayout(borderLayout1);
        //jPanel1.imageUpdate("背景.jpg");
        // jButton_KSSY.addActionListener(new Welcome_jButton_KSSY_actionAdapter(this));
        contentPane.add(jButton_KSSY, new XYConstraints(717, 488, 123, 112));
        BackgroundPanel.add(jLabel6);
        BackgroundPanel.add(jLabel5);
        BackgroundPanel.add(jLabel4);
        BackgroundPanel.add(jLabel3);
        BackgroundPanel.add(jLabel2);
        BackgroundPanel.add(jLabel1, java.awt.BorderLayout.CENTER);
        contentPane.add(BackgroundPanel, new XYConstraints(0, 0, 1024, 768));
    }
    public static void main(String[] args){
        Welcome frame=new Welcome();
        frame.setVisible(true);
    }

    public void jButton_KSSY_actionPerformed(ActionEvent e) {
        VehType vehType=new VehType(Param.getTypeTime());
        vehType.setVisible(true);
    }
}


class Welcome_jButton_KSSY_actionAdapter implements ActionListener {
    private Welcome adaptee;
    Welcome_jButton_KSSY_actionAdapter(Welcome adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        // adaptee.jButton_KSSY_actionPerformed(e);
    }
}
