package MainPackage;

public class Arvore {
	
	private No raiz;
	
	public Arvore(No raiz) {
		this.raiz = raiz;
	}
	public No deleteByValue(No pos, int val) {
		No no = null;
		if (pos.dir.valor == val) {
			no = pos.dir;
			if (no.esq == null && no.dir == null) {
				pos.dir = null;	
			}else if (no.dir != null && no.esq == null) {
				pos.dir = no.dir;
			}else if (no.esq != null && no.dir == null) {
				pos.dir = no.dir;
			}else {
				 No f = pos.esq;
				 while (f.dir != null) {
				    f = f.dir;
				 }
				 pos.valor = f.valor;
				 f.valor = val;
				 pos.esq = deleteByValue(pos.esq, val);
			}
		}else if (pos.esq.valor == val) {
			no = pos.esq;
			if (no.esq == null && no.dir == null) {
				pos.esq = null;	
			}else if (no.dir != null && no.esq == null) {
				pos.esq = no.dir;
			}else if (no.esq != null && no.dir == null) {
				pos.esq = no.dir;
			}else {
				 No f = pos.esq;
				 while (f.dir != null) {
				    f = f.dir;
				 }
				 pos.valor = f.valor;
				 f.valor = val;
				 pos.esq = deleteByValue(pos.esq, val);
			}
			
		}else if (pos.valor > val) {
			deleteByValue(pos.esq, val);
		}else if(pos.valor < val) {
			deleteByValue(pos.dir, val);
		}
		return no;
	}
	public No getRaiz() {
		return raiz;
	}
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
}
