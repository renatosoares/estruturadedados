import java.util.Iterator;
import java.util.Vector;
public class ArvoreSimples implements ArvoreGenerica
{
	//Atributos da árvore
	Nó raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new Nó(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da árvore */
	public Nó root()
	{
		return raiz;
	}
	/** Retorna o nó pai de um nó */
	public Nó parent(Nó v)
	{
		return (v.parent());
	}

	/** retorna os filhos de um nó */
	public Iterator children(Nó v)
	{
		return v.children();
	}
	/** Testa se um nó é interno */
	public boolean isInternal(Nó v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um nó é externo*/
	public boolean isExternal(Nó v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um nó é a raiz */
	public boolean isRoot(Nó v)
	{
		return v == raiz;
	}
	/** Adiciona um filho a um nó */
	public void addChild(Nó v, Object o)
	{
		Nó novo = new Nó(v, o);
		v.addChild(novo);
		tamanho++;
	}
	/** Remove um nó
	 *  Só pode remover nós externos e que tenham um pai (não seja raiz)
	*/
	public Object remove(Nó v) throws InvalidNóException
	{
		Nó pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidNóException();
		Object o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posição */
	public void swapElements(Nó v, Nó w)
	{
		/*Método que serve de exercício
		 * Este método deverá fazer com que o objeto
		 * que estava na posição v fique na posição w
		 * e fazer com que o objeto que estava na posição w
		 * fique na posição v
		 */  
		
	}
	/** Retorna a profundidade de um nó */
	public int depth(Nó v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(Nó v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da árvore */
	public int height()
	{
		// Método que serve de exercício
		int altura = 0;
		return altura;
	}
	/** Retorna um iterator com os elementos armazenados na árvore */
	public Iterator elements()
	{
		// Método não implementado --- Coleguinha fique a vontade para fazê-lo
		return null;
	}
	/** Retorna um iterator com as posições (nós) da árvore */
	public Iterator Nós()
	{
		// Método não implementado --- Coleguinha fique a vontade para fazê-lo
		return null;
	}
	/** Retorna o número de nós da árvore
	 */
	public int size()
	{
		return 0;
	}
	/** Retorna se a ávore está vazia. Sempre vai ser falso, pois não permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(Nó v, Object o)
	{
		// Método de exercício
		return null;
	}
	/* Início da classe aninhada para armazenar o nó*/
	private class No implements Nó
	{
		private Object o;
		private Nó pai;
		private Vector filhos = new Vector();
		public Nó(Nó pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public Nó parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(Nó o)
		{
			filhos.add(o);
		}
		public void removeChild(Nó o)
		{
			filhos.remove(o);
		}
		public int childrenNumber()
		{
			return filhos.size();
		}
		public Iterator children()
		{
			return filhos.iterator();
		}
	}
	/* Fim da classe aninhada para armazenar o nó */
}
