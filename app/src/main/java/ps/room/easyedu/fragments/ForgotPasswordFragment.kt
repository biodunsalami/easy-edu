package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentForgotPasswordBinding


class ForgotPasswordFragment : SharedFragment() {
    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)

        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.resetPasswordButton.setOnClickListener {
            activityCast().changeActivityFragment(
                ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToPasswordSentFragment())
        }

        binding.signUpTextView.setOnClickListener {
            activityCast().changeActivityFragment(
                ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToSignInFragment()
            )
        }
    }


}