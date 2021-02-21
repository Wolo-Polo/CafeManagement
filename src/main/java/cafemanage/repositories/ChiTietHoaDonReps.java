package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.ChiTietHoaDon;
@Repository
public interface ChiTietHoaDonReps extends JpaRepository<ChiTietHoaDon, String>{

}
