package cafemanage.controllers.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.entities.HoaDon;
import cafemanage.services.HoaDonService;

@RestController
public class HoaDonController {
	@Autowired
	private HoaDonService hoaDonService;
	
	@RequestMapping(path = "/api/staff/hoadon", method = {RequestMethod.POST, RequestMethod.PUT})
	public HoaDon saveHoaDon(@RequestBody HoaDon hoaDon) {
		return hoaDonService.saveHoaDon(hoaDon);
	}
}
