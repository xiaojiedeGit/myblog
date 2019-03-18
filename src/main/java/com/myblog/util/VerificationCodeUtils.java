package com.myblog.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * 验证码生成类
 * 
 * @author Administrator
 *
 */
public class VerificationCodeUtils {

	// 设置默认验证码字符
	public static final String VERIFY_CODE = "23456789ABCDERGHJKLMNPQRSTUVWSYZ";
	private static Random random = new Random();

	// 验证图背景颜色
	private static Color bgColor = new Color(255, 255, 255);

	private static int width=140;

	private static int height=28;

	public static Map<String, Object> createImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

		Graphics2D graphics2d = (Graphics2D) image.getGraphics();
		graphics2d.setColor(bgColor);
		graphics2d.fillRect(0, 0, width, height);
		 // 画十条干扰线
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics2d.setColor(getRandomColor());
            graphics2d.drawLine(x1, y1, x2, y2);
        }
        String verificationCode=generateVerifyCode(4);
        
        // 设置字体，画验证码
        graphics2d.setColor(getRandomColor());
        //graphics2d.setFont(randomFont());
        graphics2d.setFont(randomFont());
        graphics2d.drawString(verificationCode, 10, 24);
        // 图像生效
        graphics2d.dispose();
        
        // 图片和验证码
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("verificationCode", verificationCode);
        map.put("image", image);
        
        
		return map;
	}

	/**
	 * 使用默认的验证码字符源
	 * 
	 * @param verifySize 验证码长度
	 * @return
	 */
	public static String generateVerifyCode(int verifySize) {

		return generateVerifyCode(verifySize, VERIFY_CODE);
	}

	/**
	 * 使用指定验证码字符生成验证码
	 * 
	 * @param verifySize 验证码长度
	 * @param source     验证码字符源
	 * @return
	 */
	public static String generateVerifyCode(int verifySize, String source) {
		if (source == null || source.length() == 0) {
			source = VERIFY_CODE;
		}

		int codesLen = source.length();
		Random ran = new Random(System.currentTimeMillis());
		StringBuilder verifyCode = new StringBuilder(verifySize);

		for (int i = 0; i < verifySize; i++) {
			verifyCode.append(source.charAt(ran.nextInt(codesLen - 1)));
		}

		return verifyCode.toString();
	}

	/**
	 * 获取到一个随机的颜色
	 * 
	 * @return
	 */
	private static Color getRandomColor() {

		return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

	}
	
	/**
	 * 随机生成字体
	 * @return
	 */
    private static Font randomFont() {
        int style = random.nextInt(4);
        int size = random.nextInt(3) + 26; // 生成随机字号, 26 ~ 30
        return new Font("宋体", style, size);
    }

}
