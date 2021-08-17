package manage.transaction;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Slf4j
@AllArgsConstructor
public class AppRunner implements CommandLineRunner {
    //برای inject کردن فایل schema.sql به کلاس BookingService باید این کلاس را بنویسیم

    private final BookingService bookingService;



    @Override
    public void run(String... args) throws Exception {
        bookingService.book("Alice" , "Bob","Carol");
        //این خط در اصل نوعی validation است که آرمان اول شرط را دریافت میکند و آرگمان دوم پیغام است.کلاس Assert برای validation است
        Assert.isTrue(bookingService.findAllBookings().size() ==3,"First" +
                "booking should work with no problem");
        log.info("Alice,Bob and Carol have been booked");

        try {
            bookingService.book("Chris","samuel");
        } catch (RuntimeException e) {
            log.info("v--- The fllowing exception is expect because 'Samuel' is too big for the DB----v");
           log.error(e.getMessage());
        }
        for (String person :bookingService.findAllBookings()){
            log.info("So far, " + person + " is booked.");
        }
        log.info("you shouldnt see Chris or Samuel.Samuel violated DB constraints," +
                "and Chris was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() ==3,
                "'Samuel' should have triggered a rollback");


        try {
            bookingService.book("Buddy" ,null);
        } catch (Exception e) {
            log.info("v--- the following exception is expect because null is not" +
                    "valid for the DB ---v");
            log.error(e.getMessage());
        }
        for (String person : bookingService.findAllBookings()){
            log.info("So far, "+  person + " is booked.");
        }
        log.info("you shouldnt see Buddy or null.null violated DB constraints," +
                "and Buddy was rolled back in the same tx");
        Assert.isTrue(bookingService.findAllBookings().size()==3,
                "'null' should have triggered a rollback");
    }

}
