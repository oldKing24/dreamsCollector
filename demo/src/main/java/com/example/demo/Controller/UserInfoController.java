package com.example.demo.Controller;

import com.example.demo.Entity.TbCOVIDInfo;
import com.example.demo.Entity.TbUserInfo;
import com.example.demo.Service.IContactactService;
import com.example.demo.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UserInfoController {
    @Autowired
    private IContactactService contactactService;

    @RequestMapping("/login-page")
    public String login() {
        return "/login-page";
    }

    @RequestMapping("/addAcount-page")
    public String acount() {
        return "/addAcount-page";
    }

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    @ResponseBody
    public RestResponse login(String userId, String password, HttpServletRequest request){
        boolean isExist = false;
        if(StringUtils.isEmpty(userId)){
            return RestResponse.failure("账号为空");
        }
        if(StringUtils.isEmpty(password)){
            return RestResponse.failure("密码为空");
        }
        try{
            isExist = contactactService.checkUserInfo(userId,password);
        }catch(Exception e){
            return RestResponse.failure(e.getMessage(),e.getCause());
        }
        if(isExist){
            request.getSession().setAttribute("user",userId);
            return RestResponse.success();
        }else{
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                request.getSession().removeAttribute("user");
            }
            return RestResponse.failure("用户密码不对应");
        }
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public Map getUser() throws Exception{
        Map<String,Object> map = new HashMap<>();
        TbUserInfo userInfo = contactactService.getUserInfo();
        map.put("1",userInfo);
        return map;
    }

    @RequestMapping(value = "/addUser")
    @ResponseBody
    public RestResponse addUser(TbUserInfo userInfo){
        userInfo.setId(UUID.randomUUID().toString());
        try {
            contactactService.addUserInfo(userInfo);
        }catch (Exception e){
            return RestResponse.failure(e.getMessage());
        }
        return RestResponse.success();
    }

    public void insertInfo(TbCOVIDInfo tbCOVIDInfo) throws Exception{
        contactactService.insertCovidInfo(tbCOVIDInfo);
    }

}
