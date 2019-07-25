package recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: DataStructureandAlgorithm
 * @description: 一共有n个台阶，每次可跨越1或2个台阶，走这n个台阶有多少种走法？
 * @author: Mr.Wang
 * @create: 2019-07-25-15:34
 **/
public class TiaoTaijie {

    private Map<Integer, Integer> hasSolvedMap = new HashMap<>(128);
    private int getResult(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // hasSolvedList可以理解成一个Map,key是n，value是f(n)
        if (hasSolvedMap.containsKey(n)) {
            return hasSolvedMap.get(n);
        }

        int ret = getResult(n - 1) + getResult(n - 2);
        hasSolvedMap.put(n, ret);
        return ret;
    }

    public static void main(String[] args) {
        TiaoTaijie tiaoTaijie = new TiaoTaijie();
        System.out.println("4个台阶共有" + tiaoTaijie.getResult(4) + "种走法");
    }
}
