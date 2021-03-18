package cafemanage.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cafemanage.entities.DoanhSo;

@Repository
public interface ThongKeReps extends JpaRepository<DoanhSo, Integer>{
	
	@Query(nativeQuery = true, 
			value = "select mahoadon as id, month(thoigian) as thang, count(mahoadon) as soluonghoadon, SUM(tongtien) as doanhthu" + 
			" from hoadon" + 
			" where dathanhtoan = 1 and year(thoigian) = ?1" + 
			" group by thang")
	List<DoanhSo> thongKe(Integer nam);
}
