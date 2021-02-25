package cafemanage.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.ChiTietHoaDon;
import cafemanage.entities.HoaDon;
import cafemanage.services.HoaDonService;

@RestController
public class HoaDonManagement {
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/api/admin/hoadon")
	public List<HoaDon> getListHoaDon(){
		List<HoaDon> result = hoaDonService.getListHoaDon();
		return result;
	}
	@GetMapping("/api/admin/hoadon/{id}")
	public HoaDon getHoaDonById(@PathVariable(name = "id") Integer id){
		return hoaDonService.getHoaDonById(id);
	}
	
	@PostMapping("/api/admin/hoadon")
	public HoaDon addHoaDon(@RequestBody HoaDon hoaDon) {
		List<ChiTietHoaDon> listChiTietHoaDon = hoaDon.getListChiTietHoaDon();
		for(ChiTietHoaDon chiTietHoaDon: listChiTietHoaDon) {
			chiTietHoaDon.setHoaDon(hoaDon);
		}
		return hoaDonService.addHoaDon(hoaDon);
	}
	
	@PutMapping("/api/admin/hoadon")
	public HoaDon editHoaDon(@RequestBody HoaDon hoaDon) {
		return hoaDonService.editHoaDon(hoaDon);
	}
	
	@DeleteMapping("/api/admin/hoadon/{id}")
	public ResponseEntity<?> deleteHoaDon(@PathVariable(name = "id") Integer id) {
		if(hoaDonService.deleteHoaDon(id)) {
			return ResponseEntity.ok().build();			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();	
		}
		
	}
}
