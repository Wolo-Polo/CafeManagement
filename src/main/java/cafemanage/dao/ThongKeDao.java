package cafemanage.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThongKeDao {
	@Autowired
	private EntityManager entityManager;
	
	public List<Map<String, Object>> thongKeSoLuongMoiMon(String fromDate, String toDate){
		List<Map<String, Object>> result = new ArrayList<>();
		
		String sqlSoLuongMon = "select monan.mamonan, tenmonan, Count(monan.mamonan) as soluong " 
								+ " from monan inner join cthoadon on monan.mamonan = cthoadon.mamonan " 
								+ " inner join hoadon on hoadon.mahoadon = cthoadon.mahoadon " 
								+ " where dathanhtoan = 1 and thoigian between ?1 and ?2 " 
								+ " group by monan.mamonan";
		
		Query querySoLuongMon= entityManager.createNativeQuery(sqlSoLuongMon);
		querySoLuongMon.setParameter(1, fromDate);
		querySoLuongMon.setParameter(2, toDate);
		querySoLuongMon.getResultStream().forEach((record) -> {
			Map<String, Object> recordResult = new HashMap<>();
			recordResult.put("maMonAn", ((Object[]) record)[0]);
			recordResult.put("tenMonAn", ((Object[]) record)[1]);
			recordResult.put("soLuong", ((Object[]) record)[2]);
			result.add(recordResult);
		});
		
	
		return result;
	}
	
	public List<Map<String, Object>> thongKeDoanhSoCuaNhanVien(String fromDate, String toDate){
		List<Map<String, Object>> result = new ArrayList<>();
		
		String sqlSoLuongMon = "select tennhanvien, count(mahoadon) as sohoadon, sum(tongtien) as doanhthu "
								+ " from hoadon "
								+ " where dathanhtoan = 1 and thoigian between ?1 and ?2 "
								+ " group by tennhanvien";
		
		Query querySoLuongMon= entityManager.createNativeQuery(sqlSoLuongMon);
		querySoLuongMon.setParameter(1, fromDate);
		querySoLuongMon.setParameter(2, toDate);
		
		querySoLuongMon.getResultStream().forEach((record) -> {
			Map<String, Object> recordResult = new HashMap<>();
			recordResult.put("tenNhanVien", ((Object[]) record)[0]);
			recordResult.put("soHoaDon", ((Object[]) record)[1]);
			recordResult.put("doanhThu", ((Object[]) record)[2]);
			
			result.add(recordResult);
		});
		
	
		return result;
	}
}
