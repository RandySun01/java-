package cn.edu.hnnu.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * 
 * @author sunrongzhi
 *
 */
public class CreateQRCode {
	public static void main(String[] args) throws IOException{
		Qrcode x=new Qrcode();
		// 纠错等级
		x.setQrcodeErrorCorrect('M');
		// N代表数字， A代表a-Z， B代表其他字符
		x.setQrcodeEncodeMode('B');
		// 版本
		x.setQrcodeVersion(7);
	    // 内容
		String qrData = "RandySun";
		int width = 67 + 12 * ( 7 -1 );
		int height = 67 + 12 * ( 7 -1 );
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		// 画图工具
		Graphics2D gs = bufferedImage.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.setColor(Color.BLACK);
		// 清除画板内容
		gs.clearRect(0, 0, width, height);
		// 偏移量
		int pixOff = 2;
		byte[] d =qrData.getBytes("gb2312");
		if (d.length>0 && d.length <120){
		    boolean[][] s = x.calQrcode(d);

		    for (int i=0;i<s.length;i++){
				for (int j=0;j<s.length;j++){
				    if (s[j][i]) {
				    	// 填充
				    	gs.fillRect(j * 3 + pixOff,i * 3 + pixOff,3,3);
				    }
				}
		    }
		}
		
		gs.dispose();
		bufferedImage.flush();
		// 输出
		ImageIO.write(bufferedImage, "png", new File("d:/qrcode.png"));
		System.out.println("成功");
	}

}
