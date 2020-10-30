package sample;

import java.util.Random;
import java.util.Scanner;

public class Janken {
	public static void main(String[] args) {
		int enemy;
		int me;
		int result;
		
		
		selectHand();
		me = inputHandNum();
		enemy = enemyHandNum();
		meAndEnemyType(me, enemy);
		result = Judgment(me, enemy);
		gameResult(result);
			     
	}
	
	//勝負宣言
	public static void buttleStart() {
		System.out.println("じゃんけん3回勝負！！");
	}
	
	//じゃんけん選択コメント
	public static void selectHand() {
		System.out.print("0:グー 1：チョキ 2：パー　⇒ ");
	}
	
	//じゃんけんの結果
	public static void gameResult(int result) {
		final int win = 0;
		final int draw = 1;
		final int lose = 2;
		
		switch (result) {
		case win:
			System.out.println("あなたの勝ちです");
			break;
		case draw:
		    System.out.println("引き分けです");
		    break;
		case lose:
			System.out.println("あなたの負けです");
		default:
			break;
		}
	}
	
	//グーチョキパーを選択する数字の入力
	public static int inputHandNum() {
		Scanner sc = new Scanner(System.in);
		int hand = sc.nextInt();
		sc.close();
		return hand;
	}
	
	//選択した数字のグーチョキパーを変数として使えるようにする
	public static String HandType(int hand) {
		String handType = "";
		switch (hand) {
		case 0:
			handType = "グー";
			break;
		case 1:
			handType = "チョキ";
			break;
		case 2:
			handType = "パー";
			break;

		default:
			System.out.println("ありえない");
			break;
		}return handType;
	}
	
	//相手のグーチョキパーをランダムに決める
	public static int enemyHandNum() {
		Random rand = new Random();
		int enemyhand = rand.nextInt(3);
		return enemyhand;
	}
	
	//自分と相手のグーチョキパーを表示
	public static void meAndEnemyType(int hand,int enemyHand) {
		System.out.println("あなたが選択したのは "+HandType(hand)+" です。");
		System.out.println("相手が選択したのは "+HandType(enemyHand)+ "です。");
	}
	
	//じゃんけんの判定
	public static int Judgment(int hand,int enemyHand) {
		int n = 0;
		
		//勝敗定数
		final int win = 0;
		final int drow = 1;
		final int lose = 2;
		//グーチョキパー定数
		final int gu = 0;
		final int tyoki = 1;
		final int pa = 2;
		
		//判定内容
		if(hand == enemyHand) {
			n = win;
			if     (hand == enemyHand) {
				n = drow;
			}else if(hand == gu && enemyHand == tyoki || hand == tyoki && enemyHand == pa || hand == pa && enemyHand == gu) {
				n = win;
			}else if(hand == gu && enemyHand == pa || hand == tyoki && enemyHand == gu || hand == pa && enemyHand == tyoki) {
				n = lose;
			}
		}
		return n;
	}
}
