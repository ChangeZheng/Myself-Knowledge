package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SparseArray {

	public static void main(String[] args) throws Exception {
		// 1.����һ��11*11�Ķ�ά���飬����ʼ�������ڴ洢���̾���
		int[][] sparseArr = new int[11][11];
		// 1������ӣ�2�������
		sparseArr[1][4] = 1;
		sparseArr[2][5] = 2;
		// ��ӡ
		System.out.println("��ά����Ϊ��");
		for (int[] is : sparseArr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}

		// 2.����ά����ת��Ϊϡ������
		// 1)������ά���飺ȷ�������ӡ�����
		int sum = 0;
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr.length; j++) {
				if (sparseArr[i][j] != 0)
					sum++;
			}
		}
		// 2)��ʼ��ϡ������newArr[sum+1][3]
		int[][] newArr = new int[sum + 1][3];
		newArr[0][0] = sparseArr.length;
		newArr[0][1] = sparseArr.length;
		newArr[0][2] = sum;
		// 3)����ԭ���飬��ϡ�����鸳ֵ
		int index = 0;// ����ȷ���ǵڼ�������
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr.length; j++) {
				if (sparseArr[i][j] != 0) {
					index++;
					// �������ӵ���i,��j,ֵ �洢��ϡ��������
					newArr[index][0] = i;
					newArr[index][1] = j;
					newArr[index][2] = sparseArr[i][j];
				}
			}
		}
		// ��ӡ
		System.out.println("-------------------------");
		System.out.println("ϡ������Ϊ��");
		for (int[] is : newArr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}

		// 3.��ϡ������ָ��ɶ�ά����
		int[][] arr = new int[newArr[0][1]][newArr[0][1]];
		boolean flag = true;
		for (int[] is : newArr) {
			if(flag){
				flag=false;
				continue;
			}
			arr[is[0]][is[1]] = is[2];
		}
		//��ӡ
		System.out.println("-------------------------");
		System.out.println("ԭ����Ϊ��");
		for (int[] is : arr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}
		
		// 4.��ϡ�����鱣�浽����
		//���·����Ĭ���Ǹ���Ŀ
		BufferedWriter bd = new BufferedWriter(new FileWriter(new File("src\\basic\\SparseArray.txt")));
		for (int[] is : newArr) {
			for (int i = 0;i<is.length;i++) {
				bd.write(is[i]+"");
				if(i!=is.length-1)
					bd.write(",");
			}
			bd.newLine();
		}
		bd.close();
		// 5.����������ָ�
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\basic\\SparseArray.txt")));
		//����һ��list���ڴ洢������ÿ������
		ArrayList<Integer[]> list = new ArrayList<>();
		String str = null;
		while((str = br.readLine())!=null){
			String[] strArr = str.split(",");
			Integer[] i = new Integer[strArr.length];
			for(int j=0;j<i.length;j++){
				i[j] = Integer.parseInt(strArr[j]);
			}
			list.add(i);
		}
		
		int[][] target = new int[list.size()][3];
		
		for (int i =0;i<list.size();i++) {
			 Integer[] integers = list.get(i);
			target[i][0] = integers[0];
			target[i][1] = integers[1];
			target[i][2] = integers[2];
		}
		
		for (int[] is : target) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}
		
		br.close();
	}

}
