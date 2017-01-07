/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Clasa de baza cu functionalitatile comune pentru comenzile ce sunt
 *         frunze,dar si noduri
 */
abstract class ALeaf implements Visitable {
	protected String name;
	protected ANode parent;
	protected String argument;
	protected int depthLevel;// adancimea in arbore(folosita la indentare)

	public ALeaf(String name, String argument) {

		this.name = name;
		this.argument = argument;
	}

	public String getName() {
		return name;
	}

	public String getArgument() {
		return argument;
	}

	public int getDepthLevel() {
		return depthLevel;
	}

	public void setParrent(ANode parent) {
		this.parent = parent;
		// adancimea este dependenta de parinte
		depthLevel = parent.getDepthLevel() + 1;
	}

	public ANode getParrent() {
		return parent;
	}

	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}

}