/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului WhileNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class WhileNode extends ANode {

	public WhileNode(String condition) {
		super("WhileNode", "");
		setChild(condition);
	}

	private void setChild(String condition) {

		if (condition.equals(CommandSyntax.TRUE.toString())) {
			condition = "1";
		}

		if (condition.equals(CommandSyntax.FALSE.toString())) {
			condition = "0";
		}

		addSubNode(new ConditionNode(condition)); // conditia din while
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
