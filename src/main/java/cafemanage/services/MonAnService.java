package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.LoaiMon;
import cafemanage.entities.MonAn;
import cafemanage.repositories.MonAnReps;

@Service
public class MonAnService {
	@Autowired
	private MonAnReps monAnReps;
	
	public List<MonAn> getListMonAn(){
		return monAnReps.findAll();
	}
	
	public MonAn getMonAnById(Integer id){
		return monAnReps.findById(id).get();
	}
	public List<MonAn> getMonAnByLoaiMon(Integer idLoaiMon) {
		LoaiMon loaiMon = new LoaiMon();
		loaiMon.setMaLoaiMon(idLoaiMon);
		return monAnReps.findByLoaiMon(loaiMon);
	}
	
	public MonAn addMonAn(MonAn monAn) {
		return monAnReps.save(monAn);
	}
	
	public MonAn editMonAn(MonAn monAn) {
		return monAnReps.save(monAn);
	}
	
	public boolean deleteMonAn(Integer id) {
		monAnReps.deleteById(id);
		return true;
	}
}
