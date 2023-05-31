package com.example.latihanroomdbl

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.latihanroomdbl.data.User
import com.example.latihanroomdbl.data.userViewModel
import com.example.latihanroomdbl.databinding.FragmentAddBinding
import com.example.latihanroomdbl.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {
    // Menambahkan variable argumnets
    private val args by navArgs<UpdateFragmentArgs>()
    // untuk memanggil user view model
    private lateinit var mUserViewModel: userViewModel
    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!
//    private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentUpdateBinding.inflate(inflater,container,false)
        val view = binding.root

        mUserViewModel = ViewModelProvider(this).get(userViewModel::class.java)

        binding.etFirstName.setText(args.currentUser.firstName)
        binding.etLastName.setText(args.currentUser.lastName)
        binding.etAge.setText(args.currentUser.age.toString())

        // untuk update data pada mysql
        binding.update.setOnClickListener{
        updateUser(args.currentUser.id)
    }

        // untuk menghapus data pada mysql
        // membuat alert dialog untuk menampilkan pilihan ya dan tidak mengahapus
        binding.delete.setOnClickListener{
            val id1 = args.currentUser.id
            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("Yakin akan menghapus data ini?").setCancelable(false)
                .setPositiveButton("ya"){
                    dialog,id -> deleteUser(id1)
                }
                .setNegativeButton("tidak"){
                    dialog, id ->
                }
            val alert = builder.create()
            alert.show()
        }
        return  view
    }
    // fun update data pada mysql
    private fun updateUser(id:Int){
        val firstname = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = Integer.parseInt(binding.etAge.text.toString())

        val user = User(args.currentUser.id,firstname,lastName,age)
        mUserViewModel.updateUser(user)
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }

    // fun untuk mengahapus data pda mysqlite
    private fun deleteUser(id: Int){
        val firstname = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val age = Integer.parseInt(binding.etAge.text.toString())

        val user = User(id,firstname,lastName,age)
        mUserViewModel.deleteUser(user)
        Toast.makeText(context,"berhasil menghapus",Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.update.setOnClickListener{
//            Toast.makeText(context,"Berhasil Mengubah",Toast.LENGTH_SHORT).show()
//            this.findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }
//    }
}