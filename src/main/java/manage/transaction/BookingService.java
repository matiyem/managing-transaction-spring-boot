package manage.transaction;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class BookingService {

    private final JdbcTemplate jdbcTemplate;

    @Transactional//اگر یکی از insert ها به خطا بخورد تمام insert ها roll back میشوند
    public void book(String...persons){
        for (String person:persons){
            log.info("Booking " + person + " in a seat...");
            jdbcTemplate.update("insert into bookings(first_name) values (?)",person);
        }
    }
    public List<String> findAllBookings(){
        return jdbcTemplate.query("select first_name from bookings",(rs,rowNum)->
                rs.getNString("first_name"));
    }

}
