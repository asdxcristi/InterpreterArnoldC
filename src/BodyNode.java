/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului BodyNode din ast
 */
public class BodyNode extends ANode {

	public BodyNode() {
		super("BodyNode", "");
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
