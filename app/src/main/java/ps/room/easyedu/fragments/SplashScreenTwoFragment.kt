package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentSplashScreenTwoBinding


class SplashScreenTwoFragment : SharedFragment() {

    private lateinit var binding: FragmentSplashScreenTwoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashScreenTwoBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.getStartedButton.setOnClickListener {
            activityCast().changeActivityFragment(
                SplashScreenTwoFragmentDirections.actionSplashScreenTwoFragmentToSignUpFragment())
        }

        binding.alreadyHaveAnAccountButton.setOnClickListener {
            activityCast().changeActivityFragment(
                SplashScreenTwoFragmentDirections.actionSplashScreenTwoFragmentToSignInFragment())
        }
    }



}