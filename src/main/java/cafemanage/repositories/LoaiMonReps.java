package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.LoaiMon;
@Repository
public interface LoaiMonReps extends JpaRepository<LoaiMon, String>{

}
