package DataStructure.SparseArrayAndQueue;

import java.util.Scanner;
/**
 * 此类用于测试环形队列
 * @author ZXY
 *
 */
public class Queue {
	public static void main(String[] args) {
		// 测试一把
		System.out.println("测试数组模拟环形队列的案例~~~");

		// 创建一个环形队列
		CircleQueue queue = new CircleQueue(4); // 说明设置4, 其队列的有效数据最大是3
		char key = ' '; // 接收用户输入
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.add(value);
				break;
			case 'g': // 取出数据
				try {
					int res = queue.pop();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h': // 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出~~");
	}
}

/**
 * 此类是基于数组的循环队列
 * 
 * @author ZXY
 *
 */
class CircleQueue {
	private int count;// 队列数组容量
	private int front;// 队列的头部指向，初始值为0；
	private int rear;// 指向队列尾部的后一位，初始值为0；这样数组就会空出一位，便于循环队列的计算
	private int[] arr;// 用于存放队列的数组

	public CircleQueue(int count) {
		this.count = count;
		this.arr = new int[count];
	}

	/**
	 * 判断队列是否为空
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * 判断队列是否为满
	 * 
	 * @return
	 */
	public boolean isFull() {
		// 数组空出一位用于最后一位的指向，当最后一位向上增一位==front则表示满
		// 取模是为了匹配rear指向数组最后一位时的情况
		return (rear + 1) % count == front;
	}

	/**
	 * 向队列中添加数据
	 */
	public void add(int i) {
		// 判断队列是否已满
		if (isFull()) {
			System.out.println("队列已满---------");
			return;
		}
		// 添加元素
		arr[rear] = i;
		rear = (rear + 1) % count;// 取模是为了防止rear溢出数组下标
	}

	/**
	 * 取出队首元素
	 */
	public int pop() {
		// 判断是否为空
		if (isEmpty()) {
			// 通过抛出异常：因为有返回值要求，所以不能通过return结束方法
			throw new RuntimeException("队列空，不能取数据");
		}
		int value = arr[front];
		front = (front + 1) % count;
		return value;
	}

	/**
	 * 获取队列长度
	 * 
	 * @return
	 */
	public int size() {
		return (rear - front + count) % count;
	}

	/**
	 * 显示队列所有数据
	 */
	public void showQueue() {
		// 判断是否为空
		if (isEmpty()) {
			System.out.println("队列空，不能取数据");
		}

		for (int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d] = %d", i % count, arr[i % count]);
			System.out.println();
		}
	}

	// 显示队列的头数据， 注意不是取出数据
	public int headQueue() {
		// 判断
		if (isEmpty()) {
			throw new RuntimeException("队列空的，没有数据~~");
		}
		return arr[front];
	}
}