package hackerrank.preparation.interview.arcesium;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class FindMergePointofTwoLists
{
    static class SinglyLinkedListNode
    {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData)
        {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList
    {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList()
        {
            this.head = null;
            this.tail = null;
        }
        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null)
            {
                this.head = node;
            }
            else
            {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        int nodeData=0;
        Set<SinglyLinkedListNode> nodeList = new HashSet<>();
        while(head1!=null){
            nodeList.add(head1);
            head1=head1.next;
        }
        while(head2!=null){
            if(nodeList.contains(head2)){
                nodeData=head2.data;
                break;
            }
            head2=head2.next;
        }
        return nodeData;
    }
}
