/* *@author Chau Siu Hong 20186650 */
/*date created 15/2/2024 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class LearnCalendar extends JFrame {
    // create a Calendar object
    Calendar cal1 = new GregorianCalendar();
    Calendar cal2 = new GregorianCalendar(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 1);
    private CalendarPanel cal = new CalendarPanel(cal2);
//method
    public LearnCalendar() {
        JPanel panel = new JPanel();
        // button of go to previous month
        JButton previous = new JButton("Previous");
        previous.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(cal);
                cal = cal.movetoPreM();
                add(cal, BorderLayout.CENTER);
                repaint(); // replace the original button
                revalidate(); //and update the current month
            }
        });
        panel.add(previous);
        // button of go to next month
        JButton next = new JButton("Next");
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                remove(cal);
                cal = cal.movetoNextM();
                add(cal, BorderLayout.CENTER);
                repaint(); // replace the original button
                revalidate(); //and update the current month
            }
        });
        panel.add(next);
        JButton create = new JButton("create");
        create.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               
                Reminder.Reminder();
            }
        });
        panel.add(create);
        add(cal, BorderLayout.CENTER);
        add(panel, BorderLayout.NORTH);
        add(create, BorderLayout.SOUTH);
    }

    public static void createCal(){
        JFrame frame = new LearnCalendar();
        frame.pack();
        frame.setSize(500,500);
        frame.setLocation(300,300);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createCal();
    }
}

class CalendarPanel extends JPanel {
//field
    public Calendar calendar;
    private int currY;
    private int currM;
    private int daysinM;
    private int daysofWeek;
    private int preM;
//method
    public CalendarPanel(Calendar calendar) {
        this.calendar = calendar;
        setLayout(new BorderLayout());
        // get value of year, month, days
        currY = calendar.get(Calendar.YEAR);
        currM = calendar.get(Calendar.MONTH);
        daysinM = getMaximum(currM);
        daysofWeek = calendar.get(Calendar.DAY_OF_WEEK);
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
        
        int i = 1;
        int daysinPreM = getMaximum(preM);
        int preMdisplay = daysinPreM - daysofWeek + 2;
        // display days in previous month
        for (i = 1; i < daysofWeek; i++) {
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
    // get the previous month
    private int getPreM(int month) {
        if (month == 0) { // real month = month + 1
            return 11; // Jan to Dec
        }
        
        return month - 1; 
    }
    // maximun day in a month
    private int getMaximum(int month) {
        int maximum = 0;
        switch (month) {
            case 0: // January
                maximum = 31;
                break;
            case 1: // February
                if (isLeap()) // every 4 year 
                    maximum = 29;
                else 
                    maximum = 28;
                break;
            case 2: // March
                maximum = 31;
                break;
            case 3: // April
                maximum = 30;
                break;
            case 4: // May
                maximum = 31;
                break;
            case 5: // June
                maximum = 30;
                break;
            case 6: // July
                maximum = 31;
                break;
            case 7: // August
                maximum = 31;
                break;
            case 8: // September
                maximum = 30;
                break;
            case 9: // October
                maximum = 31;
                break;
            case 10: // November
                maximum = 30;
                break;
            case 11: // December
                maximum = 31;
                break;
        }
        
        return maximum;
    }
    // is 2/29 exist?
    private boolean isLeap() {
        return currY % 4 == 0;
    }
    // go to previous month
    public CalendarPanel movetoPreM() {
        return new CalendarPanel(new GregorianCalendar(
                currY, 
                currM - 1, 
                1));
    }
    // go to next month
    public CalendarPanel movetoNextM() {
        return new CalendarPanel(new GregorianCalendar(
                currY, 
                currM + 1, 
                1));
    }

   
}
