/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului IfBodyNode
 */
public class IfBodyNode extends ANode {

	public IfBodyNode() {
		super("IfBodyNode", "");
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
