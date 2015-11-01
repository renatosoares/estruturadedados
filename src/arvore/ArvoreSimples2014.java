import java.util.Iterator;
import java.util.Vector;
public class ArvoreSimples implements ArvoreGenerica
{
	//Atributos da �rvore
	N� raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		raiz = new N�(null, o);
		tamanho = 1;
	}
	/** Retorna a raiz da �rvore */
	public N� root()
	{
		return raiz;
	}
	/** Retorna o n� pai de um n� */
	public N� parent(N� v)
	{
		return (v.parent());
	}

	/** retorna os filhos de um n� */
	public Iterator children(N� v)
	{
		return v.children();
	}
	/** Testa se um n� � interno */
	public boolean isInternal(N� v)
	{
		return (v.childrenNumber() > 0);
	}
	/** Testa se um n� � externo*/
	public boolean isExternal(N� v)
	{
		return (v.childrenNumber() == 0);
	}
	/** Testa se um n� � a raiz */
	public boolean isRoot(N� v)
	{
		return v == raiz;
	}
	/** Adiciona um filho a um n� */
	public void addChild(N� v, Object o)
	{
		N� novo = new N�(v, o);
		v.addChild(novo);
		tamanho++;
	}
	/** Remove um n�
	 *  S� pode remover n�s externos e que tenham um pai (n�o seja raiz)
	*/
	public Object remove(N� v) throws InvalidN�Exception
	{
		N� pai = v.parent();
		if (pai != null || isExternal(v))
			pai.removeChild(v);
		else
			throw new InvalidN�Exception();
		Object o = v.element();
		tamanho--;
		return o;
	}
	/** Troca dois elementos de posi��o */
	public void swapElements(N� v, N� w)
	{
		/*M�todo que serve de exerc�cio
		 * Este m�todo dever� fazer com que o objeto
		 * que estava na posi��o v fique na posi��o w
		 * e fazer com que o objeto que estava na posi��o w
		 * fique na posi��o v
		 */  
		
	}
	/** Retorna a profundidade de um n� */
	public int depth(N� v)
	{
		int profundidade = profundidade(v);
		return profundidade;
	}
	private int profundidade(N� v)
	{
		if (v == raiz)
			return 0;
		else
			return 1 + profundidade(v.parent());
	}
	/** Retorna a altura da �rvore */
	public int height()
	{
		// M�todo que serve de exerc�cio
		int altura = 0;
		return altura;
	}
	/** Retorna um iterator com os elementos armazenados na �rvore */
	public Iterator elements()
	{
		// M�todo n�o implementado --- Coleguinha fique a vontade para faz�-lo
		return null;
	}
	/** Retorna um iterator com as posi��es (n�s) da �rvore */
	public Iterator N�s()
	{
		// M�todo n�o implementado --- Coleguinha fique a vontade para faz�-lo
		return null;
	}
	/** Retorna o n�mero de n�s da �rvore
	 */
	public int size()
	{
		return 0;
	}
	/** Retorna se a �vore est� vazia. Sempre vai ser falso, pois n�o permitimos remover a raiz
	 */
	public boolean isEmpty()
	{
		return false;
	}
	public Object replace(N� v, Object o)
	{
		// M�todo de exerc�cio
		return null;
	}
	/* In�cio da classe aninhada para armazenar o n�*/
	private class No implements N�
	{
		private Object o;
		private N� pai;
		private Vector filhos = new Vector();
		public N�(N� pai, Object o)
		{
			this.pai = pai;
			this.o = o;
		}
		public Object element()
		{
			return o;
		}
		public N� parent()
		{
			return pai;
		}
		public void setElement(Object o)
		{
			this.o = o;
		}
		public void addChild(N� o)
		{
			filhos.add(o);
		}
		public void removeChild(N� o)
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
	/* Fim da classe aninhada para armazenar o n� */
}
