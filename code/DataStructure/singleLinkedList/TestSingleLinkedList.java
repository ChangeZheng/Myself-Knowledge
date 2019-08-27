package DataStructure.singleLinkedList;

import org.junit.Test;

/**
 * 用于测试单向链表：SingleLinkedList
 * @author ZXY
 *
 */
public class TestSingleLinkedList {
	// 先创建节点
	HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
	HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
	HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
	HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

	@Test
	public void test() {
		//创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		// 加入
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero4);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		
		//显示一把
		singleLinkedList.list();
	}
	
	@Test
	public void test2() {
		//创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		//加入按照编号的顺序
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		
		//显示一把
		singleLinkedList.list();
		
		//测试修改节点的代码
		HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
		singleLinkedList.update(newHeroNode);
		
		System.out.println("修改后的链表情况~~");
		singleLinkedList.list();
		
		//删除一个节点
		singleLinkedList.del(1);
		singleLinkedList.del(4);
		System.out.println("删除后的链表情况~~");
		singleLinkedList.list();
	}

}
