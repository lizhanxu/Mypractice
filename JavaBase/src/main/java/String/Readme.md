###String源码阅读笔记

#####StringBuffer是线程安全的

#####`public boolean contentEquals(CharSequence cs);`//该方法通过同步代码块确保了String与StringBuffer内容比较时的线程安全

`public String(char value[]) {`<br>
         `this.value = Arrays.copyOf(value, value.length);`<br>
`}`

`String(char[] value, boolean share) {`<br>
        `// assert share : "unshared not supported";`<br>
        `this.value = value;`<br>
`}`

#####不将该方法修饰为public保证了String的不可变性
#####目前不支持使用false，只使用true。所以就目前来看加入这个share只是为了区分于String(char[] value)方法，从而进行方法的重载。
#####share=true的含义为这个方法构造出来的String和参数传过来的char[] value共享同一个数组
#####优点：
#####①性能更好，一个是直接将value的引用赋给String的value，一个是逐一拷贝
#####②共享内部数组，节约内存

#####`public String trim();`//去掉字符串首尾的空格' '