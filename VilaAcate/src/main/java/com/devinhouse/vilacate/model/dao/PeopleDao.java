package com.devinhouse.vilacate.model.dao;

import com.devinhouse.vilacate.jdbc.ConnectionJDBC;
import com.devinhouse.vilacate.model.dto.PeopleDto;
import com.devinhouse.vilacate.model.entity.People;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleDao {

    public List<People> listPeoples() throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM people");
        ResultSet resultSet = stmt.getResultSet();

        List<People> peoples = new ArrayList<>();
        while (resultSet.next()) {
            peoples.add(new People(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDouble("rent"),
                    resultSet.getString("cpf"),
                    resultSet.getString("email")
            ));

        }
        connection.close();
        return peoples;
    }

    public PeopleDto peopleById(Long id) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM people WHERE id = " + id);
        ResultSet resultSet = stmt.getResultSet();

        PeopleDto people = null;
        while (resultSet.next()) {
            people = new PeopleDto(resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDouble("rent"),
                    resultSet.getString("cpf"),
                    resultSet.getString("email"));
        }
        connection.close();
        return people;
    }

    public List<People> peopleByName(String name) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM people WHERE name LIKE('" + name + "%')");
        ResultSet resultSet = stmt.getResultSet();

        List<People> peoples = new ArrayList<>();
        while (resultSet.next()) {
            peoples.add(new People(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDouble("rent"),
                    resultSet.getString("cpf"),
                    resultSet.getString("email")
            ));

        }
        connection.close();
        return peoples;
    }

    public List<People> listPeoplesByMonth(Integer month) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM people WHERE EXTRACT(MONTH FROM birth_date) = " + month);
        ResultSet resultSet = stmt.getResultSet();

        List<People> peoples = new ArrayList<>();
        while (resultSet.next()) {
            peoples.add(new People(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDouble("rent"),
                    resultSet.getString("cpf"),
                    resultSet.getString("email")
            ));
        }
        connection.close();
        return peoples;
    }

    public List<People> listPeoplesByAge(Integer year) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("SELECT * FROM people WHERE EXTRACT(YEAR FROM birth_date) <= " + year);
        ResultSet resultSet = stmt.getResultSet();

        List<People> peoples = new ArrayList<>();
        while (resultSet.next()) {
            peoples.add(new People(resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getDate("birth_date"),
                    resultSet.getDouble("rent"),
                    resultSet.getString("cpf"),
                    resultSet.getString("email")
            ));
        }
        connection.close();
        return peoples;
    }

    public void createPeople(PeopleDto peopleDto) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        PreparedStatement stmt =
                connection.prepareStatement
                        ("INSERT INTO people(name,surname, birth_date, rent, cpf, email, password) VALUES  (?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, peopleDto.getName());
        stmt.setString(2, peopleDto.getSurname());
        stmt.setDate(3, peopleDto.getBirthdate());
        stmt.setDouble(4, peopleDto.getRent());
        stmt.setString(5, peopleDto.getCpf());
        stmt.setString(6, peopleDto.getEmail());
        stmt.setString(7, peopleDto.getPassword());
        stmt.execute();
        connection.close();
    }

    public void deletePeople(Long id) throws SQLException {
        Connection connection = new ConnectionJDBC().GetConnection();
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM people WHERE id = " + id);
        connection.close();
    }

}
