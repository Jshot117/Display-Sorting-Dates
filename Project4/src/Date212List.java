public abstract class Date212List {
    
    protected Date212Node firstNode = new Date212Node(null);
    protected Date212Node lastNode = firstNode;

    protected int length = 0;
/*append will add a node to Date212List*/
    public void append(Date212 d) {
		Date212Node newNode = new Date212Node(d);
		 lastNode.next = newNode;
		 lastNode = newNode;
		 length ++;

}
public int getLength(){
    return length;
}
}
