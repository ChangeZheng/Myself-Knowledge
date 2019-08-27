package DataStructure.SparseArrayAndQueue;

import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		//����һ��
				System.out.println("��������ģ�⻷�ζ��еİ���~~~");
				
				// ����һ�����ζ���
				CircleQueue queue = new CircleQueue(4); //˵������4, ����е���Ч���������3
				char key = ' '; // �����û�����
				Scanner scanner = new Scanner(System.in);//
				boolean loop = true;
				// ���һ���˵�
				while (loop) {
					System.out.println("s(show): ��ʾ����");
					System.out.println("e(exit): �˳�����");
					System.out.println("a(add): ������ݵ�����");
					System.out.println("g(get): �Ӷ���ȡ������");
					System.out.println("h(head): �鿴����ͷ������");
					key = scanner.next().charAt(0);// ����һ���ַ�
					switch (key) {
					case 's':
						queue.showQueue();
						break;
					case 'a':
						System.out.println("���һ����");
						int value = scanner.nextInt();
						queue.add(value);
						break;
					case 'g': // ȡ������
						try {
							int res = queue.pop();
							System.out.printf("ȡ����������%d\n", res);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
						break;
					case 'h': // �鿴����ͷ������
						try {
							int res = queue.headQueue();
							System.out.printf("����ͷ��������%d\n", res);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
						break;
					case 'e': // �˳�
						scanner.close();
						loop = false;
						break;
					default:
						break;
					}
				}
				System.out.println("�����˳�~~");
	}
}

/**
 * �����ǻ��������ѭ������
 * 
 * @author ZXY
 *
 */
class CircleQueue {
	private int count;// ������������
	private int front;// ���е�ͷ��ָ�򣬳�ʼֵΪ0��
	private int rear;// ָ�����β���ĺ�һλ����ʼֵΪ0����������ͻ�ճ�һλ������ѭ�����еļ���
	private int[] arr;// ���ڴ�Ŷ��е�����

	public CircleQueue(int count) {
		this.count = count;
		this.arr = new int[count];
	}

	/**
	 * �ж϶����Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * �ж϶����Ƿ�Ϊ��
	 * 
	 * @return
	 */
	public boolean isFull() {
		// ����ճ�һλ�������һλ��ָ�򣬵����һλ������һλ==front���ʾ��
		// ȡģ��Ϊ��ƥ��rearָ���������һλʱ�����
		return (rear + 1) % count == front;
	}

	/**
	 * ��������������
	 */
	public void add(int i) {
		// �ж϶����Ƿ�����
		if (isFull()) {
			System.out.println("��������---------");
			return;
		}
		// ���Ԫ��
		arr[rear] = i;
		rear = (rear + 1) % count;// ȡģ��Ϊ�˷�ֹrear��������±�
	}

	/**
	 * ȡ������Ԫ��
	 */
	public int pop() {
		// �ж��Ƿ�Ϊ��
		if (isEmpty()) {
			// ͨ���׳��쳣����Ϊ�з���ֵҪ�����Բ���ͨ��return��������
			throw new RuntimeException("���пգ�����ȡ����");
		}
		int value = arr[front];
		front = (front + 1) % count;
		return value;
	}

	/**
	 * ��ȡ���г���
	 * 
	 * @return
	 */
	public int size() {
		return (rear - front + count) % count;
	}

	/**
	 * ��ʾ������������
	 */
	public void showQueue() {
		// �ж��Ƿ�Ϊ��
		if (isEmpty()) {
			System.out.println("���пգ�����ȡ����");
		}

		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d] = %d", i % count, arr[i % count]);
			System.out.println();
		}
	}

	// ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
	public int headQueue() {
		// �ж�
		if (isEmpty()) {
			throw new RuntimeException("���пյģ�û������~~");
		}
		return arr[front];
	}
}