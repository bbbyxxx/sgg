package com.xzy.fruitmall.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/sgg")
public class SendSmsController {
    private Jedis jedis = new Jedis("localhost",6379);
    private String code ="";
    private Integer codeExpireTime = 60;
    @GetMapping("/getyzm/{phoneNumber}")
    public String sendSms(@PathVariable("phoneNumber")String phoneNumber){
        String s2="^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$";// 验证手机号
        if(phoneNumber!=null){
            Pattern p = Pattern.compile(s2);
            Matcher m = p.matcher(phoneNumber);
            boolean b = m.matches();
            if (b==false){
                return "你的电话格式不对！";
            }
        }else{
            return "你的电话格式不对！";
        }
        if (jedis.get(phoneNumber)==null&&jedis.get(code)==null){//说明这个电话从来没有发送过验证码请求了
            DefaultProfile profile = DefaultProfile.getProfile("default",
                    "LTAI4FwC75Pre2xodWFiXB5Y", "G88K88HtKCu0P0jQ2BlKpFcnCF7l7d");
            IAcsClient client = new DefaultAcsClient(profile);

            CommonRequest request = new CommonRequest();
            //request.setProtocol(ProtocolType.HTTPS);
            request.setMethod(MethodType.POST);
            //阿里云对应发送短信的服务器地址
            request.setDomain("dysmsapi.aliyuncs.com");
            //对应的版本号
            request.setVersion("2017-05-25");

            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                cnt = cnt*10 + (int)(Math.random()*10);
            }
            code = cnt+"";

            request.setAction("SendSms");
            //拿到前台输入的电话，并绑定
            request.putQueryParameter("PhoneNumbers", phoneNumber);
            request.putQueryParameter("SignName", "速裹果");
            request.putQueryParameter("TemplateCode","SMS_182537149");
            request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
            CommonResponse response = null;
            try {
                response = client.getCommonResponse(request);
                System.out.println(response.getData());  //相关日志信息
            } catch (ClientException e) {
                e.printStackTrace();
            }
            //设置验证码过期时间
            jedis.setex(phoneNumber,60,phoneNumber);//设置为60s有效
            jedis.setex(code,60,code);

        }else{//说明已经发送过验证码请求了
            if (jedis.get(code)!=null){//说明redis中的键没过期，即验证码没过期,是输入错误了
                return "你的验证码错误了！";
            }else{//验证码过期了 重新申请
                //这里就直接返回上面的if，进行重新获取了
            }
        }


        return code;//给前端返回验证码，让她们来进行判断
    }
}
