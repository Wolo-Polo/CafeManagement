package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.LoaiMon;
import cafemanage.repositories.LoaiMonReps;

@Service
public class LoaiMonService {
	@Autowired
	private LoaiMonReps loaiMonReps;
	
	public List<LoaiMon> getListLoaiMon(){
		return loaiMonReps.findAll();
	}
	
	public LoaiMon getLoaiMonById(String id){
		return loaiMonReps.findById(id).get();
	}
	
	public LoaiMon addLoaiMon(LoaiMon loaiMon) {
		return loaiMonReps.save(loaiMon);
	}
	
	public LoaiMon editLoaiMon(LoaiMon loaiMon) {
		return loaiMonReps.save(loaiMon);
	}
	
	public boolean deleteLoaiMon(String id) {
		loaiMonReps.deleteById(id);
		return true;
	}
}
