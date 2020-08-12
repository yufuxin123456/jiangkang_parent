package com.czxy.jk.controller;

import com.czxy.jk.BaseResult;
import com.czxy.jk.login.Login;
import com.czxy.jk.login.LoginApi;
import com.czxy.jk.service.LoginService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController implements LoginApi {

    @Resource
    private LoginService loginService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    @Override
    public BaseResult login( @RequestBody Login login) {
        System.out.println("登录数据:" + login);
        System.out.println("验证码校验:" + login.getVerifyCode());
        String redisCode = stringRedisTemplate.opsForValue().get("login" + login.getUsername());
        stringRedisTemplate.delete("login" + login.getUsername());
        try {
            if (login.getVerifyCode().equalsIgnoreCase(redisCode)) {

                Login l = loginService.login(login);
                if (login != null) {

                    return BaseResult.ok("登录成功", l);
                } else {
                    return BaseResult.error("验证码或密码错误");

                }
            } else {
                return BaseResult.error("验证码或密码错误");
            }
        } catch (Exception e) {
            return BaseResult.error("验证码或密码错误");
        }

    }

    @Override
    @GetMapping("/verifycode")
    public void verifycode(String username, HttpServletResponse response) throws IOException {
        System.out.println("-*/-*/-*/-*/" + username);
        if (username != null) {
            //字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
            String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

            int IMG_WIDTH = 72;
            int IMG_HEIGTH = 27;
            Random random = new Random();
            //创建图片
            BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);
            //画板
            Graphics g = image.getGraphics();
            //填充背景
            g.setColor(Color.WHITE);
            g.fillRect(1, 1, IMG_WIDTH - 2, IMG_HEIGTH - 2);

            g.setFont(new Font("楷体", Font.BOLD, 25));

            StringBuilder sb = new StringBuilder();
            //写字
            for (int i = 1; i <= 4; i++) {
                //随机颜色
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                int len = random.nextInt(VERIFY_CODES.length());
                String str = VERIFY_CODES.substring(len, len + 1);
                sb.append(str);
                g.drawString(str, IMG_WIDTH / 6 * i, 22);
            }
            //将验证码存放到redis
            stringRedisTemplate.opsForValue().set("login" + username, sb.toString(), 1, TimeUnit.HOURS);
            System.out.println("验证码code:       " + sb.toString());

            // 生成随机干扰线
            for (int i = 0; i < 30; i++) {
                //随机颜色
                g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                int x = random.nextInt(IMG_WIDTH - 1);
                int y = random.nextInt(IMG_HEIGTH - 1);
                int x1 = random.nextInt(12) + 1;
                int y1 = random.nextInt(6) + 1;
                g.drawLine(x, y, x - x1, y - y1);
            }
            //响应到浏览器
            ImageIO.write(image, "jpeg", response.getOutputStream());
        }
    }

}
