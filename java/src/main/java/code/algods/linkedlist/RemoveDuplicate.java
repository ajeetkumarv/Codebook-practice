package code.algods.linkedlist;

public class RemoveDuplicate {

    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        //Create LinkedList
        int[] array = {1,1,3,4,4,4,5,6,6};
        LinkedList list = new LinkedList(1);
        LinkedList curr = list;

        for (int i = 1; i < array.length;i++) {
            LinkedList element = new LinkedList(array[i]);
            curr.next = element;
            curr = element;
        }
        curr.next = null;

        printLinkedList(list);
        //removeDuplicates(list);
        removeDups(list);
        printLinkedList(list);
    }

    private static LinkedList removeDuplicates(LinkedList list) {

        LinkedList curr = list;
        LinkedList next = list.next;

        while(next != null) {
            if (curr.value == next.value) {
                next = next.next; // dodge the exiting next bcz same as curr
                curr.next = next; // free the memory of old next
            } else {
                curr.next = next; // bcz the actual next can be moved by previous matches in if
                curr = next;
                next = next.next;
            }

            curr.next = next;
        }

        curr.next = null;

        return list;
    }

    private static LinkedList removeDups(LinkedList linkedList) {
        LinkedList currNode = linkedList;
        while (currNode != null) {
            LinkedList nextDistinctNode = currNode.next;
            while (nextDistinctNode != null && nextDistinctNode.value == currNode.value) {
                nextDistinctNode = nextDistinctNode.next;
            }

            currNode.next = nextDistinctNode; // link last node to newly found distinct node
            currNode = nextDistinctNode; // ready for operation with newly found node
        }

        return linkedList;
    }

    private static void printLinkedList(LinkedList list) {
        while (list != null) {
            System.out.print(list.value + " -> ");
            list = list.next;
        }

        System.out.println("null");
    }
}
