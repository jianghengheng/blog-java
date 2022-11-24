package com.mayikt.entity.utils;

import org.springframework.beans.BeanUtils;

public class DoToDto {


    public static class MeiteBeanUtils<Dto, Do> {

        /**
         * dot 转换为Do 工具类 do转化dto
         *
         * @param dtoEntity
         * @param doClass
         * @return
         */
        public  <Do> Do dtoToDo(Object dtoEntity, Class<Do> doClass) {
            // 判断dto是否为空!
            if (dtoEntity == null) {
                return null;
            }
            // 判断DoClass 是否为空
            if (doClass == null) {
                return null;
            }
            try {
                Do newInstance = doClass.newInstance();
                BeanUtils.copyProperties(dtoEntity, newInstance);
                // Dto转换Do
                return newInstance;
            } catch (Exception e) {
                return null;
            }
        }

        /**
         * do 转换为Dto 工具类
         *
         * @param dtoEntity
         * @param doEntity
         * @return
         */
        public  <Dto> Dto doToDto(Object doEntity, Class<Dto> dtoClass) {
            // 判断dto是否为空!
            if (doEntity == null) {
                return null;
            }
            // 判断DoClass 是否为空
            if (dtoClass == null) {
                return null;
            }
            try {
                Dto newInstance = dtoClass.newInstance();
                BeanUtils.copyProperties(doEntity, newInstance);
                // Dto转换Do
                return newInstance;
            } catch (Exception e) {
                return null;
            }
        }
        // 后面集合类型带封装
    }

}
