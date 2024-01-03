package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import common.*;
import control.DataGrid;
import control.ImageButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;

/**
 * <p>标题: 输入业务类别然后得到车辆查询结果</p>
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
public class VehWZ extends SucemFrameWithTimer {
    ImageButton jButton_SYB=new ImageButton();     //上一步
    ImageButton jButton_TC=new ImageButton();     //退出

    JScrollPane ResultPane = new JScrollPane();
    DataGrid ResultTable = new DataGrid();
    String yw="";
    XYLayout xYLayout1 = new XYLayout();
    JLabel jLabel1 = new JLabel();
    public VehWZ(int WaitTime) {
        super(WaitTime);
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        getContentPane().setLayout(xYLayout1);
        this.setTitle("车辆查询结果");
        jButton_SYB = new ImageButton("上一步.jpg",123,100);
        jButton_TC = new ImageButton("退出.jpg",123,100);
        ResultPane.setBorder(BorderFactory.createLineBorder(Color.black));
        jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 60));
        jLabel1.setText("该车的违章信息：");
        xYLayout1.setWidth(1058);
        xYLayout1.setHeight(525);
        this.getContentPane().add(ResultPane,
                                  new XYConstraints(20, 137, 970, 459));
        ResultPane.getViewport().add(ResultTable);
        this.getContentPane().add(jLabel1, new XYConstraints(20, 28, 652, -1));

        this.getContentPane().add(jButton_TC,
                                  new XYConstraints(840, 608, 140, 92));
        this.getContentPane().add(jButton_SYB,
                                  new XYConstraints(23, 609, 150, 100));
        jButton_SYB.addActionListener(new VehWZ_jButton_SYB_actionAdapter(this));
        jButton_TC.addActionListener(new VehWZ_jButton_TC_actionAdapter(this));
        // 显示违章信息
        String sql="select * from wz where hphm='"+Param.getInstance().getHPHM()+"' and hpzl='"+Param.getInstance().getHPZL()+"'";
        ResultSet res=Param.getInstance().getDB().executeQuery(sql);
        DataSet ds=new DataSet(res);
        Param.getInstance().getDB().colseStatement();
        ResultTable.setModel(ds);
    }

    public void jButton_SYB_actionPerformed(ActionEvent e) {
        VehNumber vehnumber =new VehNumber(Param.getNumTime());
        this.setVisible(false);
        vehnumber.setVisible(true);
        this.dispose();
    }

    public void jButton_TC_actionPerformed(ActionEvent e) {
        this.setVisible(false);
        this.dispose();
    }

    public void jButton_GH_actionPerformed(ActionEvent e) {
        yw="B";
        ResultTable.setModel(new DefaultTableModel(0,0));
        String sql="select czsm 流程情况,czsj 时间 from table(f_lccx('"+Param.getInstance().getHPZL()
                   +"','"+Param.getInstance().getHPHM()+"','"+   yw   +"'))";
        try {
            ResultSet res=Param.getInstance().getDB().executeQuery(sql);
            DataSet ds = new DataSet(res);
            ResultTable.setModel(ds);
        } catch (SQLException ex) {
        } catch (SucemException ex) {
        }
    }

    public void jButton_ZJ_actionPerformed(ActionEvent e) {
        yw="C";
        ResultTable.setModel(new DefaultTableModel(0,0));
        String sql="select czsm 流程情况,czsj 时间 from table(f_lccx('"+Param.getInstance().getHPZL()
                   +"','"+Param.getInstance().getHPHM()+"','"+   yw   +"'))";
        try {
            ResultSet res=Param.getInstance().getDB().executeQuery(sql);
            DataSet ds = new DataSet(res);
            ResultTable.setModel(ds);
        } catch (SQLException ex) {
        } catch (SucemException ex) {
        }

    }
}


class VehWZ_jButton_TC_actionAdapter implements ActionListener {
    private VehWZ adaptee;
    VehWZ_jButton_TC_actionAdapter(VehWZ adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_TC_actionPerformed(e);
    }
}


class VehWZ_jButton_SYB_actionAdapter implements ActionListener {
    private VehWZ adaptee;
    VehWZ_jButton_SYB_actionAdapter(VehWZ adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton_SYB_actionPerformed(e);
    }
}
