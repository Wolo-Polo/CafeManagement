package cafemanage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.LoaiMon;
import cafemanage.entities.MonAn;

@Repository
public interface MonAnReps extends JpaRepository<MonAn, String>{
	List<MonAn> findByLoaiMon(LoaiMon loaiMon);
	
}
