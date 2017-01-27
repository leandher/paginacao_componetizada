import java.util.List;


public class Pageable {
	private List<Object> itens;
	private Integer pageAtual;
	private Integer totalProdutos;
	
	public List<Object> getItens() {
		return itens;
	}
	
	public void setItens(List<Object> itens) {
		this.itens = itens;
	}
	
	public Integer getPageAtual() {
		return pageAtual;
	}
	
	public void setPageAtual(Integer pageAtual) {
		this.pageAtual = pageAtual;
	}
	
	public Integer getTotalProdutos() {
		return totalProdutos;
	}
	
	public void setTotalProdutos(Integer totalProdutos) {
		this.totalProdutos = totalProdutos;
	}
}
