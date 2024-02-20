package com.example.appdo.random;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImageZipUtil {
    public static void main(String[] args) {
        zipWidthHeightImageFile(new File("D:\\image\\1.png"),new File("D:\\image\\3-3.png"),638,425,0.7f);
//        scaleImage("D:\\image\\1.jpg","D:\\image\\3-4.jpg",0.5,"jpg");
        //zipImageFile(new File("C:\\spider\\2.JPG"),new File("C:\\spider\\2-2.JPG"),425,638,0.7f);
        //zipImageFile(new File("C:\\spider\\3.jpg"),new File("C:\\spider\\3-3.jpg"),425,638,0.7f);
        System.out.println("ok");
    }
    /**
     * 根据设置的宽高等比例压缩图片文件<br> 先保存原文件，再压缩、上传
     * @param oldFile 要进行压缩的文件
     * @param newFile 新文件
     * @param width 宽度 //设置宽度时（高度传入0，等比例缩放）
     * @param height 高度 //设置高度时（宽度传入0，等比例缩放）
     * @param quality 质量
     * @return 返回压缩后的文件的全路径
     */
    public static String zipImageFile(File oldFile,File newFile, int width, int height,float quality) {
        if (oldFile == null) {
            return null;
        }
        try {
            /** 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);
            int w = srcFile.getWidth(null);
            int h = srcFile.getHeight(null);
            double bili;
            if(width>0){
                bili=width/(double)w;
                height = (int) (h*bili);
            }else{
                if(height>0){
                    bili=height/(double)h;
                    width = (int) (w*bili);
                }
            }
            String srcImgPath = newFile.getAbsoluteFile().toString();
//            System.out.println(srcImgPath);
            String subfix = "jpg";
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());
            BufferedImage buffImg = null;
            if(subfix.equals("png")){
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            }else{
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }
            Graphics2D graphics = buffImg.createGraphics();
            graphics.setBackground(new Color(255,255,255));
            graphics.setColor(new Color(255,255,255));
            graphics.fillRect(0, 0, width, height);
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            ImageIO.write(buffImg, subfix, new File(srcImgPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile.getAbsolutePath();
    }
    /**
     * 按设置的宽度高度压缩图片文件<br> 先保存原文件，再压缩、上传
     * @param oldFile 要进行压缩的文件全路径
     * @param newFile 新文件
     * @param width 宽度
     * @param height 高度
     * @param quality 质量
     * @return 返回压缩后的文件的全路径
     */
    public static String zipWidthHeightImageFile(File oldFile,File newFile, int width, int height,float quality) {
        if (oldFile == null) {
            return null;
        }
        String newImage = null;
        try {
            /** 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);
            String srcImgPath = newFile.getAbsoluteFile().toString();
//            System.out.println(srcImgPath);
            String subfix = "png";
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".")+1,srcImgPath.length());
            BufferedImage buffImg = null;
            if(subfix.equals("png")){
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            }else{
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }
            Graphics2D graphics = buffImg.createGraphics();
            graphics.setBackground(new Color(255,255,255));
            graphics.setColor(new Color(255,255,255));
            graphics.fillRect(0, 0, width, height);
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
            ImageIO.write(buffImg, subfix, new File(srcImgPath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newImage;
    }

    /**
     * 按指定比例缩放图片
     * @param sourceImagePath  源地址
     * @param destinationPath  输出地址
     * @param scale  缩放比例 0.5原图的一半
     * @param format 图片后缀名  jpg
     */
    public static void scaleImage(String sourceImagePath,String destinationPath, double scale,String format) {
        File file = new File(sourceImagePath);
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            width = parseDoubleToInt(width * scale);
            height = parseDoubleToInt(height * scale);
            Image image = bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            ImageIO.write(outputImage, format, new File(destinationPath)); }
        catch (Exception e) {
            System.out.println("scaleImage方法压缩图片时出错了"+e.getMessage());
            e.printStackTrace();}
    }

    private static int parseDoubleToInt(double sourceDouble) {
        int result = 0;
        result = (int) sourceDouble;
        return result;
    }

}