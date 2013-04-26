package filterExpressions

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.scalatest.junit.AssertionsForJUnit

//  SBT-command: test-only filterExpressions.SpecificationTest
class SpecificationTest extends AssertionsForJUnit {

  @Test 
  def getFirstWordsIncludingIntermediateCharacters() {
    
    val productWhichShouldBeMatchedByFilter = new Product(1 , 5) 
    
    val products = List(
        new Product(0 , 10),
        new Product(2 , 2),
        productWhichShouldBeMatchedByFilter
	)
	
	val filteredProducts = products.filter(p => p.unitsInStock > 0 && p.unitPrice > 3)

	assertEquals(1, filteredProducts.size)
	assertEquals(productWhichShouldBeMatchedByFilter, filteredProducts(0))
  }
  
  /*
  The above used Scala method "filter" is very powerful, compared to Java when you maybe instead would write code like below, 
  instead of the above very simple usage of filter method:
  
  First some supporting code:
    
		public interface Specification<T> {
		    boolean isSatisfiedBy(T t);
		}
		
		import java.util.ArrayList;
		import java.util.Collections;
		import java.util.List;
		public class CollectionUtility {
		    public static <T> List<T> findAllItemsMatchingSpecification(
		        final Iterable<T> iterableElements,
		        final Specification<T> specification
		    ) {
		        final List<T> listOfElementsmatchingSpecification = new ArrayList<T>();
		        for (T element : iterableElements) {
		            if(specification.isSatisfiedBy(element)) {
		                listOfElementsmatchingSpecification.add(element);        
		            }
		        }
		        return Collections.unmodifiableList(listOfElementsmatchingSpecification);
		    }
		}
		
	And then some actual usage of the above Java code (kind of corresponding to the very simple Scala code above which just used the "filter" method)  
		
		final List<Product> products = Arrays.asList(new Product( [...] ), [ ... ]);
		
		final List<Product> productsMatchingSpecification = CollectionUtility.findAllItemsMatchingSpecification(
		    products,
		    new Specification<Product>() {
				public boolean isSatisfiedBy(Product product) {
				    return (product.getUnitsInStock() > 0 && product.getUnitPrice() > 3.00);
				}
		    }
		);
*/
}