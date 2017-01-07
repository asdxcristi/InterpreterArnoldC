/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Clasa ce are rol simbolic de CLI
 */
public class CommandLineInterface {

	public static void main(String[] args) {

		InputHandler inputHandler = new InputHandler(args[0]);
		AST ast = new AST();

		CommandHandler commandHandler = new CommandHandler(inputHandler, ast);
		commandHandler.parseCommands();

		// Print-ul structurii ast-ului
		Visitor v = new PrintVisitor(args[0]);
		Visitor tree = new TreeVisitor(v);
		ast.getRootNode().accept(tree);
		((PrintVisitor) v).stop();

		// Interpretarea ast-ului
		v = new InterpretVisitor(args[0]);
		ast.getRootNode().accept(v);
		((InterpretVisitor) v).stop();

	}

}
