package com.lk.java.link;

public class FindNthFromLinked {
	/**
	 * 从链表中找到倒数第n个节点，支循环一次
	 * @param head
	 * @param nthNode
	 * @return
	 */
	public ListNode NthNodeFromEnd(ListNode head, int nthNode) {
		//定义两个位置 坐标
		ListNode pTemp = head,pNthNode = null;
		//1 找到第n个节点
		for(int i = 1; i < nthNode; i++) {
			if(pTemp !=null)
				pTemp = pTemp.getNext();
		}
		//2 pNthNode倒数第n个节点的坐标
		while(pTemp != null) {
			if(pNthNode == null) {
				pNthNode = head;
			}else {
				pNthNode = pNthNode.getNext();
			}
			pTemp = pTemp.getNext();
			
		}
		if(pNthNode != null)
			return pNthNode;
		return null;
	}
}
