/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului ConditionNode din ast si a posibilelor noduri
 *         ce reprezinta argumentele/copii acestuia
 */
public class ConditionNode extends ALeaf {

	public ConditionNode(String argument) {
		super("ConditionNode", argument);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
