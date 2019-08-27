package DataStructure.singleLinkedList;
/**
 * 此类为有头结点的单向链表，用于管理节点HeroNode：
 * - 头节点：不存放具体数据；作用就是表示单链表头
 * - 添加节点：尾部添加、根据排名插入指定位置、
 * - 删除节点
 * - 修改节点
 * @author ZXY
 *
 */
public class SingleLinkedList {
	//1)头结点：数据域为空，指针域指向第一个节点(初始化也为空)
	public HeroNode head = new HeroNode();
	
	/**
	 * 当不考虑编号顺序时，添加节点到单向链表，思路：
	 * 		先找到当前链表的最后节点；
	 * 		然后将最后这个节点的next指向新节点
	 * @param hero
	 */
	public void add(HeroNode hero) {
		//因为 head 节点不能动,需要一个辅助节点变量temp
		HeroNode temp = head;
		
		//遍历链表，找到最后的节点，将引用赋给temp
		while(true) {
			if(temp.next == null)
				break;
			temp = temp.next;
		}
		
		//将最后这个节点的 next 指向 新的节点
		temp.next = hero;
	}
	
	/**
	 * 当考虑编号顺序时，添加节点到单向链表指定位置，思路：
	 * 		如果存在该节点，则添加失败；
	 * 		
	 * @param hero
	 */
	public void addByOrder(HeroNode hero) {
		//因为头节点不能动， 因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
		//因为单链表， 因为我们找的 temp 是位于 添加位置的前一个节点， 否则插入不了
		HeroNode temp = head;
		
		//判断该节点是否存在
		boolean flag = false;
		while(true) {
			//temp 已经在链表的最后
			if(temp.next == null)
				break;
			//位置找到， 就在 temp 的后面插入
			if(temp.next.no > hero.no)
				break;
			else if(temp.next.no == hero.no) { //说明希望添加的 heroNode 的编号已然存在
				flag = true;
				break;
			}
			temp = temp.next;//后移， 遍历当前链表
		}
		
		//判断 flag 值
		if(flag) {//表示存在该节点
			System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", hero.no);
		} else {
			//插入到链表中, temp 的后面
			hero.next = temp.next;
			temp.next = hero;
		}
	}
	
	/**
	 * 修改节点的信息, 根据 no 编号来修改， 即 no 编号不能改
	 * @param hero
	 */
	public void update(HeroNode hero) {
		// 判断是否空
		if (head.next == null) {
			System.out.println("链表为空~");
			return;
		}
		
		//找到需要修改的节点, 根据 no 编号
		//定义一个辅助变量
		HeroNode temp = head.next;
		
		// 寻找对应节点，flag表示是否找到该节点
		boolean flag = false; 
		while (true) {
			if (temp == null) {
				break; // 已经遍历完链表
			}
			if (temp.no == hero.no) {
				// 找到
				flag = true;
				break;
			}
			temp = temp.next;
		} 
		
		// 根据 flag 判断是否找到要修改的节点
		if (flag) {
			temp.name = hero.name;
			temp.nickname = hero.nickname;
		} else { // 没有找到
			System.out.printf("没有找到 编号 %d 的节点， 不能修改\n", hero.no);
		}
	}
	
	/**
	 * 删除节点
	 * 思路
	 *   1. head 不能动， 因此我们需要一个 temp 辅助节点找到待删除节点的前一个节点
	 *   2. 说明我们在比较时， 是 temp.next.no 和 需要删除的节点的 no 比较
	 */
	public void del(int no) {
		HeroNode temp = head;
		
		//找到待删除节点的
		boolean flag = false; // 标志是否找到待删除节点的
		while (true) {
			if (temp.next == null) { // 已经到链表的最后
				break;
			}
			if (temp.next.no == no) {
				// 找到的待删除节点的前一个节点 temp
				flag = true;
				break;
			}
			temp = temp.next; // temp 后移， 遍历
		}

		// 判断 flag
		if (flag) { // 找到
			// 可以删除
			temp.next = temp.next.next;
		} else {
			System.out.printf("要删除的 %d 节点不存在\n", no);
		}
	}
	
	/**
	 * [遍历]显示链表
	 */
	public void list() {
		// 判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		// 因为头节点， 不能动， 因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		
		while (true) {
			// 判断是否到链表最后
			if (temp == null) {
				break;
			} // 输出节点的信息
			System.out.println(temp);
			// 将 temp 后移， 一定小心
			temp = temp.next;
		}
	}
		
}