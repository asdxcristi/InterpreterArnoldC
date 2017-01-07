/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului ConstantNode din ast
 */
public class ConstantNode extends ALeaf {

	public ConstantNode(String argument) {
		super("ConstantNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
