
public class Week {
    private QueueWithStacks<WeekDay> days;
    
    public Week() {
        days = new QueueWithStacks<>();
    }
    
    public void addDay(WeekDay day) {
        days.enqueue(day);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        QueueWithStacks<WeekDay> tempQueue = new QueueWithStacks<>();
        
        while (!days.isEmpty()) {
            WeekDay day = days.dequeue();
            sb.append(day.toString());
            tempQueue.enqueue(day);
        }
        
        while (!tempQueue.isEmpty()) {
            days.enqueue(tempQueue.dequeue());
        }
        
        return sb.toString();
    }
}