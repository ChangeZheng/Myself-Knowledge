package DataStructure.singleLinkedList;

/**
 * 此类用于表示链表中的节点：包括 
 * 	-数据域 
 * 	-指针域
 * 
 * @author ZXY
 */
public class HeroNode {
	// 数据域
	public int no;
	public String nickname;
	public String name;
	// 指针域
	public HeroNode next;

	// 有参构造器
	public HeroNode(int no, String nickname, String name) {
		super();
		this.no = no;
		this.nickname = nickname;
		this.name = name;
	}
	// 无参构造器
	public HeroNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", nickname=" + nickname + ", name=" + name +  "]";
	}

}