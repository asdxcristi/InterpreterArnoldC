/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului AssignmentNode din ast si a posibilelor noduri
 *         ce reprezinta argumentele/copii acestuia
 */
public class AssignmentNode extends ANode {
	public AssignmentNode(String varName, String valueOfVar) {
		super("AssignmentNode", "");
		setChild(varName, valueOfVar);
	}

	// adauga argumentul(copilul) acestui nod
	private void setChild(String varName, String valueOfVar) {

		addSubNode(new LvalNode(varName)); // variabila declarata

		// prechecks pentru cazuri "boolene"
		if (valueOfVar.equals(CommandSyntax.TRUE.toString())) {
			valueOfVar = "1";
		}
		if (valueOfVar.equals(CommandSyntax.FALSE.toString())) {
			valueOfVar = "0";
		}

		if (valueOfVar.charAt(0) >= '0' && valueOfVar.charAt(0) <= '9') {
			// daca e valoare
			addSubNode(new ConstantNode(valueOfVar));
		} else {// daca e variabila
			addSubNode(new RvalNode(valueOfVar));

		}
	}

	/**
	 * Reordoneaza nodurile in ordinea operatiilor,dupa ce au fost adaugate
	 * toate in nod
	 */
	public void refreshOrderChain() {
		while (subNodes.size() > 2) {// totu' pana la Lval

			Visitable first = subNodes.get(1);
			Visitable second = subNodes.get(2);

			// adaugam nodul first ca prim copil al nodului second
			((ANode) second).getSubNodes().add(0, first);
			((ALeaf) first).setParrent((ANode) second);
			((ANode) second).updateDepth();

			subNodes.remove(first);
		}
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
