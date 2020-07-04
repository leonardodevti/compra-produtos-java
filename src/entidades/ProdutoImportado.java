package entidades;

public class ProdutoImportado extends Produto {

	private Double taxaAlfandega;

	public ProdutoImportado() {

	}

	public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
		super(nome, preco);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double precoTotal() {
		return getPreco() + taxaAlfandega;
	}

	@Override
	public final String etiquetaPreco() {//Sobrescrevendo o m�todo da superclasse, para acrescentar a taxa de alf�ndega na etiqueta.
		return getNome() +
				" R$" + String.format("%.2f", precoTotal()) +
				" (Taxa de Alf�ndega: R$ "+ 
				String.format("%.2f", taxaAlfandega) +
				")";

	}
}
