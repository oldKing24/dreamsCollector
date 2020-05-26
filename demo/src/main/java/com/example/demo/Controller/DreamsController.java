package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.IMiniDreamsService;
import com.example.demo.utils.RestResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/mini/dreams")
public class DreamsController {
    private Logger logger = Logger.getLogger(DreamsController.class);
    @Autowired
    private IMiniDreamsService miniDreamsService;

    @ResponseBody
    @RequestMapping(value="/addUserInfo" ,method = RequestMethod.GET)
    public RestResponse ajaxAddUser(MiniUserInfo userInfo){
        try{
            Map<String,String> map = new HashMap<>();
            map.put("openId",userInfo.getOpenId());
            MiniUserInfo historyUser = miniDreamsService.ajaxSearchUserInfo(map);
            if(historyUser!=null){
                userInfo.setId(historyUser.getId());
                userInfo.setUpdateTime(new Date());
                miniDreamsService.ajaxUpdateUserInfo(userInfo);
            }else{
                userInfo.setId(UUID.randomUUID().toString());
                userInfo.setCreateTime(new Date());
                miniDreamsService.ajaxAddUserInfo(userInfo);
            }
            return RestResponse.success();
        }catch(Exception e){
            return RestResponse.failure("新增失败，请重试");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getTags",method = RequestMethod.GET)
    public RestResponse getAllTag(){
        List<MiniDreamsTag> tagList = new ArrayList<>();
        try{
            tagList = miniDreamsService.getAllTags();
            return RestResponse.success("0",tagList);
        }catch (Exception e){
            return RestResponse.failure("查询失败");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/addDreams",method = RequestMethod.GET)
    public RestResponse ajaxAddDreams(MiniDreamsInfo dreamsInfo){
        try{
            dreamsInfo.setId(UUID.randomUUID().toString());
            dreamsInfo.setCreateTime(new Date());
            miniDreamsService.ajaxAddDreams(dreamsInfo);
            return RestResponse.success();
        }catch (Exception e){
            return RestResponse.failure("-1","新增失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getDreamsPages",method = RequestMethod.GET)
    public RestResponse ajaxGetDreamsPages(Integer pagerSize,Integer currentPage,String keyWord,String openId){
        try{
            List<MiniDreanListEntity> list = miniDreamsService.ajaxGetDreamsPager(pagerSize,currentPage,keyWord,openId);
            return RestResponse.success("0",list);
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getDreamDetail",method = RequestMethod.GET)
    public RestResponse getDreamDetail(String id){
        try{
            Map<String,Object> map = new HashMap<>();
            map.put("id",id);
            MiniDreanListEntity detail = miniDreamsService.getDreamDetail(map);
            return RestResponse.success("0",detail);
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addComments",method = RequestMethod.GET)
    public RestResponse addComment(MiniDreamsComments comments){
        try{
            comments.setId(UUID.randomUUID().toString());
            comments.setCreateTime(new Date());
            miniDreamsService.addComments(comments);
            return RestResponse.success();
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getComments",method = RequestMethod.GET)
    public RestResponse getComments(String id){
        try{
            Map map = new HashMap();
            map.put("id",id);
            List<MiniDreamsCommentsEntity> comments = miniDreamsService.getComments(map);
            return RestResponse.success("0",comments);
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }

    /**
     * @createtime 2017年8月20日17:15:41
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/upload")
    public RestResponse upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        String path = null;
        logger.error("执行图片上传");
        String user = request.getParameter("user");
        logger.error("user:"+user);
        if(!file.isEmpty()) {
            logger.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            logger.error("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                logger.error(type.toUpperCase());
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
//                    String realPath = "e:";
                    String realPath = ClassUtils.getDefaultClassLoader().getResource("static/upload").getPath();
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath  + trueFileName;
                    logger.error("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    logger.error("文件成功上传到指定目录下");
                }else {
                    logger.error("不是我们想要的文件类型,请按要求重新上传");
                    return RestResponse.failure("不是我们想要的文件类型,请按要求重新上传");
                }
            }else {
                logger.error("文件类型为空");
                return RestResponse.failure("文件类型为空");
            }
        }else {
            logger.error("没有找到相对应的文件");
            return RestResponse.failure("没有找到相对应的文件");
        }
        return RestResponse.success(path);
    }

    @ResponseBody
    @RequestMapping(value = "/shoucangDream",method = RequestMethod.POST)
    public RestResponse shoucangDream(MiniDreamsShare dreamsShare){
        try{
            dreamsShare.setId(UUID.randomUUID().toString());
            dreamsShare.setCreateTime(new Date());
            miniDreamsService.insertDreamShare(dreamsShare);
            return RestResponse.success();
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cancelshoucangDream",method = RequestMethod.POST)
    public RestResponse cancelshoucangDream(MiniDreamsShare dreamsShare){
        try{
            miniDreamsService.deleteDreamShare(dreamsShare);
            return RestResponse.success();
        }catch (Exception e){
            return RestResponse.failure("-1",e.getCause());
        }
    }
}
