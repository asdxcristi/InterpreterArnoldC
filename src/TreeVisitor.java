/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Visitor ce implementeaza parcurgerea structului ast-ului(folosit de
 *         PrintVisitor).Primeste ca parametru un Visitor care sa efectueze
 *         operatii in timpul parcurgerii
 */
class TreeVisitor implements Visitor {

	private Visitor baseVisitor;

	public TreeVisitor(Visitor baseVisitor) {
		this.baseVisitor = baseVisitor;
	}

	public Visitor getBaseVisitor() {
		return baseVisitor;
	}

	@Override
	public void visit(MainNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(AndNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(AssignmentNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(BodyNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(ConditionNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(ConstantNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(DeclareNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(DifferenceNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(DivisionNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(ElseBodyNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(EqualToNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(GreaterThanNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(IfBodyNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(IfNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(LvalNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(ModuloNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(MultiplicationNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(OrNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(PrintNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(RvalNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(StringNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(SumNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

	@Override
	public void visit(VariableNode p) {
		p.accept(baseVisitor);

	}

	@Override
	public void visit(WhileNode p) {
		p.accept(baseVisitor);
		for (Visitable it : p.getSubNodes()) {
			it.accept(this);
		}

	}

}