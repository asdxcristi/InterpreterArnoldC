/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului SumNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class SumNode extends ANode {

	public SumNode(String argument) {
		super("SumNode", "");
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

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
