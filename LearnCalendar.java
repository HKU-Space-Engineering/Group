import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LearnCalendar extends JFrame {
    
    Calendar cal1 = new GregorianCalendar();
    Calendar cal2 = new GregorianCalendar(
            cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 1);
    
    private CalendarPanel a = new CalendarPanel(cal2);
    private JButton previous = new JButton("Previous");
    private JButton next = new JButton("Next");
    
    LearnCalendar() {
        JPanel panel = new JPanel();
        panel.add(previous);
        panel.add(next);
        
        add(a, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(a);
                a = a.movetoNextM();
                add(a, BorderLayout.CENTER);
                repaint();
                revalidate();
            }
        });
        
        previous.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                remove(a);
                a = a.movetoPreM();
                add(a, BorderLayout.CENTER);
                repaint();
                revalidate();
            }
        });
    }
    
    public static void main(String[] args) {
        JFrame frame = new LearnCalendar();
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CalendarPanel extends JPanel {
    
    public Calendar calendar;
    private int currY;
    private int currM;
    private int daysinM;
    private int starDay;
    private int preM;
    
    public CalendarPanel(Calendar calendar) {
        this.calendar = calendar;
        
        setLayout(new BorderLayout());
        
        
        currY = calendar.get(Calendar.YEAR);
        currM = calendar.get(Calendar.MONTH);
        daysinM = getMaximum(currM);
        starDay = calendar.get(Calendar.DAY_OF_WEEK);
        preM = getPreM(currM);
        // header = month and year
        JLabel header = new JLabel((currM + 1) + "/" + currY);
        header.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel panel = new JPanel(new GridLayout(0, 7, 0, 0));
        Border border = new LineBorder(Color.BLACK, 1);
        // days in a week
        JLabel sun = new JLabel("Sunday");
        sun.setHorizontalAlignment(JLabel.CENTER);
        sun.setBorder(border);
        
        JLabel mon = new JLabel("Monday");
        mon.setHorizontalAlignment(JLabel.CENTER);
        mon.setBorder(border);
        
        JLabel tue = new JLabel("Tuesday");
        tue.setHorizontalAlignment(JLabel.CENTER);
        tue.setBorder(border);
        
        JLabel wed = new JLabel("Wednesday");
        wed.setHorizontalAlignment(JLabel.CENTER);
        wed.setBorder(border);
        
        JLabel thur = new JLabel("Thursday");
        thur.setHorizontalAlignment(JLabel.CENTER);
        thur.setBorder(border);
        
        JLabel fri = new JLabel("Friday");
        fri.setHorizontalAlignment(JLabel.CENTER);
        fri.setBorder(border);
        
        JLabel sat = new JLabel("Saturday");
        sat.setHorizontalAlignment(JLabel.CENTER);
        sat.setBorder(border);
        
        panel.add(sun);
        panel.add(mon);
        panel.add(tue);
        panel.add(wed);
        panel.add(thur);
        panel.add(fri);
        panel.add(sat);
        
        int i;
        
        int daysinPreM = getMaximum(preM);
        int preMdisplay = daysinPreM - starDay + 2;
        // display days in previous month
        for (i = 1; i < starDay; i++) {
            JLabel label = new JLabel(preMdisplay + "");
            label.setBorder(border);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setForeground(Color.lightGray);
            panel.add(label);
            preMdisplay++;
        }
        // display days in month
        for (int j = 1 ; j <= daysinM; j++, i++) {
            JLabel label = new JLabel(j + "");
            label.setBorder(border);
            label.setHorizontalAlignment(JLabel.CENTER);
            panel.add(label);
        }
        // display days in next month
        for (int j = 1 ; i <= 42; j++, i++) {
            JLabel label = new JLabel(j + "");
            label.setBorder(border);
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setForeground(Color.LIGHT_GRAY);
            panel.add(label);
        }
        
        add(header, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }
    
    private int getPreM(int month) {
        if (month == 0) {
            return 11;
        }
        
        return month - 1;
    }
    // maximun day in a month
    private int getMaximum(int month) {
        int maximum = 0;
        switch (month) {
            case 0: 
                maximum = 31;
                break;
            case 1: 
                if (isLeap())
                    maximum = 29;
                else
                    maximum = 28;
                break;
            case 2:
                maximum = 31;
                break;
            case 3:
                maximum = 30;
                break;
            case 4:
                maximum = 31;
                break;
            case 5:
                maximum = 30;
                break;
            case 6:
                maximum = 31;
                break;
            case 7:
                maximum = 31;
                break;
            case 8:
                maximum = 30;
                break;
            case 9:
                maximum = 31;
                break;
            case 10:
                maximum = 30;
                break;
            case 11:
                maximum = 31;
                break;
        }
        
        return maximum;
    }
    // is 2/29 exist?
    private boolean isLeap() {
        return (currY % 4 == 0 && currY % 100 != 0) || 
                currY % 400 == 0;
    }
    
    public CalendarPanel movetoPreM() {
        return new CalendarPanel(new GregorianCalendar(
                currY, 
                currM - 1, 
                1));
    }
    
    public CalendarPanel movetoNextM() {
        return new CalendarPanel(new GregorianCalendar(
                currY, 
                currM + 1, 
                1));
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 400);
    }
}