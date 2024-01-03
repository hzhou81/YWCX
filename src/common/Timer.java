package common;

/**
 * <p>����: ��ʱ��</p>
 *
 * <p>����: �ڹ涨��ʱ����ִ��һЩ����,Ҳ����ֹͣ��ʱ��</p>
 *
 * <p>��Ȩ: Copyright (c) 2005</p>
 *
 * <p>��λ: �Ϻ����ֳ������г����޹�˾</p>
 *
 * @���� �����
 * @�汾 1.0
 */
public class Timer extends Thread{
    private Timerable ta;
    private int      interval;
    private boolean   stop    =false;

    public Timer(Timerable TimerAble,int InterVal) {
        this.ta=TimerAble;
        interval=InterVal;
    }
    public void run() {
        try {
            Thread.sleep(interval*1000);
        } catch (InterruptedException ex) {
        }
        ta.OnTimerDoIt();
    }

    public void start(){
        this.stop=false;
        super.start();
    }
    public void Interrupt(){
        this.stop=true;
        super.stop();
    }
}