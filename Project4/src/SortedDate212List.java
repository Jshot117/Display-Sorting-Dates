public class SortedDate212List extends Date212List {
    public SortedDate212List(){
        super();
    }
    /* this method is going to create a sorted Date212list in order to display it as a sorted list*/
    public void add(Date212 Node){
        Date212Node newDateNode = new Date212Node(Node);
        if ( lastNode.data==null || newDateNode.data.compareTo(lastNode.data)==1){
            append(Node);
        }
        else {
            Date212Node temp = firstNode;
            while(true){
                if(newDateNode.data.compareTo(temp.next.data)== -1 || newDateNode.data.equals(temp.next.data)){
                   newDateNode.next = newDateNode;
                   temp.next = newDateNode;
                   length++;
                   return;
                }
                temp= temp.next;
            }
        }


    }
    
}
