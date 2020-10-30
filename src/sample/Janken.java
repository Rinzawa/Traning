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
	
	//�����錾
	public static void buttleStart() {
		System.out.println("����񂯂�3�񏟕��I�I");
	}
	
	//����񂯂�I���R�����g
	public static void selectHand() {
		System.out.print("0:�O�[ 1�F�`���L 2�F�p�[�@�� ");
	}
	
	//����񂯂�̌���
	public static void gameResult(int result) {
		final int win = 0;
		final int draw = 1;
		final int lose = 2;
		
		switch (result) {
		case win:
			System.out.println("���Ȃ��̏����ł�");
			break;
		case draw:
		    System.out.println("���������ł�");
		    break;
		case lose:
			System.out.println("���Ȃ��̕����ł�");
		default:
			break;
		}
	}
	
	//�O�[�`���L�p�[��I�����鐔���̓���
	public static int inputHandNum() {
		Scanner sc = new Scanner(System.in);
		int hand = sc.nextInt();
		sc.close();
		return hand;
	}
	
	//�I�����������̃O�[�`���L�p�[��ϐ��Ƃ��Ďg����悤�ɂ���
	public static String HandType(int hand) {
		String handType = "";
		switch (hand) {
		case 0:
			handType = "�O�[";
			break;
		case 1:
			handType = "�`���L";
			break;
		case 2:
			handType = "�p�[";
			break;

		default:
			System.out.println("���肦�Ȃ�");
			break;
		}return handType;
	}
	
	//����̃O�[�`���L�p�[�������_���Ɍ��߂�
	public static int enemyHandNum() {
		Random rand = new Random();
		int enemyhand = rand.nextInt(3);
		return enemyhand;
	}
	
	//�����Ƒ���̃O�[�`���L�p�[��\��
	public static void meAndEnemyType(int hand,int enemyHand) {
		System.out.println("���Ȃ����I�������̂� "+HandType(hand)+" �ł��B");
		System.out.println("���肪�I�������̂� "+HandType(enemyHand)+ "�ł��B");
	}
	
	//����񂯂�̔���
	public static int Judgment(int hand,int enemyHand) {
		int n = 0;
		
		//���s�萔
		final int win = 0;
		final int drow = 1;
		final int lose = 2;
		//�O�[�`���L�p�[�萔
		final int gu = 0;
		final int tyoki = 1;
		final int pa = 2;
		
		//������e
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
