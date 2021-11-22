package com.nydia.druid;

/**
 * @Description TODO
 * @Date 2021/11/16 17:48
 * @Created by <a href="mailto:nydia_lhq@hotmail.com">lvhuaqiang</a>
 */
public class ClassTest {

    public static void main(String[] args) {
        boolean keepAlive = false;
        int activeCount = 1;
        int poolingCount = 1;
        int minIdle = 1;
        boolean b = (!(keepAlive && activeCount + poolingCount < minIdle));
        System.out.println(b);
    }
}
