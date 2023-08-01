package io.gauravtak.androidappshortcut

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addShortCutsUsingCode()
    }

    private fun addShortCutsUsingCode() {

        val shortcutManager = getSystemService<ShortcutManager>(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(applicationContext, "id_linked_in")
            .setShortLabel(getString(R.string.linkedin))
            .setLongLabel(getString(R.string.open_linkedin))
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.ic_linkedin))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(Constants.LINKEDIN_URL))
            )
            .build()

        val shortcut2 = ShortcutInfo.Builder(applicationContext, "id_youtube")
            .setShortLabel(getString(R.string.youtube))
            .setLongLabel(getString(R.string.open_youtube))
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.ic_youtube))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(Constants.YOUTUBE_URL))
            )
            .build()
        shortcutManager!!.dynamicShortcuts = listOf(shortcut, shortcut2)
    }
}