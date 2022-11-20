package com.ruoyi.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileUploadUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUploadUtil.class);

    /***
     * 通用文件上传
     * @param request
     * @param fileName 文件名称
     * @param savePath 保存路径
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public static Map<String, Object> uploadFile(HttpServletRequest request, String fileName, String savePath) throws IllegalStateException, IOException {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        if (null != request) {
            String myFileName = null;
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        //获取源文件名称
                        resultMap.put("sourceFileName", myFileName);
                        // 获取后缀
                        String suffix = myFileName.substring(myFileName
                                .lastIndexOf("."));
                        // 重命名上传后的文件名
                        fileName = StringUtils.get32UUID() + suffix;
                        // 定义上传路径,保存在项目所在的tomcat中
                        File filepath = new File(savePath);
                        if (!filepath.exists()) {
                            filepath.mkdirs();
                        }
                        File localFile = new File(filepath, myFileName);
                        // 上传
                        file.transferTo(localFile);
                        //获取文件md5
                        resultMap.put("fileMd5", CustomStringUtil.getMd5(localFile));
                        //获取文件路径
                        resultMap.put("filePath", localFile.getPath());
                        //文件名
                        resultMap.put("fileName", myFileName);
                        //文件类型
                        resultMap.put("type",fileType(suffix));
                    }
                }
            }
        } else {
            resultMap.put("result", false);
            resultMap.put("msg", "上传文件类型错误");
            return resultMap;
        }
        resultMap.put("result", true);
        resultMap.put("msg", "上传文件成功");
        return resultMap;
    }

    private static int fileType(String suffix) {
        if (suffix.equalsIgnoreCase(".jpg") || suffix.equalsIgnoreCase(".png") ||
                suffix.equalsIgnoreCase(".jpeg") || suffix.equalsIgnoreCase(".jfif") ||
                suffix.equalsIgnoreCase(".gif")) {
            log.info("当前上传的是图片文件："+suffix);
            return 1;
        } else if (suffix.equalsIgnoreCase("avi") || suffix.equalsIgnoreCase("MOV") ||
                suffix.equalsIgnoreCase("mp4")) {
            log.info("当前上传的是视频文件："+suffix);
            return 2;
        }
        log.info("当前上传的是其他文件："+suffix);
        return 3;
    }
}
