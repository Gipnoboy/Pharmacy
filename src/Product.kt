class Product (var name : String, var cost : Double, var quantity : Int){ // Product class
    fun checkAvailability() = quantity > 0
}