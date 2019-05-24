package my.evledemo.planner.repository;

import my.evledemo.planner.entety.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	Optional<City> findByIata(String iata);
}