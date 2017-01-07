/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului IfNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class IfNode extends ANode {
	public IfNode(String condition) {
		super("IfNode", "");
		setChild(condition);
	}

	// adauga argumentul(copilul) acestui nod
	private void setChild(String condition) {
		// prechecks pentru cazuri "boolene"
		if (condition.equals(CommandSyntax.TRUE.toString())) {
			condition = "1";
		}
		if (condition.equals(CommandSyntax.FALSE.toString())) {
			condition = "0";
		}
		// adaugam conditia
		addSubNode(new ConditionNode(condition));
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
