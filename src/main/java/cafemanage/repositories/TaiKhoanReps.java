package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cafemanage.entities.TaiKhoan;

@Repository
public interface TaiKhoanReps extends JpaRepository<TaiKhoan, String>{
	
}
