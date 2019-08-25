package DataStructure.singleLinkedList;

/**
 * �������ڱ�ʾ�����еĽڵ㣺���� ������ ָ����
 * 
 * @author ZXY
 */
public class HeroNode {
	// ������
	public int id;
	public String nickname;
	public String name;
	// ָ����
	public HeroNode next;

	// �вι�����
	public HeroNode(int id, String nickname, String name, HeroNode next) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.name = name;
		this.next = next;
	}
	// �޲ι�����
	public HeroNode() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", nickname=" + nickname + ", name=" + name + ", next=" + next + "]";
	}

}