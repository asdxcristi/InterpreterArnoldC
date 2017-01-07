/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentare a Abstract Syntax Tree Incepe de la root Are la baza un
 *         nod curent pe care se pot efectua diferite operatii
 */
public class AST {

	private MainNode root;
	private ANode current;

	public AST() {
		root = new MainNode();
		root.setDepthLevel(0);
		current = root;
	}

	public ANode getCurrentNode() {
		return current;
	}

	public ANode getRootNode() {
		return root;
	}

	public void setCurrentNode(ANode newCurrent) {
		current = newCurrent;
	}

	public void addNodeToCurrent(ANode newNode) {
		current.addSubNode(newNode);
	}

}
