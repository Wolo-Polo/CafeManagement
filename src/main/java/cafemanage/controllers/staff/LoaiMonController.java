package cafemanage.controllers.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.LoaiMon;
import cafemanage.services.LoaiMonService;

@RestController
public class LoaiMonController {
	@Autowired
	private LoaiMonService loaiMonService;
	
	@GetMapping(path = "/api/staff/loaimon")
	public List<LoaiMon> getAllMonAn() {
		return loaiMonService.getListLoaiMon();
	}
}
