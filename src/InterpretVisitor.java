import java.util.ArrayList;

/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Visitor ce implementeaza interpretarea comenzilor
 */
class InterpretVisitor implements Visitor {
	/**
	 * @author Ionut-Cristian Bucur, 323CA
	 * 
	 *         Folosita in momentul interpretarii,pentru a retine variabilele
	 *         existente in program
	 */
	public class Variable {
		private String name;
		private String value;

		public void setValue(String value) {
			this.value = value;
		}

		public Variable(String name, String value) {
			this.name = name;
			this.value = value;

		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}

	}

	private OutputHandler outputHandler;
	private ArrayList<Variable> variables;
	private Variable currentVariable;
	private int tempResult; // retine valorea ultimei "operatii" executate

	public InterpretVisitor(String filename) {
		outputHandler = new OutputHandler(filename, ".out");
		variables = new ArrayList<Variable>();
		currentVariable = null;
		tempResult = 0;
	}

	/**
	 * Opreste scrierea in fisier(folosita dupa sfarsitul interpretarii)
	 */
	public void stop() {
		outputHandler.stopWritingToFile();
	}

	@Override
	public void visit(PrintNode p) {
		p.getSubNodes().get(0).accept(this);
	}

	@Override
	public void visit(MainNode p) {
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(AndNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		if (firstArg != 0 && secondArg != 0) {
			tempResult = 1;
		} else {
			tempResult = 0;
		}

	}

	@Override
	public void visit(AssignmentNode p) {
		p.getSubNodes().get(0).accept(this);
		p.getSubNodes().get(1).accept(this);
		currentVariable.setValue(Integer.toString(tempResult));

	}

	@Override
	public void visit(BodyNode p) {
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(ConditionNode p) {
		Variable condition = findVariable(p.getArgument());
		tempResult = Integer.parseInt(condition.getValue());
	}

	@Override
	public void visit(ConstantNode p) {
		tempResult = Integer.parseInt(p.getArgument());

	}

	@Override
	public void visit(DeclareNode p) {
		String varName = ((ALeaf) p.getSubNodes().get(0)).getArgument();
		String varVal = ((ALeaf) p.getSubNodes().get(1)).getArgument();
		variables.add(new Variable(varName, varVal));

	}

	@Override
	public void visit(DifferenceNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		tempResult = firstArg - secondArg;

	}

	@Override
	public void visit(DivisionNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		tempResult = firstArg / secondArg;

	}

	@Override
	public void visit(ElseBodyNode p) {

		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(EqualToNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		if (firstArg == secondArg) {
			tempResult = 1;
		} else {
			tempResult = 0;
		}

	}

	@Override
	public void visit(GreaterThanNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		if (firstArg > secondArg) {
			tempResult = 1;
		} else {
			tempResult = 0;
		}

	}

	@Override
	public void visit(IfBodyNode p) {
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}
	}

	@Override
	public void visit(IfNode p) {
		p.getSubNodes().get(0).accept(this);
		if (tempResult == 1) {
			p.getSubNodes().get(1).accept(this);
		} else {
			// daca are si ElseBody
			if (p.getSubNodes().size() == 3) {
				p.getSubNodes().get(2).accept(this);
			}

		}

	}

	@Override
	public void visit(LvalNode p) {
		currentVariable = findVariable(p.getArgument());

	}

	@Override
	public void visit(ModuloNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		tempResult = firstArg % secondArg;

	}

	@Override
	public void visit(MultiplicationNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		tempResult = firstArg * secondArg;

	}

	@Override
	public void visit(OrNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		if (firstArg == 0 && secondArg == 0) {
			tempResult = 0;
		} else {
			tempResult = 1;
		}

	}

	@Override
	public void visit(RvalNode p) {
		Variable rval = findVariable(p.getArgument());
		tempResult = Integer.parseInt(rval.getValue());

	}

	@Override
	public void visit(StringNode p) {
		outputHandler.writeStringToFile(p.getArgument() + "\n");

	}

	@Override
	public void visit(SumNode p) {
		int firstArg;
		int secondArg;
		p.getSubNodes().get(0).accept(this);
		firstArg = tempResult;
		p.getSubNodes().get(1).accept(this);
		secondArg = tempResult;
		tempResult = firstArg + secondArg;

	}

	@Override
	public void visit(VariableNode p) {
		for (Variable it : variables) {
			if (it.getName().equals(p.getArgument())) {
				outputHandler.writeStringToFile(it.getValue() + "\n");
				break;
			}
		}

	}

	@Override
	public void visit(WhileNode p) {
		while (true) {
			// executam cat timp conditia este adevarata
			p.getSubNodes().get(0).accept(this);
			if (tempResult == 1) {
				p.getSubNodes().get(1).accept(this);
			} else {
				break;
			}
		}

	}

	/*
	 * Verifica daca variabila @varName exista in contextul interpretarii
	 * curente
	 * 
	 * @return null daca nu a fost gasita variabila @varName
	 */
	private Variable findVariable(String varName) {
		for (Variable it : variables) {
			if (it.getName().equals(varName)) {
				return it;
			}
		}
		return null;
	}
}