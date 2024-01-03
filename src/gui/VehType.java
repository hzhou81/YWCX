package gui;

import java.awt.*;
import control.ImageButton;
import common.*;
import javax.swing.JButton;
import javax.swing.*;
import control.ImageButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.ImageButton;

/**
 * <p>标题: 输入号牌种类，一共24种</p>
 *
 * <p>描述: </p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 王嘉彦,叶傲冬,孙汇洲
 * @版本 1.0
 */
public class VehType extends SucemFrameWithTimer {
    JLabel HPZLL = new JLabel();
    ImageButton jButton_DXQC=new ImageButton();    //大型汽车
    ImageButton jButton_XXQC=new ImageButton();    //小型汽车
    ImageButton jButton_LGQC=new ImageButton();    //领馆汽车
    ImageButton jButton_WJQC=new ImageButton();    //外籍汽车
    ImageButton jButton_ESLMTC=new ImageButton();  //两,三轮摩托车
    ImageButton jButton_QBMTC=new ImageButton();   //轻便摩托车
    ImageButton jButton_LGMTC=new ImageButton();   //领馆摩托车
    ImageButton jButton_WJMTC=new ImageButton();   //外籍摩托车
    ImageButton jButton_NYYSC=new ImageButton();   //农用运输车
    ImageButton jButton_TLJ=new ImageButton();     //拖拉机
    ImageButton jButton_GC=new ImageButton();      //挂车
    ImageButton jButton_JLQC=new ImageButton();    //教练汽车
    ImageButton jButton_JLMTC=new ImageButton();   //教练摩托车
    ImageButton jButton_JYQC=new ImageButton();    //警用汽车
    ImageButton jButton_JYMTC=new ImageButton();   //警用摩托车


    public VehType(int WaitTime) {
        super(WaitTime);
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(null);
        this.setTitle("输入车辆类型");
        HPZLL.setFont(new java.awt.Font("Dialog", Font.BOLD, 60));
        HPZLL.setText("请选择要查询的汽车种类：");
        HPZLL.setBounds(new Rectangle(100, 54, 831, 118));
        this.getContentPane().add(HPZLL);
        // 定义按钮
        jButton_DXQC = new ImageButton("大型汽车.jpg",140,120);
        jButton_DXQC.setBounds(new Rectangle(35, 220, 158, 118));
        jButton_XXQC = new ImageButton("小型汽车.jpg",140,120);
        jButton_XXQC.setBounds(new Rectangle(235, 220, 153, 113));
        jButton_LGQC = new ImageButton("领馆汽车.jpg",140,120);
        jButton_LGQC.setBounds(new Rectangle(435, 220, 155, 115));
        jButton_WJQC = new ImageButton("外籍汽车.jpg",140,120);
        jButton_WJQC.setBounds(new Rectangle(635, 220, 155, 115));
        jButton_ESLMTC = new ImageButton("两三轮摩托车.jpg",140,120);
        jButton_ESLMTC.setBounds(new Rectangle(835, 220, 155, 115));
        jButton_QBMTC = new ImageButton("轻便摩托车.jpg",140,120);
        jButton_QBMTC.setBounds(new Rectangle(35, 380, 155, 115));
        jButton_LGMTC = new ImageButton("领馆摩托车.jpg",140,120);
        jButton_LGMTC.setBounds(new Rectangle(235, 380, 153, 113));
        jButton_WJMTC = new ImageButton("外籍摩托车.jpg",140,120);
        jButton_WJMTC.setBounds(new Rectangle(435, 380, 150, 110));
        jButton_NYYSC = new ImageButton("农用运输车.jpg",140,120);
        jButton_NYYSC.setBounds(new Rectangle(635, 380, 155, 115));
        jButton_TLJ = new ImageButton("拖拉机.jpg",140,120);
        jButton_TLJ.setBounds(new Rectangle(835, 380, 155, 115));
        jButton_GC = new ImageButton("挂车.jpg",140,120);
        jButton_GC.setBounds(new Rectangle(35, 520, 155, 115));
        jButton_JLQC = new ImageButton("教练汽车.jpg",140,120);
        jButton_JLQC.setBounds(new Rectangle(235, 520, 153, 113));
        jButton_JLMTC = new ImageButton("教练摩托车.jpg",140,120);
        jButton_JLMTC.setBounds(new Rectangle(435, 520, 150, 110));
        jButton_JYQC = new ImageButton("警用汽车.jpg",140,120);
        jButton_JYQC.setBounds(new Rectangle(635, 520, 155, 110));
        jButton_JYMTC = new ImageButton("警用摩托.jpg",140,120);
        jButton_JYMTC.setBounds(new Rectangle(835, 520, 155, 115));
        // 添加Button到界面
        this.getContentPane().add(jButton_XXQC, null);
        this.getContentPane().add(jButton_LGQC, null);
        this.getContentPane().add(jButton_WJQC, null);
        this.getContentPane().add(jButton_ESLMTC, null);
        this.getContentPane().add(jButton_QBMTC, null);
        this.getContentPane().add(jButton_LGMTC, null);
        this.getContentPane().add(jButton_WJMTC, null);
        this.getContentPane().add(jButton_NYYSC, null);
        this.getContentPane().add(jButton_TLJ, null);
        this.getContentPane().add(jButton_GC, null);
        this.getContentPane().add(jButton_JLQC, null);
        this.getContentPane().add(jButton_JLMTC, null);
        this.getContentPane().add(jButton_JYQC, null);
        this.getContentPane().add(jButton_DXQC, null);
        this.getContentPane().add(jButton_JYMTC, null);
        // 事件
        jButton_DXQC.addActionListener(new VehType_jButton_DXQC_actionAdapter(this));
        jButton_QBMTC.addActionListener(new VehType_jButton_QBMTC_actionAdapter(this));
        jButton_XXQC.addActionListener(new VehType_jButton_XXQC_actionAdapter(this));
        jButton_LGQC.addActionListener(new VehType_jButton_LGQC_actionAdapter(this));
        jButton_WJQC.addActionListener(new VehType_jButton_WJQC_actionAdapter(this));
        jButton_ESLMTC.addActionListener(new VehType_jButton_ESLMTC_actionAdapter(this));
        jButton_LGMTC.addActionListener(new VehType_jButton_LGMTC_actionAdapter(this));
        jButton_WJMTC.addActionListener(new VehType_jButton_WJMTC_actionAdapter(this));
        jButton_NYYSC.addActionListener(new VehType_jButton_NYYSC_actionAdapter(this));
        jButton_TLJ.addActionListener(new VehType_jButton_TLJ_actionAdapter(this));
        jButton_GC.addActionListener(new VehType_jButton_GC_actionAdapter(this));
        jButton_JLQC.addActionListener(new VehType_jButton_JLQC_actionAdapter(this));
        jButton_JLMTC.addActionListener(new VehType_jButton_JLMTC_actionAdapter(this));
        jButton_JYQC.addActionListener(new VehType_jButton_JYQC_actionAdapter(this));
        jButton_JYMTC.addActionListener(new VehType_jButton_JYMTC_actionAdapter(this));
    }

    public void jButton_A_actionPerformed(ActionEvent e) {
        String a;
        // a=Param.getInstance().getVT();
       // Param.getInstance().getVT();
    }

    public void jButton1_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        VehNumber vehNumber = new VehNumber(Param.getNumTime());
        vehNumber.setVisible(true);
        this.dispose();
    }

    public void jButton_DXQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("01");
        VehNumber vehnumber=new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_QBMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("08");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_XXQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("02");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_LGQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("04");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_WJQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("06");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_ESLMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("07");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_LGMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("10");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_WJMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("12");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_NYYSC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("13");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_TLJ_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("14");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_GC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("15");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_JLQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("16");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_JLMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("17");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_JYQC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("23");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_JYMTC_actionPerformed(ActionEvent e) {
        Param.getInstance().setHPZL("24");
        VehNumber vehnumber = new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }
}


class VehType_jButton_JYMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_JYMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_JYMTC_actionPerformed(e);
    }
}


class VehType_jButton_JYQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_JYQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_JYQC_actionPerformed(e);
    }
}


class VehType_jButton_JLMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_JLMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_JLMTC_actionPerformed(e);
    }
}


class VehType_jButton_JLQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_JLQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_JLQC_actionPerformed(e);
    }
}


class VehType_jButton_GC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_GC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_GC_actionPerformed(e);
    }
}


class VehType_jButton_TLJ_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_TLJ_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_TLJ_actionPerformed(e);
    }
}


class VehType_jButton_NYYSC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_NYYSC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_NYYSC_actionPerformed(e);
    }
}


class VehType_jButton_WJMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_WJMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_WJMTC_actionPerformed(e);
    }
}


class VehType_jButton_LGMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_LGMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_LGMTC_actionPerformed(e);
    }
}


class VehType_jButton_ESLMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_ESLMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_ESLMTC_actionPerformed(e);
    }
}


class VehType_jButton_WJQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_WJQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_WJQC_actionPerformed(e);
    }
}


class VehType_jButton_LGQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_LGQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_LGQC_actionPerformed(e);
    }
}


class VehType_jButton_XXQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_XXQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_XXQC_actionPerformed(e);
    }
}


class VehType_jButton_QBMTC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_QBMTC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_QBMTC_actionPerformed(e);
    }
}


class VehType_jButton_DXQC_actionAdapter implements ActionListener {
    private VehType adaptee;
    VehType_jButton_DXQC_actionAdapter(VehType adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_DXQC_actionPerformed(e);
    }
}



