
public class WeekDay {
	private String day;
    private String date;
    
    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }
    
    @Override
    public String toString() {
        return String.format("%2s  ", date);
    }

}
