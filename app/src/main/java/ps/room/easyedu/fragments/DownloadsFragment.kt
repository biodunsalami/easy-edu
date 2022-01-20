package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentDownloadsBinding


class DownloadsFragment : BaseFragment() {

    private lateinit var binding: FragmentDownloadsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDownloadsBinding.inflate(inflater, container, false)


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.downloadCourseButton.setOnClickListener {
            findNavController().navigate(R.id.action_downloadsFragment_to_browseFragment)
        }
    }

}