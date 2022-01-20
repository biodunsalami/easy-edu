package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentBaseBinding


open class BaseFragment : SharedFragment() {

    private lateinit var binding: FragmentBaseBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBaseBinding.inflate(inflater, container, false)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.base_fragment_container) as NavHostFragment

        navController = navHostFragment.navController


        setUpBottomNavWithNavController()


        return binding.root
    }

    private fun setUpBottomNavWithNavController() {
        binding.bottomNavBar.setupWithNavController(navController)
    }





}