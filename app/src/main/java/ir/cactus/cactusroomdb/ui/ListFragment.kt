package ir.cactus.cactusroomdb.ui

import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.FragmentListBinding
import ir.cactus.cactusroomdb.ui.adapter.UserAdapter
import ir.cactus.cactusroomdb.ui.viewmodel.DataBaseViewModel


class ListFragment : Fragment() {

    private var _Binding:FragmentListBinding?=null
    private val binding get() = _Binding!!


    private lateinit var userViewModel:DataBaseViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _Binding=FragmentListBinding.inflate(layoutInflater)

        val adapter=UserAdapter()
        val recyclerView=binding.userRecycler
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(requireContext())

        userViewModel=ViewModelProvider(this).get(DataBaseViewModel::class.java)
        userViewModel.readAllData.observe(viewLifecycleOwner, Observer {user->
            adapter.setData(user)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return binding.root
    }

}