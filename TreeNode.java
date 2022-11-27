/**
 * A tree node data type that is used for constructing binary trees
 * @author Amir Hawasly
 *
 * @param <T>
 */
public class TreeNode<T> {
	public T data;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(T data) {
		this.data = data;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	/**
	 * 
	 * @return returns the data stored within the node
	 */
	public T getData() {
		return data;
	}
}
