package arvoreBinaria;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Arvore {
	No raiz;
	int tamanho;
	public Arvore(int n) {
		raiz = new No(null, n);
		tamanho = 1;
	}
	public No root() {
		return raiz;
	}
	public void addChild(No v, int nd) {
		No novo = new No(v, nd);
		v.addChild(novo);
		tamanho++;
	}
	/** Retorna o nó pai de um nó */
	public No parent(No nd) {
		return (nd.parent());
	}
	
	/** retorna os filhos de um nó */
	public Iterator children(No nd){
		return nd.children();
	}
}
