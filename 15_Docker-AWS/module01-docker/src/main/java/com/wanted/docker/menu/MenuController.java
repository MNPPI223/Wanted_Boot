package com.wanted.docker.menu;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    // 생성자가 하나만 있을 경우 @Autowired 를 사용하지 않아도 된다!
    public MenuController(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // Docker Local 배포 시 Spring Container 와
    // MySQL Container 연동 확인을 위한 HandlerMethod
    // Docker Network 동작 확인용
    @GetMapping("/menus")
    public List<Menu> findAllMenus() {

        return menuRepository.findAll();

    }

}


