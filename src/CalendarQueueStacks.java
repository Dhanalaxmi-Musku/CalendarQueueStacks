public class CalendarQueueStacks {
    static QueueWithStacks<Week> calendar;
    static String[] dayNames = {"S", "M", "T", "W", "Th", "F", "S"};
    
    static int getDayOfWeek(int month, int year) {
        if (month < 3) {
            month += 12;
            year -= 1;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (1 + (13 * (month + 1)) / 5 + k + (k / 4) + (j / 4) - (2 * j)) % 7;
        return ((h + 5) % 7) + 1;
    }
    
    static int getDaysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            return 29;
        }
        return days[month];
    }
    
    static void createCalendar(int month, int year) {
        calendar = new QueueWithStacks<>();
        int startDay = getDayOfWeek(month, year);
        int daysInMonth = getDaysInMonth(month, year);
        int currentDay = 1;
        
        System.out.println("S    M   T  W   Th   F   S");
        
        while (currentDay <= daysInMonth || startDay > 1) {
            Week week = new Week();
            
            for (int i = 0; i < 7; i++) {
                if (startDay > 1) {
                    week.addDay(new WeekDay(dayNames[i], ""));
                    startDay--;
                } else if (currentDay <= daysInMonth) {
                    week.addDay(new WeekDay(dayNames[i], String.valueOf(currentDay)));
                    currentDay++;
                } else {
                    week.addDay(new WeekDay(dayNames[i], ""));
                }
            }
            calendar.enqueue(week);
        }
    }
    
    static void printCalendar() {
        QueueWithStacks<Week> tempCalendar = new QueueWithStacks<>();
        
        while (!calendar.isEmpty()) {
            Week week = calendar.dequeue();
            System.out.println(week);
            tempCalendar.enqueue(week);
        }
        
        while (!tempCalendar.isEmpty()) {
            calendar.enqueue(tempCalendar.dequeue());
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CalendarQueueStacks month year");
            return;
        }
        
        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);
        
        if (month < 1 || month > 12) {
            System.out.println("Month should be between 1 and 12");
            return;
        }
        
        createCalendar(month, year);
        printCalendar();
    }
}
