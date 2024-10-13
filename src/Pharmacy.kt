class Pharmacy {
    var products: MutableList<Product> = mutableListOf()
    var orders: MutableList<Order> = mutableListOf()
    var pharmacists: MutableList<Pharmacist> = mutableListOf()

    fun getAvailableProds(){
        products.filter{it.checkAvailability()}
            .forEach{println("${it.name}, ${it.cost}$, ${it.quantity}")}
    }

    fun getProdsSortedByName(){
        products.sortedBy{it.name}
            .forEach {println("${it.name}, ${it.cost}$, ${it.quantity}")}
    }

    fun getProdsSortedByPrice(){
        products.sortedBy{it.cost}
            .forEach {println("${it.name}, ${it.cost}$, ${it.quantity}")}
    }

    fun getOrders(pharmacy : Pharmacy){
        orders.forEach{it.getInfo(pharmacy)}
    }

    fun createPharmacist(name: String){
        pharmacists.add(Pharmacist(name))
    }

    fun getPharmacists(){
        pharmacists.forEach{println("${it.name} works here")}
    }
}