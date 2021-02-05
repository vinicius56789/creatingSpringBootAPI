package com.everis.delivery.controller;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.everis.delivery.dto.ShoppingDto;
import com.everis.delivery.model.Product;
import com.everis.delivery.model.SelectedProducts;
import com.everis.delivery.model.Shopping;
import com.everis.delivery.repository.ClientRepository;
import com.everis.delivery.repository.ProductRepository;
import com.everis.delivery.repository.SelectedProductsRepository;
import com.everis.delivery.repository.ShoppingRepository;

@RestController
@RequestMapping("/compras")
public class ShoppingController {
	
	@Autowired
	private ShoppingRepository shoppingRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private SelectedProductsRepository spRepository;
	
	@GetMapping
	public List<ShoppingDto> listarTodasCompras(){
		List<Shopping> compras = shoppingRepository.findAll();
		return ShoppingDto.converter(compras);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ShoppingDto> CadastrarCompraEProdutosSelecionados(@RequestBody @Valid ShoppingDto dto){
		Shopping shopping = dto.CadastrarShopping(clientRepository);
		List<SelectedProducts> product = shopping.getListOfPurchasedProducts();
//		Iterator<SelectedProducts> it = product.iterator();
//		while(it.hasNext()) {
//	            SelectedProducts pr = (SelectedProducts)it.next();
//				Product produto = productRepository.findById(pr.getProduct().getId()).get();
//				pr.setProduct(produto);
//				pr.setShopping(shopping);
//				spRepository.save(pr);
//	        }
		for (SelectedProducts selectedProductsDto : product) {
			Product produto = productRepository.findById(selectedProductsDto.getProduct().getId()).get();
			selectedProductsDto.setProduct(produto);
			selectedProductsDto.setShopping(shopping);
			spRepository.save(selectedProductsDto);
		}
		shoppingRepository.save(shopping);
		return ResponseEntity.status(HttpStatus.CREATED).body(new ShoppingDto(shopping));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShoppingDto> listarCompraPeloId(@PathVariable Long id){
		Optional<Shopping> shopping = shoppingRepository.findById(id);
		if(shopping.isPresent()) {
			return ResponseEntity.ok(new ShoppingDto(shopping.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<ShoppingDto> excluirCompraPeloId(@PathVariable Long id){
		Optional<Shopping> shopping = shoppingRepository.findById(id);
		if(shopping.isPresent()) {
			shoppingRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
