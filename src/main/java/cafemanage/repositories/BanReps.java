package cafemanage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cafemanage.entities.Ban;

@Repository
public interface BanReps extends JpaRepository<Ban, String>{
	@Query(nativeQuery = true, value = "update ban set tinhtrang = ?2 where maban = ?1")
	boolean updateTinhTrangOfBan(String maBan, String tinhTrang);
}
