package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.borland.jbcl.layout.XYConstraints;
import com.borland.jbcl.layout.XYLayout;
import common.Param;
import common.SucemFrame;
import control.ImageButton;
import control.ImagePanel;

/**
 * <p>标题: 欢迎界面</p>
 *
 * <p>描述: </p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 孙汇洲
 * @版本 1.0
 */
public class Welcome extends SucemFrame {
    ImagePanel imagePanel=new ImagePanel("background.jpg");
    ImageButton imageButton=new ImageButton("SearchBtn.jpg",129,147);
    XYLayout xYLayout1 = new XYLayout();

    public Welcome() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void jbInit() throws Exception {
        imagePanel.setLayout(xYLayout1);
        imageButton.addActionListener(new Welcome_imageButton_actionAdapter(this));
        this.getContentPane().add(imagePanel, java.awt.BorderLayout.CENTER);
        imagePanel.add(imageButton, new XYConstraints(806, 572, -1, -1));
    }

    public void imageButton_actionPerformed(ActionEvent e) {
        // 开始查询
        VehType hpzlFrame=new VehType(Param.getInstance().getTypeTime());
        Param.getInstance().SetSearchType(Param.YWQK);
        //Param.getInstance().SetSearchType(Param.CLWZ);
        hpzlFrame.setVisible(true);
    }
}

class Welcome_imageButton_actionAdapter implements ActionListener {
    private Welcome adaptee;
    Welcome_imageButton_actionAdapter(Welcome adaptee) {
        this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
        adaptee.imageButton_actionPerformed(e);
    }
}
