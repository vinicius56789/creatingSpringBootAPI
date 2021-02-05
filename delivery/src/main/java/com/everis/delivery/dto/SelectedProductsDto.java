//package com.everis.delivery.dto;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import com.everis.delivery.model.Product;
//import com.everis.delivery.model.SelectedProducts;
//import com.everis.delivery.model.Shopping;
//import com.everis.delivery.repository.ShoppingRepository;
//
//public class SelectedProductsDto {
//
//	private Long shoppingId;
//	private Long productId;
//	private int quantidade;
//	private Product product;
//
//	public SelectedProductsDto(SelectedProducts produtos) {
//		this.productId = produtos.getId();
//		this.quantidade = produtos.getQuantidade();
//		this.product = produtos.getProduct();
//	}
//
//	public SelectedProductsDto() {
//	}
//
//	public Long getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Long productId) {
//		this.productId = productId;
//	}
//
//	public int getQuantidade() {
//		return quantidade;
//	}
//
//	public void setQuantidade(int quantidade) {
//		this.quantidade = quantidade;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	public Long getShoppingId() {
//		return shoppingId;
//	}
//
//	public void setShoppingId(Long shoppingId) {
//		this.shoppingId = shoppingId;
//	}
//
//	public static List<SelectedProductsDto> converter(List<SelectedProducts> produtos) {
//		return produtos.stream().map(SelectedProductsDto::new).collect(Collectors.toList());
//	}
//
//	public SelectedProducts cadastrarProdutosSelecionados(ShoppingRepository shoppingRepository) {
//		Optional<Shopping> shopping = shoppingRepository.findById(shoppingId);
//		return new SelectedProducts(shopping.get().getId(), product, quantidade);
//	}
//}
