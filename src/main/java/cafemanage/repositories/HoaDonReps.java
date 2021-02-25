package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.HoaDon;
@Repository
public interface HoaDonReps extends JpaRepository<HoaDon, Integer>{
	
}
