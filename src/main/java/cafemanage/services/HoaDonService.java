package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.HoaDon;
import cafemanage.repositories.HoaDonReps;

@Service
public class HoaDonService {
	@Autowired
	private HoaDonReps hoaDonReps;
	
	public List<HoaDon> getListHoaDon(){
		return hoaDonReps.findAll();
	}
	
	public HoaDon getHoaDonById(String id){
		return hoaDonReps.findById(id).get();
	}
	
	public HoaDon addHoaDon(HoaDon hoaDon) {
		return hoaDonReps.save(hoaDon);
	}
	
	public HoaDon editHoaDon(HoaDon hoaDon) {
		return hoaDonReps.save(hoaDon);
	}
	
	public HoaDon saveHoaDon(HoaDon hoaDon) {
		return hoaDonReps.save(hoaDon);
	}
	
	public boolean deleteHoaDon(String id) {
		hoaDonReps.deleteById(id);
		return true;
	}
}
