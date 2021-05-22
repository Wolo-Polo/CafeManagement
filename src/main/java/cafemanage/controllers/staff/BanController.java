package cafemanage.controllers.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafemanage.controllers.notification.NotificationController;
import cafemanage.services.BanService;

@RestController
public class BanController {
	@Autowired
	private BanService banService;
	
	@Autowired
	private SimpMessagingTemplate template; 
	
	@RequestMapping(path = "api/staff/ban/{id}", method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<?> setupBan(@PathVariable(name = "id") Integer id, @RequestParam(name = "tinhtrang", defaultValue = "blank") String tinhtrang) {
		template.setUserDestinationPrefix("/app");
		template.convertAndSend("/notification/ping", "id: " + id + ", tinhTrang: " + tinhtrang);
		
		
		boolean status = banService.bookBan(id, tinhtrang);
		if(status) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
