package com.example.latihanroomdbl

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanroomdbl.data.userViewModel
import com.example.latihanroomdbl.databinding.FragmentListBinding

class ListFragment : Fragment() {
//    private lateinit var binding: FragmentListBinding
    //jika ingin bisa
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var mUserViewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        //Menyiapkan Adapter
        val adapter = UserListAdapter()
        val rvUser = binding.rvUser
        rvUser.adapter = adapter

        // membuat aksi fab
        binding.fabList.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        mUserViewModel = ViewModelProvider(this).get(userViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
            user -> adapter.setData(user)
        })

        //menambahkan adapter ke recyclerview
        rvUser.layoutManager = LinearLayoutManager(requireContext())
        return view
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.fabList.setOnClickListener{
//            Toast.makeText(context,"Menuju Halaman Membuat", Toast.LENGTH_SHORT).show()
//            this.findNavController().navigate(R.id.action_listFragment_to_addFragment)
//        }
//    }
}