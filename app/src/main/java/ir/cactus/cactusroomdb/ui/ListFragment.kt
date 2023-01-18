package ir.cactus.cactusroomdb.ui

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.FragmentListBinding
import ir.cactus.cactusroomdb.ui.viewmodel.DataBaseViewModel


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
        _Binding=FragmentListBinding.inflate(layoutInflater)
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return binding.root
    }

}