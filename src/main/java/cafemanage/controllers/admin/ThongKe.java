package cafemanage.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/api/admin/thongke")
	public DoanhSo thongKeDoanhThu(@RequestParam("from") String from, @RequestParam("to") String to){
		
		return thongKeService.thongKe(from, to);
	}
	
	@GetMapping("/api/admin/thongke/all")
	public Map<String, Object> thongKe(@RequestParam("from") String from, @RequestParam("to") String to){
		
		return thongKeService.thongKeTatCa(from, to);
	}
}
