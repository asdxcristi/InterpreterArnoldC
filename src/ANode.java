import java.util.ArrayList;

/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Clasa de baza cu functionalitatile comune pentru comenzile ce sunt
 *         noduri(contine si functionalitatile ALeaf)
 */
abstract class ANode extends ALeaf {

	protected ArrayList<Visitable> subNodes;

	public ANode(String name, String argument) {
		super(name, argument);
		subNodes = new ArrayList<Visitable>();
		parent = null;
	}

	public ArrayList<Visitable> getSubNodes() {
		if (!subNodes.isEmpty()) {
			return subNodes;
		}
		return null;
	}

	@Override
	public void setParrent(ANode parent) {
		super.setParrent(parent);
		// updatam depthLevelul copiilor
		updateDepth();
	}

	/**
	 * Updateaza depthLevelul copiilor nodului in functie de nivelul parintelui
	 * 
	 */
	protected void updateDepth() {
		for (Visitable it : subNodes) {
			((ALeaf) it).setDepthLevel(depthLevel + 1);
		}
	}

	/**
	 * Adauga un subnod(frunza sau nod)
	 * 
	 */
	protected void addSubNode(ALeaf subordinate) {

		subordinate.setParrent(this);
		subordinate.setDepthLevel(this.getDepthLevel() + 1);

		subNodes.add(subordinate);

	}

}