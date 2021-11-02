public class LogMessage {
    private String date;
    private String time;
    private String line;
    private String operation;

    public LogMessage(String date, String time, String line, String operation) {
        this.date = date;
        this.time = time;
        this.line = line;
        this.operation = operation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", line='" + line + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMessage that = (LogMessage) o;
        return date.equals(that.date) && time.equals(that.time) && line.equals(that.line) && operation.equals(that.operation);
    }
}
