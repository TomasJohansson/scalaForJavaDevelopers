package filterExpressions

class Product(val unitsInStock: Int, val unitPrice: Double) {
  override def toString = " [[UnitsInStock: " + unitsInStock + " ; UnitPrice:" + unitPrice + "]] "
}