/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Reprezentarea nodului PrintNode din ast si a posibilelor noduri ce
 *         reprezinta argumentele/copii acestuia
 */
public class PrintNode extends ANode implements Visitable {

	public PrintNode(String argument) {
		super("PrintNode", "");
		setChild(argument);
	}

	private void setChild(String argument) {

		if (argument.contains("\"")) {// argumentul e String
			argument = argument.replace("\"", "");
			addSubNode(new StringNode(argument));
		} else { // //argumentul e variabila
			addSubNode(new VariableNode(argument));
		}

	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
