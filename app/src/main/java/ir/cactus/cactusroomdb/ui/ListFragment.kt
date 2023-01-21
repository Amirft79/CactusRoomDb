package ir.cactus.cactusroomdb.ui

import android.app.AlertDialog
import android.os.Binder
import android.os.Bundle
import android.view.*
import android.widget.Toast
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
        adapter.notifyDataSetChanged()
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_main,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.main_menu){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val bulider= AlertDialog.Builder(requireContext())
        bulider.setPositiveButton("yes"){_,_->
            userViewModel.deleteAllUsers()
            Toast.makeText(requireContext(),"delete user", Toast.LENGTH_LONG).show()
        }.setNegativeButton("no"){_,_->

        }.setTitle("Delete ?")
            .setMessage("are you sure you want to delete !")
            .create().show()
    }


}