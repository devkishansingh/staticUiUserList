import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.capitalize
import com.devkishan.staticuiuserlist.screen.showUserList
import java.util.Locale
import kotlin.random.Random

@Composable
fun userList() {
    val numUsers = 100  // Number of users to generate

    val users = List(numUsers) { index ->
        Users(
            userId = generateUserId(),
            userName = generateRandomString(6),
            fullName = generateRandomFullName(),
            email = generateRandomEmail(),
            cardNumber = index + 1  // Generate card number in sequence
        )
    }

    // Print users to console (for debugging)
    users.forEach { println(it) }

    // Use the generated users list in your UI
    showUserList(users)
}

data class Users(
    val userId: Long,
    val userName: String,
    val fullName: String,
    val email: String,
    val cardNumber: Int
)

fun generateUserId(): Long {
    return Random.nextLong(10000000, 99999999)  // 8-digit random Long number
}

fun generateRandomString(length: Int): String {
    val allowedChars = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..length)
        .map { allowedChars.random() }
        .joinToString("")
}

fun generateRandomFullName(): String {
    val nameLength = Random.nextInt(1, 21)  // Up to 20 characters
    return generateRandomString(nameLength).capitalize(Locale.getDefault())
}

fun generateRandomEmail(): String {
    val domains = listOf("example.com", "test.org", "dummy.net", "mail.com")
    return "${generateRandomString(8)}@${domains.random()}"
}
