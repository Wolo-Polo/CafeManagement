package cafemanage.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.dao.ThongKeDao;
import cafemanage.entities.DoanhSo;
import cafemanage.repositories.ThongKeReps;

@Service
public class ThongKeService {
	@Autowired
	private ThongKeReps thongKeReps;
	
	@Autowired
	private ThongKeDao thongKeDao;
	
	public List<DoanhSo> thongKe(Integer nam){
		List<DoanhSo> ds = thongKeReps.thongKe(nam);
		return ds;
	}
	
	public DoanhSo thongKe(String fromDate, String toDate){
		DoanhSo ds = thongKeReps.thongKe(fromDate, toDate);
		return ds;
	}
	
	public Map<String, Object> thongKeTatCa(String fromDate, String toDate) {
		Map<String, Object> result = new HashMap<>();
		
		result.put("from", fromDate);
		result.put("to", toDate);
		
		List<Map<String, Object>> thongKeSoLuongMon = thongKeDao.thongKeSoLuongMoiMon(fromDate, toDate);
		result.put("soLuongMon", thongKeSoLuongMon);
		
		List<Map<String, Object>> thongKeDoanhSoCuaNhanVien = thongKeDao.thongKeDoanhSoCuaNhanVien(fromDate, toDate);
		result.put("doanhSoCuaNhanVien", thongKeSoLuongMon);
		
		return result;
	}
}
