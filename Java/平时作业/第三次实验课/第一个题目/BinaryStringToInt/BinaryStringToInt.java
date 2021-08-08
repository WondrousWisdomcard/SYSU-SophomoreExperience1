package BinaryStringToInt;

import java.util.Scanner;

public class BinaryStringToInt {
	public static void main(String args[]) {
			String a = new String();
			int start, end;
			
			a = "a'10101010101111111110010111001000101010bcd";
			start = 0;
			end = 2;
			testInMain(a,start,end);
			System.out.println();
			
			start = 2;
			end = 34;
			testInMain(a,start,end);
			System.out.println();
			
			start = 2;
			end = 38;
			testInMain(a,start,end);
			System.out.println();
			
			start = 5;
			end = 18;
			testInMain(a,start,end);
			System.out.println();
			
			start = -1;
			end = 18;
			testInMain(a,start,end);
			System.out.println();
			
			start = 5;
			end = 100;
			testInMain(a,start,end);
			System.out.println();
			
	}
	
	public static void testInMain(String a,int start, int end) {
		int result;
		System.out.println("s: "+ a);
		System.out.println("start: "+ start);
		System.out.println("end: "+ end);
		try{
			result = binaryStringToInt(a,start,end);
			System.out.println("result: "+ result);
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("result: string index out of bounds.");
		}
		catch(ArithmeticException e) {
			System.out.println("result: out of bits size of int.");
		}
		catch(NumberFormatException e) {
			System.out.println("result: incorrect binary number format.");
		}
	}
	
	public static int binaryStringToInt(String s,int start, int end) {
		int result = 0;
			if(end > s.length() || start < 0 || end < start){
				throw new StringIndexOutOfBoundsException();
			}
			if(end - start > 32){
				throw new ArithmeticException();
			}
			for(int i = start; i < end; i++){
				if(s.charAt(i) < '0'|| s.charAt(i) > '9' ) {
					throw new NumberFormatException();
				}
			}
			////////////
			int pow = 1;
			for(int j = end-1; j >= start; j--)
			{
				result = result + (s.charAt(j)=='1'?1:0) * pow;
				pow = pow * 2;
			}
			return result;
	}
}