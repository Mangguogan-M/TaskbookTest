package BinaryTree;

import java.util.Scanner;

//������
public class SY5_TraverBiTree {
	public static void main(String[] args) {
		String preStr = "abc##d##e#f##";// �������������ȸ���������
		BiTree T = new BiTree(preStr);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(" 1--�ȸ�����    2--�и�����   3--�������    4--�˳� ");
			System.out.print("������ѡ��(1-4):");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.print("�ȸ�����Ϊ�� ");
				T.preRootTraverse(T.getRoot());
				System.out.println();
				break;
			case 2:
				System.out.print("�и�����Ϊ�� ");
				T.inRootTraverse(T.getRoot());
				System.out.println();
				break;
			case 3:
				System.out.print("�������Ϊ�� ");
				T.postRootTraverse(T.getRoot());
				System.out.println();
				break;
			case 4:
				return;
			}
		}
	}
}
