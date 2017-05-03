package com.chuanchen.controller;

import com.chuanchen.entity.TopAlumnus;
import com.chuanchen.service.TopAlumnusService;
import com.chuanchen.service.UserService;
import com.mysql.cj.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
@Controller
@RequestMapping("/topAlumnus")
@PropertySource("classpath:variables.properties")
public class TopAlumnusController {
    @Autowired
    TopAlumnusService topAlumnusService;
    @Autowired
    Environment environment;

    @RequestMapping(value = "/addTopAlumnusPage", method = RequestMethod.GET)
    public String addTopAlumnusPage(HttpSession session, Model model) {
        return "add_top_xiaoyou";
    }

    @RequestMapping(value = "uploadTopAlumnus", method = RequestMethod.POST)
    public String uploadTopAlumnus(@RequestParam("name") String name, @RequestPart("avatar") MultipartFile avatar, @RequestParam("description") String description, Model model, HttpServletRequest request) {
        TopAlumnus topAlumnus = new TopAlumnus();
        topAlumnus.setName(name);
        topAlumnus.setDescription(description);
        topAlumnus.setUploadDate(new Date());
        topAlumnus.setAvatar(saveTopAvatar(avatar, request));
        if (topAlumnusService.uploadTopAlumnus(topAlumnus)) {
            model.addAttribute("uploadResult","true");
            return "add_top_xiaoyou";
        } else {
            model.addAttribute("uploadResult",false);
            return "add_top_xiaoyou";
        }
    }

    @RequestMapping(value = "/findTopAlumnus", method = RequestMethod.GET)
    public String findTopAlumnus() {
        return "xiaoyou_photos";
    }

    private String saveTopAvatar(MultipartFile image, HttpServletRequest request) {
        if (image.getName() != null && !image.getName().equals("") && image.getSize() > 0) {
            String basePath = request.getSession().getServletContext().getRealPath(environment.getProperty("topAvatarsDir"));
            File file = new File(basePath, image.getOriginalFilename());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                image.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }
}
