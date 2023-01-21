package ir.cactus.cactusroomdb.ui

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
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
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun updateItem(){
        val firstName=binding.UpdateeditTextTextFirstName.text.toString()
        val lastName=binding.editTextTextLastName.text.toString()
        val age=binding.editTextTextAge.text.toString()
        if (inputCheck(firstName,lastName,binding.editTextTextAge.text)){
            val updatedUser= User(args.currentUser.user_id,firstName,lastName,Integer.parseInt(age))
            viewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(),"update user successfully!",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

        }


    }

    private fun inputCheck(firstName:String,lastName:String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstName)&& TextUtils.isEmpty(lastName)&&age.isEmpty())


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
        val bulider=AlertDialog.Builder(requireContext())
        bulider.setPositiveButton("yes"){_,_->
            viewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(),"delete user",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }.setNegativeButton("no"){_,_->

        }.setTitle("Delete${args.currentUser.firstName} ?")
            .setMessage("are you sure you want to delete !")
            .create().show()
    }

}