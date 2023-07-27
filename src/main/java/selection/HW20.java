package selection;

import config.State;
import objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HW20 extends State {


//    var1
    public static void getUserByID(String id) throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT * FROM sys.hillel1303 where id=\""+id+"\";");
        while (resultSet.next()){
            System.out.println("id = "+resultSet.getString("id")
                    + "; name = "+resultSet.getString("name")
            );
        }
    }


//    var2

    public static void getUserByID2(String id) throws SQLException {
        ResultSet resultSet=getStatement().executeQuery("SELECT name FROM sys.hillel1303 where id=\""+id+"\";");
        while (resultSet.next()){
            System.out.println(
                    "id = "+id
                    + "; name = "+resultSet.getString("name")
            );
        }
    }



//    var1 когад передаем город
    public static List<User> getUserObjects(String city)  {
        ResultSet resultSet= null;
        List<User> list=new ArrayList<>();
        try {
            resultSet = getStatement().executeQuery("SELECT * FROM sys.hillel1303 where city=\""+city+"\";");


            while (resultSet.next()){
                list.add(new User(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


//    var 2 группирует всех юзеров с одинаковыми городами
public static List<User> getUserObjects2()  {
    ResultSet resultSet= null;
    List<User> list=new ArrayList<>();
    try {
        resultSet = getStatement().executeQuery("select u.* \n" +
                "from  sys.hillel1303 u\n" +
                "join (\n" +
                "\tselect city  ,count(*)\n" +
                "\tfrom sys.hillel1303 \n" +
                "\tgroup by  city\n" +
                "\thaving count(*)>1\n" +
                ") c on c.city=u.city");


        while (resultSet.next()){
            list.add(new User(resultSet));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return list;
}

}
