package com.fx.modules.qrCode.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author fxiao
 * @date 2019/1/13 15:44
 */
@Controller
@RequestMapping("qrcode")
public class QrCodeController {

    /**
     * 生成一个二维码
     * @param content 二维码内容
     * @param response
     * @return
     */
    @RequestMapping("create")
    public String qrCode(String content, HttpServletResponse response){
        ServletOutputStream out = null;
        response.setContentType("image/png");
        try {
            out=response.getOutputStream();
            Map<EncodeHintType,Object> hints=new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
            hints.put(EncodeHintType.MARGIN,0);
            QRCodeWriter qrCodeWriter=new QRCodeWriter();
            BitMatrix bm = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 1000,1000,hints);
            MatrixToImageWriter.writeToStream(bm,"png",out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }finally{
            if(out!=null){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;
    }

    /**
     * 解析二维码
     * @param imageFile
     * @return
     * @throws IOException
     * @throws NotFoundException
     */
    @PostMapping("analysis")
    @ResponseBody
    public String analysisCode(@RequestParam("imageFile")MultipartFile imageFile) throws IOException, NotFoundException {
        BufferedImage image=ImageIO.read(imageFile.getInputStream());
        if(image==null){
            return "";
        }
        BufferedImageLuminanceSource source=new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(source));
        Hashtable hashtable=new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET,"UTF-8");
        Result result=new MultiFormatReader().decode(bitmap,hashtable);
        return result.getText();
    }
}
