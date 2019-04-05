package cn.edu.hnnu.zxing;


import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ReadQRCode {
	public static void main(String[] args) throws Exception{
		// 读取二维码
		MultiFormatReader formatReader = new MultiFormatReader();
		// 路径
		File file = new File("d:/qrcode.png");
		// 读取文件识别成图片
		BufferedImage image = ImageIO.read(file);
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		// 定义二维码参数
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		
		
		// 解析二维码
		Result result = formatReader.decode(binaryBitmap, hints);
		System.out.println("解析结果: "+result.toString());
		System.out.println("解析格式："+ result.getBarcodeFormat());
		System.out.println("解析文本内容： "+ result.getText());
		
	}

}
