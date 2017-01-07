import java.util.StringTokenizer;

/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Clasa ce se ocupa de parsarea comenzilor din fisier Construieste ast
 */
public class CommandHandler {

	private InputHandler inputHandler;
	private AST ast;

	public CommandHandler(InputHandler inputHandler, AST ast) {
		this.inputHandler = inputHandler;
		this.ast = ast;
	}

	/**
	 * Citeste comenzile primite prin inputHandler.Construieste ast adaugand
	 * nodul corespunzator comenzii curente
	 */
	public void parseCommands() {
		String currentFullCommand;
		currentFullCommand = inputHandler.getNextLine();

		if (currentFullCommand == null || !currentFullCommand
				.equals(CommandSyntax.BEGIN_MAIN.toString())) {
			return;// Nu respecta regulile de inceput main #modifica aici pentru
					// adaugat functii
		}

		// luam comenzile incepand cu urmatoarea linie dupa BEGIN_MAIN
		while (currentFullCommand != null && !currentFullCommand
				.equals(CommandSyntax.END_MAIN.toString())) {

			currentFullCommand = inputHandler.getNextLine();

			// extragem comanda din linie
			CommandSyntax currentCommand = getCommandType(currentFullCommand);

			// verificam daca comanda este un legitima sau daca am ajuns la
			// final
			if (currentCommand == null
					|| currentCommand.equals(CommandSyntax.END_MAIN)) {
				continue;
			}

			// verificam daca comanda este sfarsitul unei comenzi anterioare
			if (isCommandEnd(currentCommand)) {
				if (currentCommand.equals(CommandSyntax.END_ASSIGN_VARIABLE)) {
					((AssignmentNode) ast.getCurrentNode()).refreshOrderChain();
				}
				if (currentCommand.equals(CommandSyntax.END_IF)
						|| currentCommand.equals(CommandSyntax.END_WHILE)) {
					// iesim din ifBody,dupa din if
					ast.setCurrentNode(ast.getCurrentNode().getParrent());
				}
				ast.setCurrentNode(ast.getCurrentNode().getParrent());
				continue;// ignoram liniile astea
			}

			StringTokenizer argument = getArgumentOfCommand(currentCommand,
					currentFullCommand);
			String currentArgument = "";
			if (argument != null) {// QUICK FIX pt Else
				currentArgument = argument.nextToken();
			}

			switch (currentCommand) {

			case DECLARE_INT:
				String varName = currentArgument;
				// declare e mereu urmat de set
				currentFullCommand = inputHandler.getNextLine();
				currentCommand = getCommandType(currentFullCommand);
				argument = getArgumentOfCommand(currentCommand,
						currentFullCommand);

				String valueOfVar = argument.nextToken();

				DeclareNode declareNode = new DeclareNode(varName, valueOfVar);
				ast.addNodeToCurrent(declareNode);

				continue;

			case PRINT:

				PrintNode printNode = new PrintNode(currentArgument);
				ast.addNodeToCurrent(printNode);

				continue;

			case ASSIGN_VARIABLE:

				String varToBeAss = currentArgument;
				// assign e mereu urmat de set
				currentFullCommand = inputHandler.getNextLine();
				currentCommand = getCommandType(currentFullCommand);
				argument = getArgumentOfCommand(currentCommand,
						currentFullCommand);

				String valueToBeAss = argument.nextToken();

				AssignmentNode assignmentNode = new AssignmentNode(varToBeAss,
						valueToBeAss);
				ast.addNodeToCurrent(assignmentNode);
				ast.setCurrentNode(assignmentNode);

				continue;

			case MULTIPLICATION_OPERATOR:

				String multiOperand = currentArgument;
				MultiplicationNode multiplicationNode = new MultiplicationNode(
						multiOperand);

				ast.addNodeToCurrent(multiplicationNode);

				continue;

			case PLUS_OPERATOR:

				String sumOperand = currentArgument;
				SumNode sumNode = new SumNode(sumOperand);

				ast.addNodeToCurrent(sumNode);

				continue;

			case MINUS_OPERATOR:

				String diffOperand = currentArgument;
				DifferenceNode differenceNode = new DifferenceNode(diffOperand);

				ast.addNodeToCurrent(differenceNode);

				continue;

			case DIVISION_OPERATOR:

				String divOperand = currentArgument;
				DivisionNode divisionNode = new DivisionNode(divOperand);

				ast.addNodeToCurrent(divisionNode);

				continue;

			case MODULO_OPERATOR:

				String modOperand = currentArgument;
				ModuloNode moduloNode = new ModuloNode(modOperand);

				ast.addNodeToCurrent(moduloNode);

				continue;

			case AND:

				String andOperand = currentArgument;
				AndNode andNode = new AndNode(andOperand);

				ast.addNodeToCurrent(andNode);

				continue;

			case OR:

				String orOperand = currentArgument;
				OrNode orNode = new OrNode(orOperand);

				ast.addNodeToCurrent(orNode);

				continue;

			case GREATER_THAN:

				String gOperand = currentArgument;
				GreaterThanNode gNode = new GreaterThanNode(gOperand);

				ast.addNodeToCurrent(gNode);

				continue;

			case EQUAL_TO:

				String eqOperand = currentArgument;
				EqualToNode eqNode = new EqualToNode(eqOperand);

				ast.addNodeToCurrent(eqNode);

				continue;

			case IF:

				String valToBeChecked = currentArgument;
				IfNode ifNode = new IfNode(valToBeChecked);
				IfBodyNode ifBodyNode = new IfBodyNode();

				ifNode.addSubNode(ifBodyNode);

				ast.addNodeToCurrent(ifNode);
				ast.setCurrentNode(ifBodyNode);

				continue;

			case ELSE:

				// iesim din IfBody in If
				ast.setCurrentNode(ast.getCurrentNode().getParrent());
				ElseBodyNode elseBodyNode = new ElseBodyNode();

				ast.addNodeToCurrent(elseBodyNode);
				ast.setCurrentNode(elseBodyNode);

				continue;

			case WHILE:

				String whileCondition = currentArgument;
				WhileNode whileNode = new WhileNode(whileCondition);
				BodyNode bodyNode = new BodyNode();

				whileNode.addSubNode(bodyNode);

				ast.addNodeToCurrent(whileNode);
				ast.setCurrentNode(bodyNode);

				continue;

			default:

				continue;

			}

		}

	}

	/*
	 * Verifica daca @command este sfaristul unei comenzi
	 */
	private boolean isCommandEnd(CommandSyntax command) {
		switch (command) {
		case END_IF:
			return true;
		case END_WHILE:
			return true;
		case END_ASSIGN_VARIABLE:
			return true;
		default:
			break;
		}
		return false;
	}

	public StringTokenizer getArgumentOfCommand(CommandSyntax command,
			String fullCommand) {

		String arg = fullCommand.replace(command.toString() + " ", "");

		if (arg.equals(fullCommand)) {
			return null;// nu are argument
		} else {
			// e print si poate avea un sigur argument intre ""
			if (arg.contains("\"")) {
				return new StringTokenizer(arg, "");
			}
			if (arg.contains("@")) {// ne jucam cu boolene
				return new StringTokenizer(arg, "@");
			}
			// are mai multe argumente intre "" cu spatiu intre ele
			return new StringTokenizer(arg, " ");
		}
	}

	/*
	 * Verifica si returneaza tipul comenzii @command
	 * 
	 * @return null daca nu este una legitima
	 */
	private CommandSyntax getCommandType(String command) {
		String type;

		for (CommandSyntax it : CommandSyntax.values()) {
			type = it.toString();
			if (command.startsWith(type)) {
				return it;
			}

		}
		return null;
	}
}
