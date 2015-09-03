import java.util.Vector;

public class No implements Nodo {
	private Object o;
	private No pai;
	private Vector<No> filhos = new Vector<No>();
	public No(No pai, Object o) {
		this.pai = pai;
		this.o = o;
	}
	public Object element() {
		return o;
	}
	public No parent() {
		return pai;
	}
	public void setElement(Object o) {
		this.o = o;
	}
	public void addChild(No o){
		filhos.add(o);
	}
}
