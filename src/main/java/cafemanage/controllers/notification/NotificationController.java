package cafemanage.controllers.notification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NotificationController {
	public static String id = "";
	
	@GetMapping(path = "/page")
    public String showPage() {
        return "index";
    }
	
	
	@MessageMapping("/notification")
  	@SendTo("/notification/ping")
  	public String ping(StompHeaderAccessor stompHeaderAccessor) throws Exception {
		System.out.println(stompHeaderAccessor.getSessionId());
		id = stompHeaderAccessor.getSessionId();
//		TinNhan tinNhan = new TinNhan();
//		tinNhan.setNguoiGui("xxx");
//		tinNhan.setNguoiNhan("xxxxddd");
//		tinNhan.setThoiGianGui(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		return "Pong";
  	}

}
