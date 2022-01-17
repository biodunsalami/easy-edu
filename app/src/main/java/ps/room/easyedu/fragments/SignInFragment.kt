package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentSignInBinding
import ps.room.easyedu.databinding.FragmentSignUpBinding


class SignInFragment : SharedFragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.signInButton.setOnClickListener {
            activityCast().changeActivityFragment(SignInFragmentDirections.actionSignInFragmentToBaseFragment())
        }

        binding.signUpTextView.setOnClickListener {
            activityCast().changeActivityFragment(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }
    }


}