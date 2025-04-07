package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TruckService {

    public static void addTruck(Truck truck){
        String sqlquery="insert into truck (name, model, capacity, driver_name) values (?,?,?,?)";

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sqlquery);

            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());

            int update = preparedStatement.executeUpdate();
            System.out.println("Data inserted "+update);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static Truck getTruckById(int id){
        String sqlquery="select * from truck where id= ?";
        Truck truck= new Truck();

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sqlquery);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity((resultSet.getInt("capacity")));
                truck.setDriver_name(resultSet.getString("driver_name"));
            }

            System.out.println("Data found of id "+id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return truck;
    }


    public static void updateTruck(Truck truck){
        String sqlquery="update truck set name= ?, model= ?, capacity=?, driver_name=? where id=?";

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sqlquery);
            preparedStatement.setString(1,truck.getName());
            preparedStatement.setString(2,truck.getModel());
            preparedStatement.setInt(3,truck.getCapacity());
            preparedStatement.setString(4,truck.getDriver_name());
            preparedStatement.setInt(5,truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("Data inserted "+update);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    public List<Truck> getAllTruck(){
        String sqlquery="select * from truck";
        List<Truck> trucks = new ArrayList<Truck>();

        try{
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlquery);

            while(resultSet.next()){
                Truck truck = new Truck();

                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity((resultSet.getInt("capacity")));
                truck.setDriver_name(resultSet.getString("driver_name"));

                trucks.add(truck);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return trucks;
    }



    public static void deleteTruck(int id){
        String sqlquery="delete from truck where id= ?";

        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement(sqlquery);

            preparedStatement.setInt(1,id);

            int update = preparedStatement.executeUpdate();
            System.out.println("Data deleted "+update);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
