package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.ChiTietHoaDon;
import cafemanage.repositories.ChiTietHoaDonReps;

@Service
public class ChiTietHoaDonService {
	@Autowired
	private ChiTietHoaDonReps chiTietHoaDonReps;
	
	public List<ChiTietHoaDon> getListChiTietHoaDon(){
		return chiTietHoaDonReps.findAll();
	}
	
	public ChiTietHoaDon getChiTietHoaDonById(Integer id){
		return chiTietHoaDonReps.findById(id).get();
	}
	
	public ChiTietHoaDon addChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonReps.save(chiTietHoaDon);
	}
	
	public ChiTietHoaDon editChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		return chiTietHoaDonReps.save(chiTietHoaDon);
	}
	
	public boolean deleteChiTietHoaDon(Integer id) {
		chiTietHoaDonReps.deleteById(id);
		return true;
	}
}
