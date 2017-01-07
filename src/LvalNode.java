/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului LvalNode din ast
 */
public class LvalNode extends ALeaf {

	public LvalNode(String argument) {
		super("LvalNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
