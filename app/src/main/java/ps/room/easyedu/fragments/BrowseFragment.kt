package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ps.room.easyedu.R
import ps.room.easyedu.databinding.FragmentBrowseBinding


class BrowseFragment : BaseFragment() {

    private lateinit var binding: FragmentBrowseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBrowseBinding.inflate(inflater, container, false)

        return binding.root
    }

}