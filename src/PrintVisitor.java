/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Visitor ce implementeaza scrierea structului ast-ului(folosit prin
 *         TreeVisitor)
 */
class PrintVisitor implements Visitor {

	private OutputHandler outputHandler;

	public PrintVisitor(String filename) {
		outputHandler = new OutputHandler(filename, ".ast");
	}

	public void stop() {
		outputHandler.stopWritingToFile();
	}

	@Override
	public void visit(MainNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");
	}

	@Override
	public void visit(AndNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(AssignmentNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(BodyNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");
	}

	@Override
	public void visit(ConditionNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
			// System.out.print("\t");
		}
		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");
	}

	@Override
	public void visit(ConstantNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");

		}
		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");

	}

	@Override
	public void visit(DeclareNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(DifferenceNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(DivisionNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");

		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(ElseBodyNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(EqualToNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(GreaterThanNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(IfBodyNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}

		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(IfNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}

		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(LvalNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");
	}

	@Override
	public void visit(ModuloNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(MultiplicationNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");
	}

	@Override
	public void visit(OrNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");
	}

	@Override
	public void visit(PrintNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}

		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(RvalNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}

		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");
	}

	@Override
	public void visit(StringNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");
	}

	@Override
	public void visit(SumNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(p.getName() + "\n");

	}

	@Override
	public void visit(VariableNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}
		outputHandler.writeStringToFile(
				p.getName() + " <" + p.getArgument() + ">\n");
	}

	@Override
	public void visit(WhileNode p) {
		for (int i = 0; i < p.getDepthLevel(); i++) {
			outputHandler.writeStringToFile("\t");
		}

		outputHandler.writeStringToFile(p.getName() + "\n");
	}

}
