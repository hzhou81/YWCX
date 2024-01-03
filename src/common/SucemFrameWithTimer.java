package common;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import gui.VehNumber;

/**
 * <p>����: �������</p>
 *
 * <p>����: </p>
 *
 * <p>��Ȩ: Copyright (c) 2005</p>
 *
 * <p>��λ: �Ϻ����ֳ������г����޹�˾</p>
 *
 * @���� �����
 * @�汾 1.0
 */
public class SucemFrameWithTimer extends SucemFrame implements Timerable{
    int waitTime;
    Timer timer;

    /*
     WaitTime:�ǵȴ���ʱ����,����ʹ�õ�������
    */
    public SucemFrameWithTimer(int WaitTime) {
        waitTime=WaitTime;
        try{
            jbInit();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SucemFrameWithTimer sucemframe = new SucemFrameWithTimer(5);
        sucemframe.setVisible(true);
    }
    public void this_mouseMoved(MouseEvent e) {
        timer.Interrupt();
        timer=new Timer(this,waitTime);
        timer.start();
    }
    public void this_mouseClicked(MouseEvent e){
        timer.Interrupt();
        timer=new Timer(this,waitTime);
        timer.start();
    }
    public void OnTimerDoIt() {
        this.setVisible(false);
        this.dispose();
    }

    private void jbInit() throws Exception {
        // waitTime=WaitTime;
        this.addMouseMotionListener(new SucemFrame_mouseMotionAdapter(this));
        this.addMouseListener(new SucemFrameWithTimer_this_mouseAdapter(this));
        timer=new Timer(this,waitTime);
        timer.start();
        this.addMouseListener(new SucemFrameWithTimer_this_mouseAdapter(this));
        this.addMouseMotionListener(new
                                    SucemFrameWithTimer_this_mouseMotionAdapter(this));
    }

    public void this_mousePressed(MouseEvent e) {
        timer.Interrupt();
        timer=new Timer(this,waitTime);
        timer.start();
    }
}
class SucemFrame_mouseMotionAdapter extends MouseMotionAdapter {
    private SucemFrameWithTimer adaptee;
    SucemFrame_mouseMotionAdapter(SucemFrameWithTimer adaptee) {
        this.adaptee = adaptee;
    }
    public void mouseMoved(MouseEvent e) {
        adaptee.this_mouseMoved(e);
    }
}
class SucemFrameWithTimer_this_mouseAdapter extends MouseAdapter {
    private SucemFrameWithTimer adaptee;
    SucemFrameWithTimer_this_mouseAdapter(SucemFrameWithTimer adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {

        adaptee.this_mouseClicked(e);
    }
}


class SucemFrameWithTimer_this_mouseMotionAdapter extends MouseMotionAdapter {
    private SucemFrameWithTimer adaptee;
    SucemFrameWithTimer_this_mouseMotionAdapter(SucemFrameWithTimer adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseMoved(MouseEvent e) {

        adaptee.this_mouseMoved(e);
    }
}