package com.mayikt.entity.utils;

import java.util.UUID;

/**
 * @author 余胜军
 * @ClassName SaltUtiks
 * @qq 644064779
 * @addres www.mayikt.com
 * 微信:yushengjun644
 */
public class SaltUtils {
    /**
     * 生成盐值
     *
     * @return
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
