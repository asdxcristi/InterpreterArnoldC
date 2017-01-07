/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului DivisionNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class DivisionNode extends ANode {
	public DivisionNode(String argument) {
		super("DivisionNode", "");
		setChild(argument);
	}

	// adauga argumentul(copilul) acestui nod
	private void setChild(String argument) {

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
