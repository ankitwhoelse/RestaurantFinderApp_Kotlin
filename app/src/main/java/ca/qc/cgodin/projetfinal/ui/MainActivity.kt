package ca.qc.cgodin.projetfinal.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ca.qc.cgodin.projetfinal.R
import ca.qc.cgodin.projetfinal.bd.RestaurantDatabase
import ca.qc.cgodin.projetfinal.repository.RestaurantRepository
import ca.qc.cgodin.projetfinal.ui.fragments.MapsFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var  viewModel: RestaurantViewModel


    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var mapsFragment: MapsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val restaurantRepository = RestaurantRepository(RestaurantDatabase(this))
        val viewModelProviderFactory = RestaurantViewModelProviderFactory(restaurantRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(RestaurantViewModel::class.java)

        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())

        try {
            if (ContextCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            )
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    101
                )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mapsFragment = MapsFragment()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                myLongitude = location.longitude
                myLatitude = location.latitude
                Log.i("test", "$myLatitude/$myLongitude")
                position.myLatitude = myLatitude
                position.myLongitude = myLongitude
            }
        }

    }

    companion object position{
        var myLatitude:Double = 0.1
        var myLongitude: Double = 0.1
    }


}