package cafemanage.controllers.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.services.BanService;

@RestController
public class BanController {
	@Autowired
	private BanService banService;
	
	@RequestMapping(path = "api/staff/ban/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> setupBan(@PathVariable(name = "id") String id, @RequestParam(name = "tinhtrang", defaultValue = "blank") String tinhtrang) {
		boolean status = banService.bookBan(id, tinhtrang);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
