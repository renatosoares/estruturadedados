/**
 * Classe que extende de Arvore e acrescenta métodos para adicionar 
 * nós em uma árvore e remover nós da árvore
 */
public interface ArvoreGenerica extends Arvore
{
	
	public void addChild(No v, Object o);
	
	/**
	 * @param v
	 * @return Objeto que estava na posção que foi removida
	 * @throws InvalidNoException
	 */
	public Object remove(No v) throws InvalidNoException;
}
