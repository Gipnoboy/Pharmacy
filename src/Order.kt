import java.util.*

class Order (private var data : Map<String, Int>, private val pharmacistId: String, pharmacy : Pharmacy){ // Order class
    private val id = UUID.randomUUID().toString()
    private var totalPrice = 0.0

    init {
        calculateTotalPrice(pharmacy)
    }

    private fun calculateTotalPrice(pharmacy : Pharmacy){
        for ((key, value) in data) {
            totalPrice += (pharmacy.products.find{ it.name == key }?.cost ?: 0.0) * value
        }
    }

    fun getInfo(pharmacy: Pharmacy){
        println("----------------")
        println("Order ${id + 1}:")
        for ((key, value) in data){
            println("$key x $value | ${(pharmacy.products.first{it.name == key}.cost) * value}$")
        }
        println("Total: $totalPrice")
        println("Pharmacist: ${pharmacy.pharmacists.find{it.getId() == pharmacistId}?.name}")
        println("----------------")
    }
}