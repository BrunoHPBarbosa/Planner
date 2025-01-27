package com.app.planner.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.planner.R
import com.app.planner.databinding.FragmentInitialLoadingBinding
import com.app.planner.presentation.ui.viewmodel.UserRegistrationViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InitialLoadingFragment: Fragment() {

    private var _binding: FragmentInitialLoadingBinding? = null
    private val binding get() = _binding!!

    private val naController by lazy{ findNavController() }

    private val userRegistrationViewModel: UserRegistrationViewModel by activityViewModels<UserRegistrationViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitialLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(1_500)

                naController.navigate(
                    if (userRegistrationViewModel.getIsUserRegistered())
                        R.id.action_initialLoadingFragment_to_homeFragment2
                    else
                        R.id.action_initialLoadingFragment_to_userRegistrationFragment
                )

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}