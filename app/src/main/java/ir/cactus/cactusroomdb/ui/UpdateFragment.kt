package ir.cactus.cactusroomdb.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ir.cactus.cactusroomdb.R
import ir.cactus.cactusroomdb.databinding.FragmentUpdateBinding
import ir.cactus.cactusroomdb.entity.User
import ir.cactus.cactusroomdb.ui.viewmodel.DataBaseViewModel


class UpdateFragment : Fragment() {

    private var Binding:FragmentUpdateBinding?=null
    private val binding get() = Binding!!

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var viewModel:DataBaseViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Binding= FragmentUpdateBinding.inflate(layoutInflater)
        viewModel=ViewModelProvider(this).get(DataBaseViewModel::class.java)
        binding.UpdateeditTextTextFirstName.setText(args.currentUser.firstName.toString())
        binding.editTextTextLastName.setText(args.currentUser.lastName.toString())
        binding.editTextTextAge.setText(args.currentUser.age.toString())
        binding.button.setOnClickListener {
            updateItem()
        }
        return binding.root
    }

    private fun updateItem(){
        val firstName=binding.UpdateeditTextTextFirstName.text.toString()
        val lastName=binding.editTextTextLastName.text.toString()
        val age=binding.editTextTextAge.text.toString()
        if (inputCheck(firstName,lastName,binding.editTextTextAge.text)){
            val updatedUser= User(args.currentUser.user_id,firstName,lastName,Integer.parseInt(age))
            viewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"update user seccessfully!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)


        }


    }

    private fun inputCheck(firstName:String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&&age.isEmpty())


    }

}