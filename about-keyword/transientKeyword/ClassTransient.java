package transientKeyword;
/**
 * Created by hzgal on 2019-6-13.
 */

/**
 如果用transient声明一个实例变量，当对象存储时，它的值不需要维持。
 这里，如果ClassTransient类的一个对象写入一个持久的存储区域，a的内容不被保存，但b的将被保存。
 */
public class ClassTransient {
    transient int a;  //不需要维持
    int b;  //需要维持
}
