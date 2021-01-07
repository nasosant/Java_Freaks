import java.util.Date;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class Deceased {
    public final Date deceased_date;
    public final Confirmed confirmed;

    public Deceased(Confirmed confirmed, Date deceased_date) {
        this.confirmed = confirmed;
        this.deceased_date = deceased_date;
    }
}
