package cn.edu.hnnu.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
/**
 * 
 * @author sunrongzhi
 *
 */
public class ReadQRCode {
	public static void main(String[] args) throws Exception{
		// 读取文件
		File file = new File("d:/qrcode.png");
		// 读取文件
		BufferedImage bufferedImage =  ImageIO.read(file);
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		String result = new String(codeDecoder.decode( new MYQRCodeImage(bufferedImage)),"gb2312");
		System.out.println(result);
	}

}
