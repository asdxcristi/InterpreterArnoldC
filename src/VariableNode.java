/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului VariableNode(copil al lui PrintNode) din ast
 */
public class VariableNode extends ALeaf implements Visitable {

	public VariableNode(String argument) {
		super("VariableNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
