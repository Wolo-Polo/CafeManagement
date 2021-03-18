package cafemanage.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cafemanage.entities.DoanhSo;
import cafemanage.repositories.ThongKeReps;

@Service
public class ThongKeService {
	@Autowired
	private ThongKeReps thongKeReps;
	
	public List<DoanhSo> thongKe(Integer nam){
		List<DoanhSo> ds = thongKeReps.thongKe(nam);
		return ds;
	}
}
