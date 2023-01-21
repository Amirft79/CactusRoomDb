package ir.cactus.cactusroomdb.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.FragmentAddBinding
import ir.cactus.cactusroomdb.entity.User
import ir.cactus.cactusroomdb.ui.viewmodel.DataBaseViewModel

class AddFragment : Fragment() {


    private var _Binding:FragmentAddBinding?=null
    private val binding get() = _Binding!!

    private lateinit var viewModel:DataBaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _Binding= FragmentAddBinding.inflate(layoutInflater)

        viewModel=ViewModelProvider(this).get(DataBaseViewModel::class.java)

        binding.button.setOnClickListener {
            val firstName=binding.UpdateeditTextTextFirstName.text.toString()
            val lastName=binding.editTextTextLastName.text.toString()
            val age=binding.editTextTextAge.text
            if(inputCheck(firstName,lastName,age)){
                val user=User(0,firstName,lastName,Integer.parseInt(age.toString()))
                viewModel.addUser(user)
                Toast.makeText(requireContext(),"user added${user.user_id}",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }else{
                Toast.makeText(requireContext(),"please enter the full parameter !!",Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }

    private fun inputCheck(firstName:String,lastName:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&&TextUtils.isEmpty(lastName)&&age.isEmpty())


    }

}