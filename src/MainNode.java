/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului MainNode(root) din ast
 */
public class MainNode extends ANode implements Visitable {

	public MainNode() {
		super("MainNode", "");
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
