package main.server.databaseaccess.personaltrainer;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.PersonalTrainer;
import main.shared.UserName;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonalTrainerDAO implements PersonalTrainerDAOModel
{
    DBConnectionModel dbConnection;

    public PersonalTrainerDAO(DBConnectionModel dbConnection)
    {
        this.dbConnection = dbConnection;
    }

    @Override
    public String savePersonalTrainer(PersonalTrainer personalTrainer)
    {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO personaltrainers (fullname, phonenumber, ssn, date, time) VALUES (?,?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, personalTrainer.getName());
            statement.setString(2,  personalTrainer.getPhoneNumber());
            statement.setString(3,    personalTrainer.getSsn());
            statement.setDate(4,  Date.valueOf(personalTrainer.getDate()));
            statement.setString(5, personalTrainer.getStartTime());
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Personal Trainer Saved successfully";
    }

    @Override
    public ArrayList<PersonalTrainer> getPersonalTrainers(boolean staff)
    {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<PersonalTrainer> list = new ArrayList<>();

        if(!staff){
            try {
                String query = "select * from personaltrainers except select fullname, p.phonenumber, p.ssn, p.date, p.time from booking inner join personaltrainers p on booking.ssn = p.ssn and booking.date = p.date and booking.time = p.time";
                statement = dbConnection.createPreparedStatement(query);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    PersonalTrainer personalTrainer = new PersonalTrainer(resultSet.getString("fullname"),resultSet.getString("phonenumber"),resultSet.getString("ssn"),resultSet.getString("time"),resultSet.getString("date"));
                    list.add(personalTrainer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection();
            }

            return list;
        }
        else {
            try {
                String query = "select  username, fullname, phonenumber, personaltrainers.ssn, personaltrainers.date, " +
                        "personaltrainers.time  from personaltrainers full outer join booking b on personaltrainers.ssn =" +
                        "b.ssn and personaltrainers.date = b.date and personaltrainers.time = b.time";

                statement = dbConnection.createPreparedStatement(query);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    PersonalTrainer personalTrainer = new PersonalTrainer(resultSet.getString("fullname"),resultSet.getString("phonenumber"),resultSet.getString("ssn"),resultSet.getString("time"),resultSet.getString("date"));
                    personalTrainer.setUsername(resultSet.getString("username"));
                    list.add(personalTrainer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                dbConnection.closeConnection();
            }

            return list;
        }

    }

    @Override
    public String removePersonalTrainer(PersonalTrainer personalTrainer)
    {
        PreparedStatement statement;
        try
        {
            String query = "DELETE FROM personaltrainers WHERE ssn like ? AND date=? and time like ?";
            statement =dbConnection.createPreparedStatement(query);
            statement.setString(1, personalTrainer.getSsn());
            statement.setDate(2, Date.valueOf(personalTrainer.getDate()));
            statement.setString(3, personalTrainer.getStartTime());
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "Personal trainer has been deleted successfully";
    }

    @Override
    public String bookPersonalTrainer(PersonalTrainer personalTrainer, UserName userName)
    {
        PreparedStatement statement;

        try {
            String query = "INSERT INTO booking (username, ssn, date, time) VALUES (?,?,?,?)";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, userName.getUserName());
            statement.setString(2,  personalTrainer.getSsn());
            statement.setDate(3,  Date.valueOf(personalTrainer.getDate()));
            statement.setString(4,  personalTrainer.getStartTime());
            statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            dbConnection.closeConnection();
        }

        return "Personal booked successfully";
    }

    @Override
    public ArrayList<PersonalTrainer> viewMyBookings(UserName userName)
    {
        PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<PersonalTrainer> list = new ArrayList<>();
        try {
            String query = "select p.date, p.time, p.fullname, p.phonenumber, p.ssn from booking inner join" +
                    " personaltrainers p on booking.ssn = p.ssn and booking.date = p.date" +
                    " and booking.time = p.time where username like ?";
            statement = dbConnection.createPreparedStatement(query);
            statement.setString(1, userName.getUserName());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PersonalTrainer personalTrainer = new PersonalTrainer(resultSet.getString("fullname"),resultSet.getString("phonenumber"), resultSet.getString("ssn"),resultSet.getString("time"),resultSet.getString("date"));
                list.add(personalTrainer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbConnection.closeConnection();
        }

        return list;
    }

    @Override
    public String cancelBooking(PersonalTrainer personalTrainer, UserName userName)
    {
        System.out.println(personalTrainer + " in the server " + userName.getUserName());
        PreparedStatement statement;
        try
        {
            String query = "DELETE FROM booking WHERE username LIKE ? and ssn LIKE ? AND date = ? AND time LIKE ?";
            statement =dbConnection.createPreparedStatement(query);
            statement.setString(1, userName.getUserName());
            statement.setString(2, personalTrainer.getSsn());
            statement.setDate(3, Date.valueOf(personalTrainer.getDate()));
            statement.setString(4, personalTrainer.getStartTime());
            statement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return "You have successfully cancelled the booking";
    }
}
