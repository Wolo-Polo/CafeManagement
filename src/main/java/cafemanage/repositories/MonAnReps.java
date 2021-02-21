package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.MonAn;

@Repository
public interface MonAnReps extends JpaRepository<MonAn, String>{

}
