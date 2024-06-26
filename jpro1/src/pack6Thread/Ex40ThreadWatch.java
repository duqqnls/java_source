package pack6Thread;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class Ex40ThreadWatch extends Frame implements Runnable {
    private boolean b = false;
    private final int POINTMIDDLEX = 150;
    private final int POINTMIDDLEY = 150;

    public Ex40ThreadWatch() {
        super("시계");
        setBounds(200, 200, 300, 300);
        setVisible(true);
        new Thread(this).start();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                b = true;
                System.exit(0);
            }
        });
    }

    public void run() {
        while (true) {
            if (b) break;
            repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void paint(Graphics g) {
        Calendar cal = Calendar.getInstance();
        g.clearRect(0, 0, 300, 300);
        LineDraw(g);
        TimeDraw(g, Color.BLUE, cal.get(Calendar.SECOND), 360.0 / 60.0, 100.0);
        TimeDraw(g, Color.RED, cal.get(Calendar.MINUTE), 360.0 / 60.0, 100.0);
        TimeDraw(g, Color.GREEN, cal.get(Calendar.HOUR), 360.0 / 12.0, 70.0);
    }

    public void LineDraw(Graphics g) {
        double dAngle = -90.0;
        for (int nCount = 0; nCount < 60; nCount++) {
            if ((nCount % 5) == 0)
                g.setColor(Color.BLACK);
            else
                g.setColor(Color.PINK);

            int nStartX = (int) (POINTMIDDLEY + (Math.cos(Math.PI * (dAngle / 180.0)) * 110));
            int nStartY = (int) (POINTMIDDLEY + (Math.sin(Math.PI * (dAngle / 180.0)) * 110));
            int nEndX = (int) (POINTMIDDLEY + (Math.cos(Math.PI * (dAngle / 180.0)) * 120));
            int nEndY = (int) (POINTMIDDLEY + (Math.sin(Math.PI * (dAngle / 180.0)) * 120));

            g.drawLine(nStartX, nStartY, nEndX, nEndY);
            dAngle += (360.0 / 60.0);
        }
    }

    void TimeDraw(Graphics g, Color color, double dAngle, double dSelect, double dSize) {
        g.setColor(color);
        dAngle *= dSelect;
        dAngle -= 90.0;

        if (dAngle < 0.0)
            dAngle += 360.0;  // 수정된 부분: dAngle이 0보다 작을 때 360도를 더하여 보정
        int nDestX = (int) (POINTMIDDLEX + (Math.cos(Math.PI * (dAngle / 180.0)) * dSize));
        int nDestY = (int) (POINTMIDDLEY + (Math.sin(Math.PI * (dAngle / 180.0)) * dSize));
        g.drawLine((int) POINTMIDDLEX, (int) POINTMIDDLEY, nDestX, nDestY);
    }

    public static void main(String[] args) {
        new Ex40ThreadWatch();
    }
}
