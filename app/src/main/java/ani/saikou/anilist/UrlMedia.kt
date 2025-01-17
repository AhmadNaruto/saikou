package ani.saikou.anilist

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ani.saikou.loadIsMAL
import ani.saikou.loadMedia
import ani.saikou.startMainActivity
import ani.saikou.toastString

class UrlMedia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data: Uri? = intent?.data
        if (data?.host != "anilist.co") loadIsMAL = true
        try {
            if (data?.pathSegments?.get(1) != null) loadMedia = data.pathSegments?.get(1)?.toIntOrNull()
        } catch (e: Exception) {
            toastString(e.toString())
        }
        startMainActivity(this)
    }
}