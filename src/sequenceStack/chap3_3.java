/**  
* <p>Title: chap3_3.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.baidudu.com</p>  
* @author shenlan  
* @date Mar 25, 2019  
* @version 1.0  
*/ 
package sequenceStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**  
* <p>Title: chap3_3</p>  
* <p>Description: 表达式求值</p>  
* @author 马坤  
* @date Mar 25, 2019  
*/
public class chap3_3 {
	//用于判断c是运算符还是操作数
	public static boolean IsOperator(char c) {
		switch(c) {
		case '#':
		case '+':
		case '-':
		case '*':
		case '/':
		case '(':
		case ')':
			return true;
			default:
				return false;
		}
	}
	static char OP[][]= {
			{'>', '>', '<', '<', '<', '>', '>'},
			{'>', '>', '<', '<', '<', '>', '>'},
			{'>', '>', '>', '>', '<', '>', '>'},
			{'>', '>', '>', '>', '<', '>', '>'},
			{'<', '<', '<', '<', '<', '=', 'E'},
			{'>', '>', '>', '>', 'E', '>', '>'},
			{'<', '<', '<', '<', '<', 'E', '='}
	};
	public static int GetOperatorID(char Operator) {
		int retCode;
		retCode = -1;
		switch (Operator) {
		case '+':
			retCode = 0;
			break;
		case '-':
			retCode = 1;
			break;
		case '*':
			retCode = 2;
			break;
		case '/':
			retCode = 3;
			break;
		case '(':
			retCode = 4;
			break;
		case ')':
			retCode = 5;
			break;
		case '#':
			retCode = 6;
			break;
		}
		return (retCode);
	}
	public static char Precede(char Operator1, char Operator2) {
		int OperatorID1, OperatorID2;
		OperatorID1 = GetOperatorID(Operator1);
		OperatorID2 = GetOperatorID(Operator2);
		if (OperatorID1 < 0 || OperatorID1 > 6 || OperatorID2 < 0 || OperatorID2 > 6) {
			return ('E');
		}
		return (OP[OperatorID1][OperatorID2]);
	}
	//Operate（）将以op1，op2作为参数
	//theta作为运算符进行运算，返回计算结果
	public static double Operate(double op1, char ca1, double op2) {
		switch (ca1) {
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;
		case '*':
			return op1 *op2;
		case '/':
			return op1 / op2;
		default:
			return 0;
		}
	}
	public static double ExpEvaluation(char []exp) {
		//读入一个简单的数学表达式并计算其值
		char theta;
		int i = 0;
		double b, a, val;
		sequenceStack<Character> OPTR = new sequenceStack<Character>();//运算符栈
		sequenceStack<Double> OPND = new sequenceStack<Double>();//操作数栈
		OPTR.push('#');
		while (exp[i] != '#' || OPTR.getHead() != '#') {
			if (!IsOperator(exp[i])) {
				double temp;
				temp = exp[i] - '0';
				i++;
				while (!IsOperator(exp[i]) && i < exp.length) {
					temp = temp * 10 + exp[i] - '0';
					i++;
				}
				OPND.push(temp);
			}else {
				switch (Precede(OPTR.getHead(), exp[i])) {
				case '<':
					OPTR.push(exp[i]);
					i++;
					break;
				case '=':
					OPTR.pop();
					i++;
					break;
				case '>':
					theta = OPTR.pop();
					b = OPND.pop();
					a = OPND.pop();
					OPND.push(Operate(a, theta, b));
					break;
				}
			}
		}
		val = OPND.getHead();
		return (val);
	}
	public static void main(String[] args) {
		BufferedReader bReader;
		String s;
		try {
			bReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("输入一个以#结束的表达式：");
			s = bReader.readLine();
			char[] us = s.toCharArray();
			System.out.println("表达式值为：" + ExpEvaluation(us));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
