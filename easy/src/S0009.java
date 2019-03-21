/**
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 *
 * algorithms
 * Easy (56.02%)
 * Total Accepted:    83.7K
 * Total Submissions: 149.4K
 * Testcase Example:  '121'
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 */
public class S0009 {

//    public boolean isPalindrome(int x) {
//
//        if(x < 0){
//            return false;
//        }
//
//        int pre = x;
//
//        int pop = 0;
//        int rev = 0;
//        while(x>0){
//            pop = x % 10;
//            x = x/10;
//            rev = rev * 10 + pop; // 此处还是要注意溢出的问题，如果溢出肯定就是 false
//        }
//
//        if(rev == pre){
//            return true;
//        }
//        return false;
//    }

    public boolean isPalindrome(int x) {

        // x 为负数时肯定不是回文数
        // 如果是两位数，个位是0的话，十位也必须为0
        if(x < 0 || (x%10==0 && x!=0)){
            return false;
        }

        int pre = x;
        int pop = 0;
        int rev = 0;
        while(x > rev){
            pop = x % 10;
            x = x/10;
            rev = rev * 10 + pop;
        }

        if(x == rev || x == rev/10){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        S0009 s = new S0009();
        boolean isPalindrome = s.isPalindrome(121);
        System.out.println(isPalindrome);
    }

}
