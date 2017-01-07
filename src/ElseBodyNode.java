/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului ElseBodyNode din ast
 */
public class ElseBodyNode extends ANode {

	public ElseBodyNode() {
		super("ElseBodyNode", "");
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
