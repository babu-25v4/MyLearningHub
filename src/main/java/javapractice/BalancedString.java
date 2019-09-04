package javapractice;

import java.util.Stack;

public class BalancedString {

	public static void main(String[] args)
	{

		boolean isBalanced=false;

		String str="{}([])[[";

		Stack<Character> stack=new Stack<Character>();

		if(str.isEmpty() || str.length()%2!=0 )
		{
			System.out.println("Not a balanced string");
		}else{
			int length=str.length();

			for(int i=0;i<length;i++)
			{
				char stringCh=str.charAt(i);

				if(stringCh=='{' || stringCh=='[' || stringCh=='(')
				{
					stack.push(stringCh);        
				}else
				{
					if(stack.isEmpty())
					{
						isBalanced=false;
						break;
					}
					char stackchar=stack.pop();
					isBalanced= checkBalance(stringCh, stackchar );
				}
			}
			if(isBalanced&&stack.isEmpty())
			{
				System.out.println("Balanced String");
			}
			else
			{
				System.out.println("Not a balanced string");
			}
		}    
	}
	public static boolean checkBalance(char stringCh, char stackchar)
	{
		// TODO Auto-generated method stub
		boolean isBalanced=false;

		if(stackchar=='{' && stringCh=='}')
		{
			isBalanced=true;
		}
		else if(stackchar=='[' && stringCh==']'){
			isBalanced=true;
		}
		else if(stackchar=='(' && stringCh==')')
		{
			isBalanced=true;
		}

		return isBalanced;
	}

}
