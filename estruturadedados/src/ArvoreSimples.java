public class ArvoreSimples implements ArvoreGenerica
{
	//Atributos da árvore
	No raiz;
	int tamanho;
	//Construtor
	public ArvoreSimples(Object o)
	{
		tamanho = 1;
		raiz = new No(null , o);
	}
	public No root (){
		return raiz;
	}
	@Override
	public void addChild(No v, Object o) {
		// TODO Auto-generated method stub
		No novo = new No(v, o);
		v.addChild(novo);
		tamanho++;
		
	}
	@Override
	public Object remove(No v) throws InvalidNoException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
