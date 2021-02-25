package cafemanage.controllers.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.MonAn;
import cafemanage.services.MonAnService;

@RestController
public class MonAnController {
	@Autowired
	private MonAnService monAnService;
	
	@GetMapping(path = "/api/staff/monan")
	public List<MonAn> getAllMonAn(@RequestParam(name = "loaimon", defaultValue = "-1") Integer idLoaiMon) {
		if(idLoaiMon == -1) {
			return monAnService.getListMonAn();			
		}else {
			return monAnService.getMonAnByLoaiMon(idLoaiMon);
		}
	}
}
