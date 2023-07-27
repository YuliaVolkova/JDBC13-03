import objects.User;
import org.junit.Assert;
import org.junit.Test;
import selection.HW20;

import java.sql.SQLException;

public class TestJDBC_HW20 {


        @Test
        public void getUserByID() throws SQLException {
        HW20.getUserByID("1");

        }

        @Test
        public void getUserByID2() throws SQLException {
            HW20.getUserByID2("1");

        }

        @Test
    public void getUserWithSameCity(){
            for (User l : HW20.getUserObjects("Odesa")) {
                System.out.println(l.id+ " "+l.name+" "+l.family+" "+l.cityName +" "+ l.date);
            }
        }

    @Test
    public void getUserWithSameCity2(){
        for (User l : HW20.getUserObjects2()) {
            System.out.println(l.id+ " "+l.name+" "+l.family+" "+l.cityName +" "+ l.date);
        }
    }



}
