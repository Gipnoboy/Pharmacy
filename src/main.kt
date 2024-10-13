fun main(){
    val prod1 = Product("Name2", 1150.0, 2) //creating products for adding
    val prod2 = Product("Name24", 1220.0, 2)
    val prod3 = Product("Name1", 1390.0, 3)
    val prod4 = Product("Name76", 140.0, 4)
    val prod5 = Product("Name0", 15.0, 5)

    val pharmacy = Pharmacy() //creating pharmacy
    pharmacy.createPharmacist("Alex") //creating pharmacist

    val pharmacist = pharmacy.pharmacists.first{it.name == "Alex"}

    pharmacist.addProd(prod1, pharmacy) // adding products
    pharmacist.addProd(prod2, pharmacy)
    pharmacist.addProd(prod3, pharmacy)
    pharmacist.addProd(prod4, pharmacy)
    pharmacist.addProd(prod5, pharmacy)

    println("All Available Products")
    pharmacy.getAvailableProds()
    println("-----------------")
    println("Products sorted by name")
    pharmacy.getProdsSortedByName()
    println("-----------------")
    println("Products sorted by price")
    pharmacy.getProdsSortedByPrice()
    println("-----------------")

    println("Adding an order")
    val list1 : MutableList<String> = mutableListOf(prod1.name, prod2.name, prod3.name, prod4.name, prod5.name) // creating list of names of products you want to be ordered
    val list2 : MutableList<Int> = mutableListOf(1, 1, 1, 1, 1) // creating list of quantities of those products
    val map1 = list1.zip(list2).toMap()
    pharmacist.createOrder(map1, pharmacy) // creating actual order
    pharmacy.getOrders(pharmacy)
    println("-----------------")

    println("Pharmacist orders a product for the pharmacy")
    pharmacist.orderProduct("Name1", 2, pharmacy) // pharmacist orders a product for the pharmacy
    pharmacy.getAvailableProds()
    println("-----------------")

    println("Deleting a product")
    pharmacist.deleteProd("Name1", pharmacy)
    pharmacy.getAvailableProds()
}