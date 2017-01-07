/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului StringNode din ast
 */
public class StringNode extends ALeaf implements Visitable {

	public StringNode(String argument) {
		super("StringNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
