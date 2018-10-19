package com.lk.java.link;
/**
 * 单向链表节点
 * @author liukun
 *
 */
public class ListNode {
	private int data;
	private ListNode next;
	public ListNode(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	/**
	 * 统计链表的长度
	 * @param headNode
	 * @return
	 */
	public int getLinkLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while(currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	/**
	 * 向链表中插入新的节点
	 * @param headNode
	 * @param nodeToInsert
	 * @param position
	 * @return
	 */
	public ListNode insertLinkedNode(ListNode headNode, ListNode nodeToInsert, int position) {
		if(headNode == null) {
			//当前链表为空
			return nodeToInsert;
		}
		int size = getLinkLength(headNode);
		if(position > size + 1 || position < 1) {
			System.out.println("插入的位置不在链表范围内");
			return headNode;
		}
		//如果插在头部
		if(position == 1) {
			nodeToInsert.next = headNode;
			return nodeToInsert;
		}else {
			//插入的位置是在中间或者是末尾
			
			//记录插入位置的前一个节点
			ListNode previousNode = headNode;
			//统计位置
			int count = 1;
			while(count < position - 1) {//还没有到达插入的位置
				previousNode = previousNode.getNext();
				count++;
			}
			//到达插入节点的位置
			//1 获取需要插入位置的当前节点
			ListNode currentNode = previousNode.getNext();
			//2将需要插入的节点的next指向当前节点
			nodeToInsert.setNext(currentNode);
			//3 将插入位置的前一个节点的next指向新插入的节点
			previousNode.setNext(nodeToInsert);
		}
		return headNode;
	}
	
	public ListNode deleteNodeFromLinked(ListNode headNode, int position) {
		int size = getLinkLength(headNode);
		if(position > size || position < 1) {
			System.out.println("删除节点的位置不在链表范围内");
			return headNode;
		}
		if(position == 1) {
			//删除头部节点
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		}else {
			ListNode previousNode = headNode;
			int count = 1;
			while(count < size) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode.getNext());
			currentNode = null;
		}
		return headNode;
	}
}
