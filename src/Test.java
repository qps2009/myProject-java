/**
 * <ul>
 * <li>公司名称 : 中煤科工集团重庆智慧城市科技研究院有限公司</li>
 * <li>文件名称 : PACKAGE_NAME.Test</li>
 * <li>创建时间 : 2019年06月17日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author Chen.Cen
 * @title
 * @since 1.0.0
 */
public class Test implements Runnable{
    static int value=0;

    @Override
    public void run() {
        while(value<=100){
            synchronized (Test.class){
                System.out.println(Thread.currentThread().getName()+":"+(value++));
                Test.class.notify();
                try{
                    Test.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        new Thread(new Test(),"偶数").start();
        new Thread(new Test(),"奇数").start();
    }
}
