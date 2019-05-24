package my.evledemo.planner.repository;

import my.evledemo.planner.entety.City;
import my.evledemo.planner.entety.Connection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConnectionRepository extends CrudRepository<Connection, Long> {

	Optional<Connection> findByCityFromAndCityTo(City cityFrom, City cityTo);
}