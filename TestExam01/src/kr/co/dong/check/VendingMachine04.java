/*
 * 크리스마스 선물 및 신년 선물 자판기
 * 
 * 1) ==== 메뉴구성 ========= (개별 변수)
 *   - 노트북, 10000 , 5개 
 *   - 핸드폰, 5000  , 10개
 *   - 꽃다발, 1000  , 20개
 *   ===== 현재 입금 금액 : 0원
 * 2) 입금시키는 기능
 * 
 * 3) (숫자를 기준으로 ) 선택 번호 : 1=> 노트북, 2=> 핸드폰, 3=> 꽃다발, 99=> 종료*
 *   
 */
package kr.co.dong.check;

import java.util.Scanner;

public class VendingMachine04 {
	static Scanner scan = new Scanner(System.in);
	static int laptopAmount = 5, phoneAmount = 10, flowerAmount = 20;

	public static void main(String[] args) {
		//변수 선언
		int laptop = 10000, phone = 5000, flower = 1000;
		boolean done = false;
		int sel = 0, num1 = 0, num2 = 0, sum = 0;
		int n = 0;
		
		//반복되는 메뉴 만들기 -> sel = printMenu() 메소드 만들어주기 
		while(!done) {
			printMenu();
			
			if (laptopAmount == 0 && phoneAmount == 0 && flowerAmount == 0) { //모든 상품수량이 0이라면 이렇게 실행시키세요.
				System.out.println("모든 재고가 소진되었습니다.");
				break;
			}
			
			num1 = inputMoney(); //메소드를 통해 돈 투입
			System.out.println("==== 현재 입금 금액 : "+num1);
			
			sel = select();
			
			switch(sel) {
			
			case 1 :
				//품절확인하는 메소드-(품절인지 먼저 확인 후 계산 처리->품절이면 안 된다고 하고 메뉴로 다시 이동)
				n = soldOut(laptopAmount);
				if (n == 1) {
					System.out.println("노트북");
					num2 = checkAmount(laptopAmount);//수량 확인 후 num2 -> 내가 입력한 수량
					sum = laptop * num2;//가격*수량 다음 총 계산액
					isPrice(num1, sum);//계산액과 현재 잔액 비교
					laptopAmount -= num2;//기본값에서 내가 입력한 수량 빼주기
					}
				else {
					System.out.println("품절된 상품이므로 돈을 반환 후 초기 화면으로 이동합니다.");
					System.out.println("==== 반환 금액 : " + num1);
				}
				break;
			case 2 :
				n = soldOut(phoneAmount);
				if (n == 1) {
					System.out.println("핸드폰");
					num2 = checkAmount(phoneAmount);//num2 run <- after check 
					sum = phone * num2;
					isPrice(num1, sum);
					phoneAmount -= num2;
					}
				else {
					System.out.println("품절된 상품이므로 돈을 반환 후 초기 화면으로 이동합니다.");
					System.out.println("==== 반환 금액 : " + num1);
				}
				break;
			case 3 :
				n = soldOut(flowerAmount);
				if (n == 1) {
					System.out.println("꽃다발");
					num2 = checkAmount(flowerAmount);
					sum = flower * num2;
					isPrice(num1, sum);
					flowerAmount -= num2;
					}
				else {
					System.out.println("품절된 상품이므로 돈을 반환 후 초기 화면으로 이동합니다.");
					System.out.println("==== 반환 금액 : " + num1);
				}
				break;
			case 99 :
				done = true;
				System.out.println(num1 + "원을 반환합니다.");
				System.out.println("작동을 종료합니다.");
				break;
			}//end of switch
			
		}//end of while
	}//end of main


	private static int soldOut(int tmp) {//각각의 수량 별로 재고가 0인지 아닌지
		boolean soldout = false; // 품절이 아닙니다.
		int n = 0; // ->품절이 아니라면 1번으로 리턴시켜주세요.

		// 수량이 0이 됐을 때 품절이므로 초기화면으로 전환
		while (!soldout) { // 품절이라면 계속 실행하세요
			if (tmp != 0) {// 각각의 수량들이 0이 아니라면
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
		System.out.println("상품의 수량을 입력하세요 : ");
		num2 = Integer.parseInt(isNumber());
		
		if (num2>tmp) {
			System.out.println("상품은 총 " + tmp + "개 있습니다.");
//			if(tmp==0) {
//				System.out.println("품절된 상품이므로 상품 선택 칸으로 이동합니다.");
//				num2 = 999;
//				select();
//			}
			done = false;
		}
		else if (num2==0) {
			System.out.println("수량 0개는 선택할 수 없습니다.");
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
		
		
		boolean less = false; //입금한 돈이 더 적을 때 -> 금액을 더 투입 -> num1>=tmp가 될 때 까지
		
		do {
			
		//1.입금한 돈이 알맞은 때 
		if (sum == num1) {
			System.out.println("물품이 나왔습니다.");
			break;
		}
		//2.입금한 돈이 더 많을 때 
		else if(num1>sum) {
			System.out.println("물품이 나왔습니다.");
			result = num1 - sum;
			System.out.println("거스름돈 : " + result + "원 입니다.");
			break;
		}
		//3.입금한 돈이 더 적을 때
		else {
			less = false;
			System.out.println("=====현재 잔액 : "+num1);
			System.out.println("총 계산액 : " + sum);
			total = sum - num1;
			System.out.println("부족 잔액 : " + total);
			System.out.println("금액을 더 투입해주세요.");
			num1 += inputMoney();
		}
	}while(!less);
	}
	
	
	private static int select() {
		String str = null;
		int n = 0;
		boolean done = false; //메뉴의 숫자가 보기의 숫자가 아닐 때
		
		//선택 번호 창
		//int sel 먼저 설정해서 만들고 isNumber 메소드 만들어서 숫자인지 확인
		while (!done) {
			System.out.println("1.노트북 2.핸드폰 3.꽃다발 99.종료");
			System.out.println("원하는 상품의 숫자를 선택해주세요 : ");
			str = isNumber();
			n = Integer.parseInt(str);

			if (n != 1 && n != 2 && n != 3 && n != 99) {
				done = false;
				System.out.println("메뉴의 숫자를 입력해주세요.");
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
			System.out.println("금액을 투입하세요 : ");
			num1 = Integer.parseInt(isNumber());
		
			if(num1 == 0) {
				System.out.println("0원은 입력할 수 없습니다.");
			}
			else {
				zero = true;
			}
		}
		
		return num1;//숫자인 돈을 num1에 반환한다.
	}


	private static void printMenu() {
		
		System.out.println("========= 메뉴구성 ========");
		System.out.println("= 노트북 : 10000원 수량 : " + laptopAmount);
		System.out.println("= 핸드폰 : 5000원 수량 : " + phoneAmount);
		System.out.println("= 에어팟 : 1000원 수량 : " + flowerAmount);
		System.out.println("======== 현재 입금 금액 : 0원");
		
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
					System.out.println("숫자를 다시 입력하세요.");
					break;
				}
			}
		}//end of while
		return str;
	}

}
