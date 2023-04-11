package dao;

import pojo.City;
import pojo.Employee;

import java.util.List;

public interface CityDAO {
    void addCity(City city);

    City getCityById(int id);

    List<City> getAll();

    City updateCity(City city);

    void deleteCity(City city);
}
