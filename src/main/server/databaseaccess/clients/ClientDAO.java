package main.server.databaseaccess.clients;

import main.server.databaseaccess.database.DBConnectionModel;
import main.shared.TheClient;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientDAO implements ClientDAOModel
{
  DBConnectionModel dbConnection;

  public ClientDAO(DBConnectionModel dbConnection)
  {
    this.dbConnection = dbConnection;
  }

  @Override public String saveClient(TheClient theClient)
  {
    PreparedStatement statement;

    try
    {
      String query = "INSERT INTO clients (fullname, ssn, username, password) VALUES (?,?,?,?)";
      statement = dbConnection.createPreparedStatement(query);
      statement.setString(1, theClient.getFullName());
      statement.setString(2, theClient.getSsn());
      statement.setString(3, theClient.getUsername());
      statement.setString(4, theClient.getPassword());
      statement.executeUpdate();

    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      dbConnection.closeConnection();
    }
    return "Client saved successfully";

  }

  @Override public ArrayList<TheClient> getClients()
  {
    PreparedStatement statement;
    ResultSet resultSet;
    ArrayList<TheClient> list = new ArrayList<>();

    try
    {
      String query = "SELECT * FROM clients";
      statement = dbConnection.createPreparedStatement(query);
      resultSet = statement.executeQuery();

      while (resultSet.next())
      {
        TheClient theClient = new TheClient(resultSet.getString("fullname"), resultSet.getString("ssn"), resultSet.getString("username"), resultSet.getString("password"));
        list.add(theClient);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      dbConnection.closeConnection();
    }
    return list;

  }

  @Override public String removeClient(TheClient theClient)
  {
    PreparedStatement statement;

    try
    {
      String query = "DELETE FROM clients WHERE username = ?";
      statement = dbConnection.createPreparedStatement(query);
      statement.setString(1, theClient.getUsername());
      statement.executeUpdate();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "Client deleted successfully";
  }
}
