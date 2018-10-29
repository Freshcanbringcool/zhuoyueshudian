package com.beta.zhuoyue.zhuoyueshudian.Model;

import java.io.File;

/**
 * Created by CXC on 2018/1/12/012.
 */

public class SubFile {
    private File file = null;//封装一个File类，用于接受传进构造方法中的file类

    public SubFile(File file) {
        this.file = file;//本类中file赋值为传进来的file

    }

    public File getFile() {
        return this.file;//返回本类中的file对象
    }

    @Override
    public String toString() {
        String str = null;//声明一个字符串用来返回值

            if (file.getName().lastIndexOf(".txt") > -1)//这里是过滤掉别的文件，做文件浏览器，可以去掉
            {
                str = "[书籍]" + file.getName();//赋值"[文件]"+文件名字
            }

        return str;
    }
}
