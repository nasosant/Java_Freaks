import java.util.Date;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class Cured {
    public final Date cured_date;
    public final Confirmed confirmed;

    public Cured(Confirmed confirmed, Date cured_date) {
        this.confirmed = confirmed;
        this.cured_date = cured_date;
    }
}