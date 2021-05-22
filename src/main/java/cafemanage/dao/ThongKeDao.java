package cafemanage.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThongKeDao {
	@Autowired
	private EntityManager entityManager;
	
	public Map<String, Object> thongKeSoLuongMoiMon(String fromDate, String toDate){
		Map<String, Object> mapResult = new HashMap<>();
		
		String sqlSoLuongMon = "select monan.mamonan, tenmonan, Count(monan.mamonan) as soluong " 
								+ " from monan inner join cthoadon on monan.mamonan = cthoadon.mamonan " 
								+ " inner join hoadon on hoadon.mahoadon = cthoadon.mahoadon " 
								+ " where dathanhtoan = 1 and thoigian between ?1 and ?2 " 
								+ " group by monan.mamonan";
		
		Query querySoLuongMon= entityManager.createNativeQuery(sqlSoLuongMon);
		querySoLuongMon.setParameter(1, fromDate);
		querySoLuongMon.setParameter(2, toDate);
		querySoLuongMon.getResultStream().forEach((record) -> {
			mapResult.put("maMonAn", ((Object[]) record)[0]);
			mapResult.put("tenMonAn", ((Object[]) record)[1]);
			mapResult.put("soLuong", ((Object[]) record)[2]);
			
		});
		
	
		return mapResult;
	}
	
	public Map<String, Object> thongKeDoanhSoCuaNhanVien(String fromDate, String toDate){
		Map<String, Object> mapResult = new HashMap<>();
		
		String sqlSoLuongMon = "select tennhanvien, count(mahoadon) as sohoadon, sum(tongtien) as doanhthu "
								+ " from hoadon "
								+ " where dathanhtoan = 1 and thoigian between ?1 and ?2 "
								+ " group by tennhanvien";
		
		Query querySoLuongMon= entityManager.createNativeQuery(sqlSoLuongMon);
		querySoLuongMon.setParameter(1, fromDate);
		querySoLuongMon.setParameter(2, toDate);
		querySoLuongMon.getResultStream().forEach((record) -> {
			mapResult.put("tenNhanVien", ((Object[]) record)[0]);
			mapResult.put("soHoaDon", ((Object[]) record)[1]);
			mapResult.put("doanhThu", ((Object[]) record)[2]);
			
		});
		
	
		return mapResult;
	}
}
