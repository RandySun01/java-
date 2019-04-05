package cn.edu.hnnu.zxing;
 
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
/**
 * 
 * @author sunrongzhi
 * 生成二维码
 *
 *
 */
public class CreateQRcode {
	public static void main(String[] args){
		// 设置图片的大小，图片的格式， 图片内容
		int weidth = 300;
		int heigth = 300;
		String format = "png";
		String content = "RandySun\n2214644978@qq.com";
		String VCard = "BEGIN:VCARD"+"\n"
						+ "VERSION:2.1" + "\n"
						+ "N:姓;名" + "\n"
						+ "FN:姓名" + "\n"
						+ "ORG:公司; 部门" + "\n"
						+ "TITLE:职位" + "\n"
						+ "TEL;WORK;VOICE:电话1" + "\n"
						+ "TEL;HOME;VOICE:电话2" + "\n"
						+ "ADR;WORK:;;单位地址;安徽;淮南;30314;中国" + "\n"
						+ "LABEL;WORK;ENCODING=QUOTED-PRINTABLE:100 Waters Edge=0D=0ABaytown, LA 30314=0D=0AUnited States of America" + "\n"
						+ "ADR;HOME:;;街道地址;安徽;淮南;30314;中国" + "\n"						
						+ "EMAIL;PREF;INTERNET:邮箱地址" + "\n"
						+ "REV:20080424T195243Z" + "\n"
						+"END:VCARD";
		/**
		 * 定义二维码参数
		 */
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符集
	    // 指定二维码等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		// 设置图片的边距
		hints.put(EncodeHintType.MARGIN, 2);
		
		try {
			// 生成二维码
			BitMatrix bitMatrix  = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, weidth, heigth, hints);
			// 路径
			Path file = new File("d:/code.png").toPath();
			// 生成二维码
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
			System.out.println("二维码生成成功");
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
