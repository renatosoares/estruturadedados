package arvoreBinaria;

import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class No {
	private int n;
	private No pai;
	private Vector<No> filhos = new Vector<No>();
	public No(No pai, int n) {
		this.pai = pai;
		this.n = n;
	}
	public int element() {
		return n;
	}
	public No parent() {
		return pai;
	}
	public void setElement(int n) {
		this.n = n;
	}
	public void addChild(No nd) {
		filhos.add(nd);
	}
	public void removeChild(No nd) {
		filhos.remove(nd);
	}
	public int childrenNumber() {
		return filhos.size();
	}
	public Iterator children() {
		return (Iterator) filhos.iterator();
	}
	
}
