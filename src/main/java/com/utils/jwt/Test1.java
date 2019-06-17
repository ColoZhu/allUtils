package com.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {

    public static final String API_SECRET = "123456";
    public static final String API_KEY = "qwerty";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String token = createToken(null);
        System.out.println("下面是token");
        System.out.println(token);

    }

    /**
     * @description 创建token
     * @author Colo.Zhu
     * @time 2018/4/8  14:37
     */
    public static String createToken(Object object) throws UnsupportedEncodingException {

        /**
         * 头部信息
         * 用于描述关于该JWT的最基本的信息，例如其类型以及签名所用的算法等。这也可以被表示成一个JSON对象。
         * 下面的headMap用于存放头部信息
         * */
        Map<String, Object> headMap = new HashMap();  //头部信息
        headMap.put("alg", "HS256");
        headMap.put("typ", "JWT");

        Algorithm algorithm = Algorithm.HMAC256(API_SECRET);    //用公共密钥加密

        long currentTimeMillis = System.currentTimeMillis();
        Date issuedAtDate = new Date(currentTimeMillis);        //设置签发时间
        Date expiresAtDate = new Date(currentTimeMillis + 40 * 60 * 1000);  //设置过期时间,大于签发时间

        /**
         * 载荷
         * 其实就是自定义的数据，一般存储用户Id，过期时间等信息。
         * 也就是JWT的核心所在，因为这些数据就是使后端知道此token是哪个用户已经登录的凭证。
         * 而且这些数据是存在token里面的，由前端携带，所以后端几乎不需要保存任何数据。
         *
         */

        /**
         *
         * 签名 (sign)
         * 签名其实就是：
         * 1.头部和载荷各自base64加密后用.连接起来，然后就形成了xxx.xx的前两段token。
         * 2.最后一段token的形成是，前两段加入一个密匙用HS256算法或者其他算法加密形成。
         * 所以token3段的形成就是在签名处形成的。
         */

        //生成Token:
        // eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJxd2VydHkiLCJpZCI6IjAwNyIsImV4cCI6MTU1OTAzODE0MywiaWF0IjoxNTU5MDM1NzQzLCJhZ2UiOiIyMiIsInVzZXJuYW1lIjoi5rGk5aeGIn0.r4-H9Qmz4IP2OWk-waPjgXkc7j_rsMlyuQaUrtTrNHk
        String s="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJxd2VydHkiLCJpZCI6IjAwNyIsImV4cCI6MTU1OTAzODE0MywiaWF0IjoxNTU5MDM1NzQzLCJhZ2UiOiIyMiIsInVzZXJuYW1lIjoi5rGk5aeGIn0.r4-H9Qmz4IP2OWk-waPjgXkc7j_rsMlyuQaUrtTrNHk";
        String token = JWT.create().withHeader(headMap)
                .withIssuer(API_KEY)
                .withClaim("name", "tom")
                .withClaim("age", "22")
                .withClaim("id", "007")
                .withClaim("username", "汤姆")
                .withIssuedAt(issuedAtDate)
                .withExpiresAt(expiresAtDate)
                .sign(algorithm);  //签名

        return token;
    }
}
