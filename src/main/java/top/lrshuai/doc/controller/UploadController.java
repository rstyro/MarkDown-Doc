package top.lrshuai.doc.controller;

import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import top.lrshuai.doc.util.ImgUtil;
import top.lrshuai.doc.util.Tools;

@Controller
@CrossOrigin
@RequestMapping("/upload")
public class UploadController {

	private Logger log = Logger.getLogger(this.getClass());
	
	private final ResourceLoader resourceLoader;  
	
	@Value("${upload.root.folder}")
	public String root_fold;
	
	@Value("${img.folder}")
	public String img_fold;
	
	@Value("${user.folder}")
	public String user_folder;
	
	
    @Autowired 
    public UploadController(ResourceLoader resourceLoader) {  
        this.resourceLoader = resourceLoader;  
    }  
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @param file
	 */
	@RequestMapping(value="/uploadImg",method=RequestMethod.POST)
	public void uploadImg(HttpServletRequest request,HttpServletResponse response,@RequestParam(value = "editormd-image-file", required = false) MultipartFile file){
		try {
			String filePath = "/images/"+Tools.random(5)+".png";
			String resultPath = ImgUtil.uploadImg(root_fold, filePath, file.getInputStream());
			response.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"" + resultPath + "\"}" );
		} catch (Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write( "{\"success\": 0, \"message\":\"上传失败\",\"url\":\""+ "\"}" );
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
     * 显示上传根目录的图片或文件
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(root_fold, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    /**
     * 获取图片
     * @param folderName
     * @param date
     * @param filename
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{folderName}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<?> getResource(@PathVariable("folderName") String folderName,@PathVariable("filename") String filename) {
    	try {
    		return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(root_fold+"/"+folderName, filename).toString()));
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }
}
