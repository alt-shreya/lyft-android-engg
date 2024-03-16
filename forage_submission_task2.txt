import kotlin.math.pow
import kotlin.math.min

fun main() {    
//     println("Hello World")
    // Test functions here
    println(closestDriver(rider)) 
}

data class Driver(
    val name: String,
    val xPos: Double,
    val yPos: Double
)

data class Rider(
    val name: String,
    val rideCount: Int,
    val averageRating: Double,
    val xPos: Double,
    val yPos: Double
)	

// Hint: accessing a property of a data class is as simple as using exampleRider.name to retrieve the String value


val rider = Rider(
    "Pam",
    2,
    4.5,
    41.4241265,
    -75.6696665
)


val driverDatabase = listOf(
    Driver("Michael", 41.441692237165604, -75.74063210378645),
    Driver("Kevin", 41.34579708449845, -75.64069789999186),
    Driver("Dwight", 41.4420651,-75.6374736),
    Driver("Creed", 41.406597,-75.6540727),
    Driver("Jim", 41.418185,-75.6257407)
)


fun closestDriver(rider: Rider): Driver {
    // TODO fininsh the function
    val x_diff = driverDatabase.elementAt(0).xPos - rider.xPos
    val y_diff = driverDatabase.elementAt(0).yPos - rider.yPos
    var least_distance = (x_diff.pow(2) + y_diff.pow(2)).pow(0.5)
    var closest_driver = driverDatabase.elementAt(0)
    for (i in 1..driverDatabase.size-1) {
        
        val loop_x_diff = driverDatabase.elementAt(i).xPos - rider.xPos
        val loop_y_diff = driverDatabase.elementAt(i).yPos - rider.yPos
        val least_distance_candidate = (loop_x_diff.pow(2) + loop_y_diff.pow(2)).pow(0.5)
//         least_distance = min(least_distance, least_distance_candidate)
		if (least_distance > least_distance_candidate){
            least_distance = least_distance_candidate
            closest_driver = driverDatabase.elementAt(i)
        }
    }
    println("The closest driver is ${closest_driver.name} \n")
    
    return closest_driver
    
}