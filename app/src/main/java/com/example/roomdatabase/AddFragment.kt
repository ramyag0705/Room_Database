package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.databinding.FragmentAddBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    private lateinit var navController: NavController

    // Inject UserViewModel and UserDatabase using Koin
    private val viewModel by viewModel<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        navController = Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)

        // Set click listener for submit button
        binding.addBtn.setOnClickListener {
            val firstName = binding.addFirstNameEt.text.toString()
            //val middleName = binding.addMiddleNameEt.text.toString()
            val lastName = binding.addLastNameEt.text.toString()
            //val date = binding.calendar.id.toString()
            val age = binding.addAge.text.toString().toInt()


            // Insert user into database
            lifecycleScope.launch() {
                val user = User(
                    firstName = firstName,
                    lastName = lastName,
                    //middleName = middleName,
                    age = age,
                    //dateOfBirth = calendar.time
                )
                viewModel.addUser(user)
            }

            navController.navigate(R.id.action_addFragment_to_listFragment)

            // Clear the input fields
            binding.addFirstNameEt.text.clear()
           // binding.addMiddleNameEt.text.clear()
            binding.addLastNameEt.text.clear()
            binding.addAge.text.clear()
            //binding.dateEditText.text.clear()
        }
        //getAllUsers()
        return binding.root
    }

    }



