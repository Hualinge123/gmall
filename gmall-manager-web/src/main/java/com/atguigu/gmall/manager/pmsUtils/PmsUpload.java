package com.atguigu.gmall.manager.pmsUtils;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUpload {

    public static String fileUpload(MultipartFile multipartFile){
        String urlImage="http://192.168.245.200/";
        try {
            String tracker = null;
            try {
                tracker = PmsUpload.class.getResource("/tracker.conf").getPath();
            } catch (Exception e) {
                e.printStackTrace();
            }

            ClientGlobal.init(tracker);

            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();

            StorageClient storageClient = new StorageClient(trackerServer, null);

            byte[] bytes = multipartFile.getBytes();

            String fileName=multipartFile.getOriginalFilename();

            int index=fileName.lastIndexOf(".");;
            String substring= fileName.substring(index+1);

            String[] upload_file = storageClient.upload_file(bytes, substring, null);

            for(String file:upload_file){
                System.out.println(file);
                urlImage+=file;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return urlImage;


    }
}
