package com.engeto.selfwork;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    Color color = new Color(0x4E25B0); // jedna barva pro všechno, lepší než dokola vytvářet setForeground(new Color()); ....

    MyFrame(){

        // vytvoření GUI
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hodiny");
        this.setLayout(new FlowLayout());
        this.setSize(380, 220);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // zobrazení Gui na středu

        // vytvoření formátu
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("d.MMMMM yyyy");

        // nastavení času
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timeLabel.setForeground(color);

        // nastavení dne
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Serif", Font.PLAIN,35));
        dayLabel.setForeground(color);

        // nastavení data
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Serif", Font.PLAIN, 45));
        dateLabel.setForeground(color);

        // viditelnost
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();

    }
    public void setTime(){
        // refreš každých 1000 mili sekund
        while (true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
