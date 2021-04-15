/*
 * ũ�������� ���� �� �ų� ���� ���Ǳ�
 * 
 * 1) ==== �޴����� ========= (���� ����)
 *   - ��Ʈ��, 10000 , 5�� 
 *   - �ڵ���, 5000  , 10��
 *   - �ɴٹ�, 1000  , 20��
 *   ===== ���� �Ա� �ݾ� : 0��
 * 2) �Աݽ�Ű�� ���
 * 
 * 3) (���ڸ� �������� ) ���� ��ȣ : 1=> ��Ʈ��, 2=> �ڵ���, 3=> �ɴٹ�, 99=> ����*
 *   
 */
package kr.co.dong.check;

import java.util.Scanner;

public class VendingMachine04 {
	static Scanner scan = new Scanner(System.in);
	static int laptopAmount = 5, phoneAmount = 10, flowerAmount = 20;

	public static void main(String[] args) {
		//���� ����
		int laptop = 10000, phone = 5000, flower = 1000;
		boolean done = false;
		int sel = 0, num1 = 0, num2 = 0, sum = 0;
		int n = 0;
		
		//�ݺ��Ǵ� �޴� ����� -> sel = printMenu() �޼ҵ� ������ֱ� 
		while(!done) {
			printMenu();
			
			if (laptopAmount == 0 && phoneAmount == 0 && flowerAmount == 0) { //��� ��ǰ������ 0�̶�� �̷��� �����Ű����.
				System.out.println("��� ��� �����Ǿ����ϴ�.");
				break;
			}
			
			num1 = inputMoney(); //�޼ҵ带 ���� �� ����
			System.out.println("==== ���� �Ա� �ݾ� : "+num1);
			
			sel = select();
			
			switch(sel) {
			
			case 1 :
				//ǰ��Ȯ���ϴ� �޼ҵ�-(ǰ������ ���� Ȯ�� �� ��� ó��->ǰ���̸� �� �ȴٰ� �ϰ� �޴��� �ٽ� �̵�)
				n = soldOut(laptopAmount);
				if (n == 1) {
					System.out.println("��Ʈ��");
					num2 = checkAmount(laptopAmount);//���� Ȯ�� �� num2 -> ���� �Է��� ����
					sum = laptop * num2;//����*���� ���� �� ����
					isPrice(num1, sum);//���װ� ���� �ܾ� ��
					laptopAmount -= num2;//�⺻������ ���� �Է��� ���� ���ֱ�
					}
				else {
					System.out.println("ǰ���� ��ǰ�̹Ƿ� ���� ��ȯ �� �ʱ� ȭ������ �̵��մϴ�.");
					System.out.println("==== ��ȯ �ݾ� : " + num1);
				}
				break;
			case 2 :
				n = soldOut(phoneAmount);
				if (n == 1) {
					System.out.println("�ڵ���");
					num2 = checkAmount(phoneAmount);//num2 run <- after check 
					sum = phone * num2;
					isPrice(num1, sum);
					phoneAmount -= num2;
					}
				else {
					System.out.println("ǰ���� ��ǰ�̹Ƿ� ���� ��ȯ �� �ʱ� ȭ������ �̵��մϴ�.");
					System.out.println("==== ��ȯ �ݾ� : " + num1);
				}
				break;
			case 3 :
				n = soldOut(flowerAmount);
				if (n == 1) {
					System.out.println("�ɴٹ�");
					num2 = checkAmount(flowerAmount);
					sum = flower * num2;
					isPrice(num1, sum);
					flowerAmount -= num2;
					}
				else {
					System.out.println("ǰ���� ��ǰ�̹Ƿ� ���� ��ȯ �� �ʱ� ȭ������ �̵��մϴ�.");
					System.out.println("==== ��ȯ �ݾ� : " + num1);
				}
				break;
			case 99 :
				done = true;
				System.out.println(num1 + "���� ��ȯ�մϴ�.");
				System.out.println("�۵��� �����մϴ�.");
				break;
			}//end of switch
			
		}//end of while
	}//end of main


	private static int soldOut(int tmp) {//������ ���� ���� ��� 0���� �ƴ���
		boolean soldout = false; // ǰ���� �ƴմϴ�.
		int n = 0; // ->ǰ���� �ƴ϶�� 1������ ���Ͻ����ּ���.

		// ������ 0�� ���� �� ǰ���̹Ƿ� �ʱ�ȭ������ ��ȯ
		while (!soldout) { // ǰ���̶�� ��� �����ϼ���
			if (tmp != 0) {// ������ �������� 0�� �ƴ϶��
				soldout = true;
				n = 1;
			}
			else {
				soldout = false;
				break;
			}
		}
		return n;
	}


	private static int checkAmount(int tmp) {
		int num2 = 0;
		boolean done = false;
		
		do {
		System.out.println("��ǰ�� ������ �Է��ϼ��� : ");
		num2 = Integer.parseInt(isNumber());
		
		if (num2>tmp) {
			System.out.println("��ǰ�� �� " + tmp + "�� �ֽ��ϴ�.");
//			if(tmp==0) {
//				System.out.println("ǰ���� ��ǰ�̹Ƿ� ��ǰ ���� ĭ���� �̵��մϴ�.");
//				num2 = 999;
//				select();
//			}
			done = false;
		}
		else if (num2==0) {
			System.out.println("���� 0���� ������ �� �����ϴ�.");
			done = false;
		}
		else {
			done = true;
		}
		}while(!done);
		
		return num2;
	}

	private static void isPrice(int num1,int sum) {
		int result = 0;
		int total = 0;
		
		
		boolean less = false; //�Ա��� ���� �� ���� �� -> �ݾ��� �� ���� -> num1>=tmp�� �� �� ����
		
		do {
			
		//1.�Ա��� ���� �˸��� �� 
		if (sum == num1) {
			System.out.println("��ǰ�� ���Խ��ϴ�.");
			break;
		}
		//2.�Ա��� ���� �� ���� �� 
		else if(num1>sum) {
			System.out.println("��ǰ�� ���Խ��ϴ�.");
			result = num1 - sum;
			System.out.println("�Ž����� : " + result + "�� �Դϴ�.");
			break;
		}
		//3.�Ա��� ���� �� ���� ��
		else {
			less = false;
			System.out.println("=====���� �ܾ� : "+num1);
			System.out.println("�� ���� : " + sum);
			total = sum - num1;
			System.out.println("���� �ܾ� : " + total);
			System.out.println("�ݾ��� �� �������ּ���.");
			num1 += inputMoney();
		}
	}while(!less);
	}
	
	
	private static int select() {
		String str = null;
		int n = 0;
		boolean done = false; //�޴��� ���ڰ� ������ ���ڰ� �ƴ� ��
		
		//���� ��ȣ â
		//int sel ���� �����ؼ� ����� isNumber �޼ҵ� ���� �������� Ȯ��
		while (!done) {
			System.out.println("1.��Ʈ�� 2.�ڵ��� 3.�ɴٹ� 99.����");
			System.out.println("���ϴ� ��ǰ�� ���ڸ� �������ּ��� : ");
			str = isNumber();
			n = Integer.parseInt(str);

			if (n != 1 && n != 2 && n != 3 && n != 99) {
				done = false;
				System.out.println("�޴��� ���ڸ� �Է����ּ���.");
			} else {
				done = true;
			}
		}
		return n;
	}

	private static int inputMoney() {
		int num1 = 0;
		boolean zero = false;
		
		while(!zero) {
			System.out.println("�ݾ��� �����ϼ��� : ");
			num1 = Integer.parseInt(isNumber());
		
			if(num1 == 0) {
				System.out.println("0���� �Է��� �� �����ϴ�.");
			}
			else {
				zero = true;
			}
		}
		
		return num1;//������ ���� num1�� ��ȯ�Ѵ�.
	}


	private static void printMenu() {
		
		System.out.println("========= �޴����� ========");
		System.out.println("= ��Ʈ�� : 10000�� ���� : " + laptopAmount);
		System.out.println("= �ڵ��� : 5000�� ���� : " + phoneAmount);
		System.out.println("= ������ : 1000�� ���� : " + flowerAmount);
		System.out.println("======== ���� �Ա� �ݾ� : 0��");
		
	}


	private static String isNumber() {
		String str = null;
		char ch = 'X';
		boolean isNumber = false;
		
		while(!isNumber) {
			str = scan.next();
			
			for(int i=0;i<str.length();i++) {
				ch = str.charAt(i);
				
				if(ch>='0'&&ch<='9') {
					isNumber = true;
				}
				else {
					isNumber = false;
					System.out.println("���ڸ� �ٽ� �Է��ϼ���.");
					break;
				}
			}
		}//end of while
		return str;
	}

}
