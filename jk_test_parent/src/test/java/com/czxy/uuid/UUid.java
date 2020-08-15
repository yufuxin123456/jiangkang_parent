package com.czxy.uuid;

import java.util.UUID;

public class UUid {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static void main(String[] args) {
        // 利用伪随机数生成版本为4,变体为9的UUID

        System.out.println(getUUID());

        // 对于相同的命名空间总是生成相同的UUID,版本为3,变体为9
        // 命名空间为"mwq"时生成的UUID总是为06523e4a-9a66-3687-9334-e41dab27cef4
        System.out.println(UUID.nameUUIDFromBytes("mwq".getBytes()));
    }


}
