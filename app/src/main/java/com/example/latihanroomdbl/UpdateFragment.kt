package com.example.latihanroomdbl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.latihanroomdbl.databinding.FragmentAddBinding
import com.example.latihanroomdbl.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {
    // Menambahkan variable argumnets
    private val args by navArgs<UpdateFragmentArgs>()

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

        binding.etFirstName.setText(args.currentUser.firstName)
        binding.etLastName.setText(args.currentUser.lastName)
        binding.etAge.setText(args.currentUser.age.toString())
        return  view
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.update.setOnClickListener{
//            Toast.makeText(context,"Berhasil Mengubah",Toast.LENGTH_SHORT).show()
//            this.findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }
//    }
}