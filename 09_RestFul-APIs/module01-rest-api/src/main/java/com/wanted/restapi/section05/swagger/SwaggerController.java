package com.wanted.restapi.section05.swagger;

import com.wanted.restapi.section02.responseentity.ResponseMessage;
import com.wanted.restapi.section02.responseentity.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.*;

@Tag(name="SWAGGER 테스트 컨트롤러", description = "Section05 Swagger 테스트 내용")
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    // DB 역할을 하는 필드 임의 생성
    private List<UserDTO> users;

    public SwaggerController() {
        this.users = new ArrayList<>();
        users.add(new UserDTO(1,"user01","pass01","너구리", new Date()));
        users.add(new UserDTO(2,"user02","pass02","코알라", new Date()));
        users.add(new UserDTO(3,"user03","pass03","여우", new Date()));
        users.add(new UserDTO(4,"user04","pass04","북극곰", new Date()));
    }

    @Operation(summary = "전체 사용자를 조회한다.", description = "모든 사용자 정보를 조회하는 메서드")
    // @ 안에 {} : 여러가지가 들어갈 수 있다라는 뜻임
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema
                    (implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류 발생", content = @Content(schema = @Schema(hidden = true)))
    })
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUser() {

        // 응답 헤더 직접 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // 응답 바디 설정(담을 값)
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!", responseMap);

        return new ResponseEntity<>(responseMessage,headers, HttpStatus.OK);

    }

    @Operation(summary = "특정 사용자 조회", description = "사용자 번호를 통해 사용자 정보를 조회한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema
                    (implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류 발생", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "서버 페이지를 찾을 수 없음", content = @Content(schema = @Schema(hidden = true)))
    })
    @Parameter(name = "userNo", description = "조회할 사용자 번호", required = true)
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .toList()
                .get(0);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", foundUser);

        return ResponseEntity.ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공~~", responseMap));
    }

    @Operation(summary = "신규 유저 등록", description = "새로운 유저를 등록한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema
                    (implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류 발생", content = @Content(schema = @Schema(hidden = true)))
    })
    @PostMapping("/users")

    public ResponseEntity<?> registUser(@RequestBody UserDTO newUser) {

        //JSON 타입으로 요청을 받는다.
        System.out.println("newUser = " + newUser);
        // 현재 users 에서 마지막 4번 회원의 no 값 추출
        int lastUserNo = users.get(users.size() -1).getNo();
        int newUserNo = lastUserNo + 1;

        newUser.setNo(newUserNo);
        newUser.setEnrollAt(new Date());

        users.add(newUser);

        /* comment.
            POST, PUT, DELETE 의 경우는 응답 Body 에 값을 넣을 수도,
            안 넣을 수도 있다.
            이럴 때는 ResponseEntity<?> 와일드 카드를 정의해서 유연하게
            대응하는 것이 좋다.
            1. 리소스를 반환하는 경우
            2. 리소스를 반환하지 않는 경우
         */

        // 1번 리소스를 반환하는 경우
//        return ResponseEntity
//                .created(URI.create("/entity/users/" + newUserNo))
//                .body(newUser);


        // 2번 리소스를 반환하지 않는 경우
        return ResponseEntity
                .created(URI.create("/entity/users/" + newUserNo))
                .build();
    }
    @Operation(summary = "유저 정보 수정", description = "유저의 정보를 수정한다.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema
                    (implementation = ResponseMessage.class))),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류 발생", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = " 유저 정보를 찾을 수 없음", content = @Content(schema = @Schema(hidden = true)))
    })
    @PutMapping("/users/{userNo}")
    public ResponseEntity<?> modifyUser(@RequestBody UserDTO modifyData, @PathVariable int userNo) {

        // 수정 할 1명의 데이터 UserNo 찾아오기
        UserDTO foundUser = users.stream()
                .filter(user -> user.getNo() == userNo)
                .toList()
                .get(0);

        foundUser.setId(modifyData.getId());
        foundUser.setPwd(modifyData.getPwd());
        foundUser.setName(modifyData.getName());

        // 수정도 새로운 리소스가 만들어진 것이다.
        return ResponseEntity
                .created(URI.create("/entity/users/" + userNo))
                .build();
    }


}
