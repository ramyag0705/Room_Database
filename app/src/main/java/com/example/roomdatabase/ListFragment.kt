package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.databinding.FragmentListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.fragment_list), UserListAdapter.OnItemClickListener {
    private lateinit var binding: FragmentListBinding
    private lateinit var navController: NavController
    val userViewModel by viewModel<UserViewModel>()
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter(emptyList(), this)


        binding.apply {
            recyclerview.layoutManager = LinearLayoutManager(requireActivity())
            recyclerview.setHasFixedSize(true)
            recyclerview.adapter = userListAdapter
        }
       binding.neww.setOnClickListener{
           val action = ListFragmentDirections.actionListFragmentToAddFragment()
           findNavController().navigate(action)
       }
//
        viewLifecycleOwner.lifecycleScope.launch {
            //userViewModel.getAllUsers()
            userViewModel.userList.observeForever { userList ->
                val userListAdapter = UserListAdapter(userList, this@ListFragment)
                binding.recyclerview.adapter = userListAdapter
            }
        }
    }

    override fun onItemClick(position: Int) {
        val action = ListFragmentDirections.actionListFragmentToAddFragment()
        findNavController().navigate(action)
    }
}
