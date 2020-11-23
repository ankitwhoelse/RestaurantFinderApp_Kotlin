package ca.qc.cgodin.projetfinal.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ca.qc.cgodin.projetfinal.R
import ca.qc.cgodin.projetfinal.ui.MainActivity
import ca.qc.cgodin.projetfinal.ui.RestaurantViewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    lateinit var viewModel: RestaurantViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
    }
}