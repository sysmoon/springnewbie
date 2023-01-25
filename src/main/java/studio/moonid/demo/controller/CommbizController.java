package studio.moonid.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import studio.moonid.demo.service.ApihubService;

@Slf4j
@RestController
public class CommbizController {

    @Autowired
    private ApihubService apihubService;

    @PostMapping("/commbiz/v1/ext-command")
    public ResponseEntity commbiz(@RequestBody String reqBody){
        log.info("reqBody:" + reqBody.toString());

        // common request format
        /*
        {
            "taskId": "vcbi",
                "callId": "iawc",
                "timestamp": 1632895914194,
                "requestId": 1234,
                "directive": "GET_INFO",
                "directiveOptions": {
                "getInfo": {
                    "type": "SWING_API_ISSWG00377",
                            "input": {
                        "input_ISSWG00377": {
                            "SVC_NUM": "01036621875"
                        }
                    }
                }
            }
        }
        */

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Get TP data
            ResponseEntity responseEntity = apihubService.getData(reqBody);

            // response
            HttpHeaders headers = responseEntity.getHeaders();
            HttpStatusCode statusCode = responseEntity.getStatusCode();
            Object body = responseEntity.getBody();

            return (responseEntity != null) ?
                    ResponseEntity.status(statusCode)
                            .headers(headers)
                            .body(body) :
                    ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }catch(Exception ex){
            log.error(ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
