/**
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.98%)
 * Total Accepted:    96.8K
 * Total Submissions: 302.4K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 *
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
 * 0。
 *
 */
public class S0007 {

    /**
     * 比较土的办法
     */
    // public int reverse(int x) {
    //     StringBuffer sBuffer = new StringBuffer();
    //     sBuffer.append(x);

    //     StringBuffer prefix = new StringBuffer();
    //     if(sBuffer.toString().startsWith("-")){
    //         prefix.append("-");
    //         sBuffer.deleteCharAt(0);
    //     }
    //     sBuffer.reverse();
    //     if(sBuffer.toString().startsWith("0")){
    //         sBuffer.deleteCharAt(0);
    //     }
    //     prefix.append(sBuffer);

    //     return Integer.parseInt(prefix.toString());
    // }

    /**
     * 通过取余数模拟堆栈弹出
     */
    public int reverse(int x) {

        int pop = 0;// 每次弹出的数字
        int rev = 0;// 反转之后的数字

        long intMax = Integer.MAX_VALUE;
        long intMin = Integer.MIN_VALUE;

        while(x != 0){
            pop = x % 10;
            x = x / 10;
            // 考虑溢出的问题

            // 临界值：
            // rev * 10 + pop = intMax
            // rev * 10 + pop = intMin

            // 如果 intMax 使用 int 类型 intMax-pop 有可能会超出 int 范围，从而变成负数
            if (rev > ((intMax-pop)/10) || rev < ((intMin - pop)/10) ){
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }

    public static void main(String[] s) {
        S0007 solution = new S0007();
        int reverseInt = solution.reverse(-654321);
        System.out.println("reverseInt:" + reverseInt);
    }
}
