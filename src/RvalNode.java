/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului RvalNode din ast
 */
public class RvalNode extends ALeaf {

	public RvalNode(String argument) {
		super("RvalNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
