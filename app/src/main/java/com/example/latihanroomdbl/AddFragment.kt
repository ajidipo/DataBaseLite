package com.example.latihanroomdbl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.latihanroomdbl.data.User
import com.example.latihanroomdbl.data.userViewModel
import com.example.latihanroomdbl.databinding.FragmentAddBinding
import com.example.latihanroomdbl.databinding.FragmentListBinding


class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: userViewModel

//    private lateinit var binding: FragmentAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        binding = FragmentAddBinding.inflate(layoutInflater,container,false)
        _binding = FragmentAddBinding.inflate(inflater,container,false)

        val view = binding.root

    mUserViewModel = ViewModelProvider(this).get(userViewModel::class.java)
    binding.save.setOnClickListener{
        inserDataToDatabase()
        findNavController().navigate(R.id.action_addFragment_to_listFragment)
    }
        return view
    }
    private fun inserDataToDatabase(){
        val firstname = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = Integer.parseInt(binding.age.text.toString())

        val user = User(0,firstname,lastName,age)
        mUserViewModel.addUser(user)
        binding.save.setOnClickListener{
            Toast.makeText(context,"Berhasil Membuat", Toast.LENGTH_SHORT).show()
            this.findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }

    }



//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.save.setOnClickListener{
//            Toast.makeText(context,"Berhasil Membuat", Toast.LENGTH_SHORT).show()
//            this.findNavController().navigate(R.id.action_addFragment_to_listFragment)
//        }
//    }

}