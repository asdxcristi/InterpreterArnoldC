/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului MultiplicationNodeNode din ast si a posibilelor
 *         noduri ce reprezinta argumentele/copii acestuia
 */
public class MultiplicationNode extends ANode {

	public MultiplicationNode(String argument) {
		super("MultiplicationNode", "");
		setChild(argument);
	}

	// adauga argumentul(copilul) acestui nod
	private void setChild(String argument) {

		// daca e valoare
		if (argument.charAt(0) >= '0' && argument.charAt(0) <= '9') {
			addSubNode(new ConstantNode(argument));
		} else {// daca e variabila
			addSubNode(new RvalNode(argument));
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
