import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(1, "aaa", 12);
		Pessoa p2 = new Pessoa(2, "bbb", 13);
		Pessoa p3 = new Pessoa(3, "ccc", 14);
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		
		Pageable pag = new Pageable();
		pag.setItens((List<Object>)(List<?>)pessoas);
		
		for(Pessoa p : (List<Pessoa>)(List<?>)pag.getItens()){
			System.out.println(p.getNome()+" "+ p.getIdade());
		}
	}

}
