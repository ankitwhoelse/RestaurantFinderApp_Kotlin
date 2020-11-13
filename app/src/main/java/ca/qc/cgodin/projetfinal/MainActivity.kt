package ca.qc.cgodin.projetfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}