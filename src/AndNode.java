/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului AndNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class AndNode extends ANode {
	public AndNode(String argument) {
		super("AndNode", "");
		setChild(argument);
	}

	// adauga argumentul(copilul) acestui nod
	private void setChild(String argument) {

		// prechecks pentru cazuri "boolene"
		if (argument.equals(CommandSyntax.TRUE.toString())) {
			argument = "1";
		}
		if (argument.equals(CommandSyntax.FALSE.toString())) {
			argument = "0";
		}
		if (argument.charAt(0) >= '0' && argument.charAt(0) <= '9') {
			// daca e valoare
			addSubNode(new ConstantNode(argument));
		} else {// daca e variabila
			addSubNode(new RvalNode(argument));

		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
