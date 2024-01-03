package control;

import java.awt.*;

import javax.swing.*;

/**
 * <p>标题: </p>
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
public class ImageButton extends JButton {
    BorderLayout borderLayout1 = new BorderLayout();
    JLabel ImageLabel = new JLabel();
    String _imageName;
    int _width,_height;

    public ImageButton(String ImageName,int Width,int Height) {
        _imageName=ImageName;
        _width=Width;
        _height=Height;
        ImageIcon ii=new ImageIcon(this.getClass().getResource(_imageName));
        this.setIcon(ii);
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public ImageButton(){}
    private void jbInit() throws Exception {
        /*setLayout(borderLayout1);
        this.add(ImageLabel, java.awt.BorderLayout.CENTER);
        ImageIcon ii=new ImageIcon(this.getClass().getResource(_imageName));
        ImageLabel.setIcon(ii);
        this.setBorder(null);*/
       this.setBorder(null);
    }

    public static void main(String[] args) {
        // ImageButton imagebutton = new ImageButton();
    }
}
