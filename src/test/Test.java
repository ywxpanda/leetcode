package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * create by yeweixiong
 *
 * @date 2020/10/12 14:10
 */
public class Test {

    private final Map<String, Method> map;
    private final Panda panda;

    public Test() {
        this.map = new HashMap<>();
        this.panda = new Panda();
        init();
    }

    private void init() {
        Method[] declaredMethods = Panda.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //declaredMethod.setAccessible(true);
            map.put(declaredMethod.getName(), declaredMethod);
        }
    }


    public void execute(String method) {
        try {
            if (!map.containsKey(method)) {
                throw new RuntimeException("method not exist");
            }
            map.get(method).invoke(panda);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.execute("B");
    }

}


class Panda {
    public void A() {
        System.out.println("A");
    }

    public void B() {
        System.out.println("B");
    }

    public void C() {
        System.out.println("C");
    }

    public void D() {
        System.out.println("D");
    }

    public void E() {
        System.out.println("E");
    }

    public void F() {
        System.out.println("F");
    }

    public void G() {
        System.out.println("G");
    }

    public void H() {
        System.out.println("H");
    }
}

