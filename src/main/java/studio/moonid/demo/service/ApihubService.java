package studio.moonid.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ApihubService {

    public ResponseEntity getData(String reqBody){

        try {
            // extract req body(json)
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode reqBodyNode = objectMapper.readTree(reqBody);
            String type = reqBodyNode.at("/directiveOptions/getInfo").findValue("type").asText();
            String taskId = reqBodyNode.findValue("taskId").asText();
            log.info("type: " + type);
            log.info("taskId: " + taskId);

            // Call TP case by type
            ResponseEntity responseEntity = null;
            switch (type) {
                case "SWING_API_ISSWG00377":
                    responseEntity = ISSWG00377();
                    break;
                default:
                    log.info("Unknown TP");
                    break;
            }

            return responseEntity;

        }catch (Exception ex){
            log.error(ex.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity ISSWG00377() {

        // 전처리

        // TP 호출
        String url = "http://sktaic.ddns.net/api/users?page=2";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//        Object[] objects = restTemplate.getForEntity(url, Object[].class);
//        Object[] objects = responseEntity.getBody();
//        MediaType contentType = responseEntity.getHeaders().getContentType();
//        HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();D

//        Object[] objects = restTemplate.getForObject(url, Object[].class);

        // 후처리
        return responseEntity;
    }
}
