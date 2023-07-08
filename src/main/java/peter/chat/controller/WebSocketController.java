package peter.chat.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import peter.chat.dto.Message;


@RestController
@RequiredArgsConstructor
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/hello")
    public void message(Message message) throws Exception {
        simpMessagingTemplate.convertAndSend("/sub/channel/"+message.getChannelId(),message);
    }

}