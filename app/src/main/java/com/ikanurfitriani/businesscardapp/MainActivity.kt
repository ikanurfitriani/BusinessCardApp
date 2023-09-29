// Nama package dari aplikasi yang dibuat
package com.ikanurfitriani.businesscardapp

// Import library yang akan digunakan
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.border
import com.ikanurfitriani.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Blok untuk menentukan tata letak aktivitas tempat fungsi composable
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    // Untuk mengisi Surface dengan ukuran maksimum yang tersedia dalam konteksnya
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onBackground
                ) {
                    // Fungsi yang memanggil komponen atau halaman utama dari aplikasi
                    PageofApp()
                }
            }
        }
    }
}

// Blok fungsi CardName untuk menampilkan bagian atas halaman yang terdiri foto, nama dan title
@Composable
fun CardName() {
    // Untuk menampilkan konten dalam bentuk Column
    Column(
        // Untuk membuat konten column ada di tengah-tengah halaman
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding()
    ) {
        // Untuk menampilkan foto
        Image(
            // Untuk mengambil gambar dari resource drawable
            painter = painterResource(id = R.drawable.profile_ika_n),
            contentDescription = "Foto Profile Ika",
            Modifier
                // Ukuran gambar yang digunakan 220 dp
                .size(220.dp)
                // Mengubah bentuk tampilan gambar menjadi bentuk lingkaran
                .clip(CircleShape)
                // Menambahkan border di sekeliling gambar/foto
                .border(10.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        // Menambahkan ruang kosong sebesar 8 dp diantara elemen-elemen tata letak
        Spacer(modifier = Modifier.size(8.dp))
        // Untuk menampilkan text
        Text(
            // Menampilkan nama saya yaitu Ika Nurfitriani
            text = "Ika Nurfitriani",
            style = TextStyle(
                // Ukuran font yang digunakan untuk nama sebesar 42 sp
                fontSize = 42.sp
            )
        )
        // Menambahkan ruang kosong sebesar 8 dp diantara elemen-elemen tata letak
        Spacer(modifier = Modifier.size(8.dp))
        // Untuk menampilkan text
        Text(
            // Menampilkan title saya yaitu Android Developer Enthusiast
            text = "Android Developer Enthusiast",
            style = TextStyle(
                // Ukuran font yang digunakan untuk title sebesar 24 sp
                fontSize = 24.sp,
                // Warna font yang digunakan untuk title adalah warna biru
                color = Color(0xFF1E06F1)
            )
        )
    }
}

// Blok fungsi ContactInfo untuk menampilkan bagian bawah halaman yang terdapat informasi kontak saya
@Composable
fun ContactInfo() {
    // Blok untuk membuat variabel yang menyimpan data dalam list
    val contactInformation = listOf(
        ListContact(R.drawable.baseline_call_24, "+6282116055338", "Icon Call"),
        ListContact(R.drawable.baseline_share_24, "@ikanurfitriani", "Icon Share"),
        ListContact(R.drawable.baseline_email_24, "ikanurfitriani513@gmail.com", "Icon Email")
    )
    // Untuk menampilkan konten dalam bentuk Column
    Column(
        // Untuk menambahkan ruang kosong sebesar 14 dp agar berjarak
        modifier = Modifier.padding(14.dp),
        // Untuk mengatur elemen dalam kolom secara vertikal agar ada di tengah-tengah kolom
        verticalArrangement = Arrangement.Center,
        // Untuk mengatur elemen-elemen agar dimulai dari sebelah kiri dan diatur secara horizontal
        horizontalAlignment = Alignment.Start
    ) {
        // Untuk menampilkan text
        Text(
            // Menampilkan 3 kata yaitu My Contact Information
            text = "My Contact Information :",
            style = TextStyle(
                // Ukuran font/huruf yang digunakan sebesar 22 sp
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
        )
        // Menambahkan ruang kosong sebesar 8 dp diantara elemen-elemen tata letak
        Spacer(modifier = Modifier.size(8.dp))
        contactInformation.forEach { item ->
            // Untuk mengatur elemen dalam row
            Row(
                // Menambahkan ruang kosong sebesar 8 dp diantara elemen-elemen tata letak
                modifier = Modifier.padding(8.dp),
                // Membuat elemen-elemen berada di tengah secara vertikal
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Untuk menampilkan gambar
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.contentDescription,
                    // Mengatur ukuran gambar sebesar 32 dp
                    modifier = Modifier.size(32.dp)
                )
                // Menambahkan ruang kosong sebesar 14 dp diantara elemen-elemen tata letak
                Spacer(modifier = Modifier.size(14.dp))
                Text(text = item.text)
            }
        }
    }
}

// Untuk membuat kelas baru yaitu ListContact
data class ListContact(val icon: Int, val text: String, val contentDescription: String = "")

// Blok fungsi PageofApp untuk menampilkan semua bagian halaman
@Composable
fun PageofApp() {
    // Untuk mengatur elemen dalam column
    Column(
        // Membuat elemen-elemen berada di tengah secara horizontal
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            // Membuat elemen-elemen berada di tengah secara vertikal
            verticalArrangement = Arrangement.Center,
            // Membuat elemen-elemen berada di tengah secara horizontal
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Untuk memanggil fungsi CardName
            CardName()
        }
        // Untuk memanggil fungsi ContactInfo
        ContactInfo()
        // Menambahkan ruang kosong sebesar 30 dp diantara elemen-elemen tata letak
        Spacer(modifier = Modifier.size(30.dp))
    }
}

// Menampilkan pratinjau aplikasi kartu nama dengan tema terang
@Preview(showBackground = true)
// Menampilkan pratinjau aplikasi kartu nama dengan tema gelap
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = false,
    name = "Dark Mode"
)
// Fungsi composable untuk menampilkan pratinjau halaman fungsi PageofApp yang berisi kartu nama
@Composable
fun CardNamePreview() {
    PageofApp()
}