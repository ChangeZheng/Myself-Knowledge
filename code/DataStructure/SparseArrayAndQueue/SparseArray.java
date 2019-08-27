package DataStructure.SparseArrayAndQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SparseArray {

	public static void main(String[] args) throws Exception {
		// 1.创建一个11*11的二维数组，并初始化，用于存储棋盘矩阵
		int[][] sparseArr = new int[11][11];
		// 1代表黑子，2代表白子
		sparseArr[1][4] = 1;
		sparseArr[2][5] = 2;
		// 打印
		System.out.println("二维数组为：");
		for (int[] is : sparseArr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}

		// 2.将二维数组转换为稀疏数组
		// 1)遍历二维数组：确定“棋子”个数
		int sum = 0;
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr.length; j++) {
				if (sparseArr[i][j] != 0)
					sum++;
			}
		}
		// 2)初始化稀疏数组newArr[sum+1][3]
		int[][] newArr = new int[sum + 1][3];
		newArr[0][0] = sparseArr.length;
		newArr[0][1] = sparseArr.length;
		newArr[0][2] = sum;
		// 3)遍历原数组，给稀疏数组赋值
		int index = 0;// 用于确定是第几个棋子
		for (int i = 0; i < sparseArr.length; i++) {
			for (int j = 0; j < sparseArr.length; j++) {
				if (sparseArr[i][j] != 0) {
					index++;
					// 将该棋子的行i,列j,值 存储与稀疏数组中
					newArr[index][0] = i;
					newArr[index][1] = j;
					newArr[index][2] = sparseArr[i][j];
				}
			}
		}
		// 打印
		System.out.println("-------------------------");
		System.out.println("稀疏数组为：");
		for (int[] is : newArr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}

		// 3.将稀疏数组恢复成二维数组
		int[][] arr = new int[newArr[0][1]][newArr[0][1]];
		boolean flag = true;
		for (int[] is : newArr) {
			if(flag){
				flag=false;
				continue;
			}
			arr[is[0]][is[1]] = is[2];
		}
		//打印
		System.out.println("-------------------------");
		System.out.println("原数组为：");
		for (int[] is : arr) {
			for (int i : is) {
				System.out.printf("%d\t", i);
			}
			System.out.println();
		}
		
		// 4.将稀疏数组保存到本地
		//相对路径：默认是该项目
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
		// 5.将本地数组恢复
		BufferedReader br = new BufferedReader(new FileReader(new File("src\\basic\\SparseArray.txt")));
		//创建一个list用于存储读到的每行数据
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
