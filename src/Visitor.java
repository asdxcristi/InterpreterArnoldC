/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Visitor Pattern Interfata folosita de clasele de tip Visitor
 */
public interface Visitor {

	public void visit(MainNode p);

	public void visit(AndNode p);

	public void visit(AssignmentNode p);

	public void visit(BodyNode p);

	public void visit(ConditionNode p);

	public void visit(ConstantNode p);

	public void visit(DeclareNode p);

	public void visit(DifferenceNode p);

	public void visit(DivisionNode p);

	public void visit(ElseBodyNode p);

	public void visit(EqualToNode p);

	public void visit(GreaterThanNode p);

	public void visit(IfBodyNode p);

	public void visit(IfNode p);

	public void visit(LvalNode p);

	public void visit(ModuloNode p);

	public void visit(MultiplicationNode p);

	public void visit(OrNode p);

	public void visit(PrintNode p);

	public void visit(RvalNode p);

	public void visit(StringNode p);

	public void visit(SumNode p);

	public void visit(VariableNode p);

	public void visit(WhileNode p);

}
