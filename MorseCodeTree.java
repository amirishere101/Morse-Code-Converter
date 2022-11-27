import java.util.ArrayList;
/**
 * The Building of a morse code binary tree
 * @author Amir Hawasly
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;
	private final String DOT = ".";
	private final String DASH = "-";
	
	public MorseCodeTree() {
		buildTree();
	}
	@Override
	public TreeNode<String> getRoot() {
		TreeNode<String> root = this.root;
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}

	@Override
	public void insert(String code, String result) {
		addNode(getRoot(), code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if (code.equals(DOT)){
				root.left = new TreeNode<String>(letter);
			}
			else if (code.equals(DASH)){
				root.right = new TreeNode<String>(letter);
			}
		} else {
			if(code.substring(0, 1).equals(DOT)) {
				addNode(root.left, code.substring(1), letter);
			} else if(code.substring(0, 1).equals(DASH)){
				addNode(root.right, code.substring(1), letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(getRoot(), code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(code.length() == 1){
			if(code.equals(DASH)) {
				return (String)root.right.getData();
			} else if(code.equals(DOT)) {
				return (String)root.left.getData();
			}
		} else {
			if(code.substring(0,1).equals(DASH)) {
				return fetchNode(root.right, code.substring(1));
			} else if(code.substring(0,1).equals(DOT)) {
				return fetchNode(root.left, code.substring(1));
			}
		}
		return "";
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {
		TreeNode<String> rootNode = new TreeNode<String>("");
		setRoot(rootNode);
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> tree = new ArrayList<String>();
		LNRoutputTraversal(getRoot(), tree);
		return tree;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}
	}
}
