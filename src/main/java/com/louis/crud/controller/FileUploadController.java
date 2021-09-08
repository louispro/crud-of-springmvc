package com.louis.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @赖小燚
 * @www.louis_lai.com
 */
@Controller
public class FileUploadController {

    /**
     * 前往文件上传界面
     * @return
     */
    @RequestMapping("/toUpload")
    public String toUploadPage(){
        return "upload";
    }

    /**
     * 单文件上传
     * @param username
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/uploadFile")
    public String upload(@RequestParam(value="username",required = false) String username, @RequestParam("headerimg") MultipartFile file, Model model){

        System.out.println("上传文件的信息");
        System.out.println("文件名:"+file.getName());
        System.out.println("文件的名字:"+file.getOriginalFilename());
        //保存文件
        try{
            file.transferTo(new File("D:\\Codes\\JavaCode\\SpringMVCCRUDFix\\src\\main\\webapp\\upload\\"+file.getOriginalFilename()));
            model.addAttribute("msg","文件上传成功");
        } catch (IOException e) {
            model.addAttribute("msg","文件上传失败");
        }
        return "upload";
    }

    /**
     * 多文件上传
     * @return
     */
    @RequestMapping("/uploadFiles")
    public String upload(@RequestParam("img")MultipartFile[] file,Model model){
        System.out.println("上传文件的信息");
        try{
            for (MultipartFile multipartFile : file) {
                if(multipartFile.isEmpty()==false){
                    multipartFile.transferTo(new File("D:\\Codes\\JavaCode\\SpringMVCCRUDFix\\src\\main\\webapp\\upload\\"+multipartFile.getOriginalFilename()));
                    model.addAttribute("msg",multipartFile.getOriginalFilename()+"上传成功");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("msg","文件上传失败");
        }
        return "upload";
    }

}
