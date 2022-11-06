package DataStructures.d04_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-6";                                 //中缀表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);//String中缀转List中缀
        System.out.println("中缀表达式对应的List=" + infixExpressionList);     //输出


        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);//List中缀转List后缀
        System.out.println("后缀表达式对应的List" + suffixExpreesionList);                   //输出
        System.out.printf("expression=%d", calculate(suffixExpreesionList));                //计算结果



/*		//测试后缀表达式计算
		String suffixExpression = "30 4 + 5 * 6 -";
		List<String> list = getListString(suffixExpression);
		System.out.println("rpnList=" + list);
		int res = calculate(list);
		System.out.println("计算的结果是=" + res);*/
    }


    /**
     * 中缀转后缀
     * 不是正常人能想出来的，但是可以背下来，小韩也想不出来
     * @param ls
     * @return
     */
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        List<String> s2 = new ArrayList<String>();      // 储存中间结果的Lists2
        for (String item : ls) {                        //遍历ls
            if (item.matches("\\d+")) {           //如果是操作数
                s2.add(item);
            } else if (item.equals("(")) {              //如果是左括号
                s1.push(item);
            } else if (item.equals(")")) {              //如果是右括号
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();                            //!!! 将 ( 弹出 s1栈， 消除小括号
            } else {                                    //如果是运算符
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                //需调用我们写的比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);                  //还需要将item压入栈
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; //注意因为是存放到List, 因此按顺序输出就是对应的后缀表达式对应的List
    }

    /**
     * 方法：将中缀表达式转成对应的List
     * @param s
     * @return
     */
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，我需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++; //i需要后移
            } else { //如果是一个数，需要考虑多位数
                str = ""; //先将str 置成"" '0'[48]->'9'[57]
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;//返回
    }

    /**
     * 将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList中
     *
     * @param suffixExpression
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");       //将 suffixExpression 按照空格分割
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    /**
     * 计算逆波兰表达式
     *
     * @param ls（我们转化的List集合）
     * @return
     */
    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<String>();              //创建一个java带的栈
        for (String item : ls) {                                //遍历 ls
            // 这里使用正则表达式来取出数
            if (item.matches("\\d+")) {                   //匹配的是多位数
                stack.push(item);
            } else {                                            //不是数（那就是运算符喽）
                int num2 = Integer.parseInt(stack.pop());       //pop出两个数，并运算， 再入栈
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);                  //把res 入栈
            }
        }
        return Integer.parseInt(stack.pop());               //最后留在stack中的数据是运算结果
    }

}

//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}
