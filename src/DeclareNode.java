/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului DeclareNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class DeclareNode extends ANode {

	public DeclareNode(String varName, String valueOfVar) {
		super("DeclareNode", "");
		setChildren(varName, valueOfVar);
	}

	// adauga argumentelor(copiilor) acestui nod
	private void setChildren(String varName, String valueOfVar) {

		addSubNode(new LvalNode(varName)); // adauga variabila nou declarata

		// prechecks pentru cazuri "boolene"
		if (valueOfVar.equals(CommandSyntax.TRUE.toString())) {
			valueOfVar = "1";
		}
		if (valueOfVar.equals(CommandSyntax.FALSE.toString())) {
			valueOfVar = "0";
		}

		// valoarea variabilei declarate
		addSubNode(new ConstantNode(valueOfVar));
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
