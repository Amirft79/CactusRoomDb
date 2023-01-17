package ir.cactus.cactusroomdb.ui

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.FragmentListBinding


class ListFragment : Fragment() {

    private var _Binding:FragmentListBinding?=null
    private val binding get() = _Binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _Binding=FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

}