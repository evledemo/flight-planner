package my.evledemo.planner.repository;

import my.evledemo.planner.entety.Connection;
import my.evledemo.planner.entety.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {

	List<Price> findByConnection(Connection connection);

}