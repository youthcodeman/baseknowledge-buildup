package strictfpKeyword;

/**
 * Created by hzgal on 2019-6-13.
 *  strictfp的意思是FP-strict，也就是说精确浮点的意思。
 *  一旦使用了 strictfp来声明一个类、接口或者方法时，那么所声明的范围内Java的编译器以及运行环境会完全依照浮点规范IEEE-754来执行
 *  因此如果你 想让你的浮点运算更加精确，而且不会因为不同的硬件平台所执行的结果不一致的话，那就请用关键字strictfp。
 你可以将一个类、接口以及方法声明为strictfp，但是不允许对接口中的方法以及构造函数声明strictfp关键字。
 */
public strictfp class DemoClass {
}
