package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        swapViews(isCourseAdded)

        return binding.root
    }

    //Swaps the views on the home fragment once user starts a course
    private fun swapViews(boolean: Boolean){
        if (boolean){
            binding.homeConstraintLayout.visibility = View.GONE
            binding.browseTextView.visibility = View.VISIBLE
            binding.coursesRecyclerView.visibility = View.VISIBLE
        }else{
            binding.homeConstraintLayout.visibility = View.VISIBLE
            binding.browseTextView.visibility = View.GONE
            binding.coursesRecyclerView.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.browseCoursesButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_browseFragment)
        }
    }


}