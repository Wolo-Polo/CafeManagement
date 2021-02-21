package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.Ban;
import cafemanage.repositories.BanReps;

@Service
public class BanService {
	@Autowired
	private BanReps banReps;
	
	public List<Ban> getListBan(){
		return banReps.findAll();
	}
	
	public Ban getBanById(String id){
		return banReps.findById(id).get();
	}
	
	public Ban addBan(Ban ban) {
		return banReps.save(ban);
	}
	
	public Ban editBan(Ban ban) {
		return banReps.save(ban);
	}
	
	public boolean deleteBan(String id) {
		banReps.deleteById(id);
		return true;
	}
	
	public boolean bookBan(String maBan, String tinhTrang) {
		Ban ban = banReps.findById(maBan).get();
		
		if(tinhTrang.equals("blank")) {
			ban.setTinhTrang("blank");
			banReps.save(ban);
			return true;
		}else {
			if(!ban.getTinhTrang().equals("blank")) {
				return false;
			}else {
				ban.setTinhTrang(tinhTrang);
				banReps.save(ban);
				return true;
			}
		}
	}
}
