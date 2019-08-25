package basic.singleLinkedList;

/**
 * 此类用于表示链表中的节点：包括 数据域 指针域
 * 
 * @author ZXY
 */
public class HeroNode {
	// 数据域
	public int id;
	public String nickname;
	public String name;
	// 指针域
	public HeroNode next;

	// 有参构造器
	public HeroNode(int id, String nickname, String name, HeroNode next) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.next = next;
	}
	// 无参构造器
	public HeroNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", nickname=" + nickname + ", name=" + name + ", next=" + next + "]";
	}

}