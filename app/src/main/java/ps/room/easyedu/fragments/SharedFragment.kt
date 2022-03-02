package ps.room.easyedu.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import ps.room.easyedu.MainActivity
import ps.room.easyedu.R


open class SharedFragment : Fragment() {

    companion object {
        @JvmField
        val isCourseAdded = false

    }


    fun activityCast() : MainActivity {
        return activity as MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}