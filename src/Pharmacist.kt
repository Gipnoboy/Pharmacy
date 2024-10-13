import java.util.*

class Pharmacist(var name: String) {
    private val id = UUID.randomUUID().toString()

    fun getId() = id

    fun addProd(prod : Product, pharmacy : Pharmacy){
        pharmacy.products.add(prod)
    }

    fun deleteProd(delName : String, pharmacy : Pharmacy) = if(pharmacy.products.removeIf{it.name == delName}){
        println("$delName was removed successfully!")
    } else {
        println("$delName wasn't removed, error occurred!")
    }

    fun updateName(name : String, newName : String, pharmacy : Pharmacy){
        val prodIndex = pharmacy.products.indexOfFirst {it.name == name}
        if (prodIndex != -1){
            pharmacy.products[prodIndex].name = newName
            println("Name of ${pharmacy.products[prodIndex].name} updated to $newName")
        } else {
            println("Error! Wrong Name")
        }
    }

    fun updateCost(name : String, newCost : Double, pharmacy : Pharmacy){
        val prodIndex = pharmacy.products.indexOfFirst {it.name == name}
        if (prodIndex != -1){
            pharmacy.products[prodIndex].cost = newCost
            println("Cost of ${pharmacy.products[prodIndex].name} updated from (${pharmacy.products[prodIndex].cost}) to $newCost")
        } else {
            println("Error! Wrong Name")
        }
    }

    fun orderProduct(name : String, quantity : Int, pharmacy : Pharmacy){
        val prodIndex = pharmacy.products.indexOfFirst {it.name == name}
        if (prodIndex != -1){
            pharmacy.products[prodIndex].quantity += quantity
            println("You've ordered $quantity of ${pharmacy.products[prodIndex].name}")
        } else {
            println("Product '$name' does not exist")
        }
    }
    fun createOrder(data : Map<String, Int>, pharmacy : Pharmacy){
        val order = Order(data, id, pharmacy)

        for ((key, value) in data){
            val prodIndex = pharmacy.products.indexOfFirst {it.name == key}
            if (prodIndex == -1 || value < pharmacy.products[prodIndex].quantity){ // Якщо виявляється що кількість якогось продукту недостатня
                println("Can't create an order! The quantity of $key is not enough")
                for ((key2, value2) in data) { // добавляємо назад скільки відняли
                    val prodIndex1 = pharmacy.products.indexOfFirst { it.name == key2 }
                    if (prodIndex1 == -1 || value2 < pharmacy.products[prodIndex1].quantity) break
                    pharmacy.products[prodIndex1].quantity += value2
                }
                break
            }
            pharmacy.products[prodIndex].quantity -= value
        }
        pharmacy.orders.add(order)
    }
}