package cafemanage.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.DoanhSo;
import cafemanage.services.ThongKeService;

@RestController
public class ThongKe {
	@Autowired
	private ThongKeService thongKeService;
	
	@GetMapping("/api/admin/thongke/{nam}")
	public List<DoanhSo> thongKeDoanhThu(@PathVariable("nam") Integer nam){
		
		return thongKeService.thongKe(nam);
	}
}
