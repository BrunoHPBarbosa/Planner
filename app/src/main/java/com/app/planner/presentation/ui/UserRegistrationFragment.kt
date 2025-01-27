package com.app.planner.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.planner.R
import com.app.planner.domain.utils.imageBitMapToBase64
import com.app.planner.domain.utils.imageUriBitmap
import com.app.planner.databinding.FragmentUserRegistrationBinding
import com.app.planner.presentation.ui.viewmodel.UserRegistrationViewModel
import kotlinx.coroutines.launch

class UserRegistrationFragment : Fragment() {

    private var _binding: FragmentUserRegistrationBinding? = null
    private val binding get() = _binding!!

    private val navController by lazy { findNavController() }

    private val userRegistrationViewModel by activityViewModels<UserRegistrationViewModel>()

    private val pickMedia = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            binding.ivAddPhoto.setImageURI(uri)
            val imageBitmap = requireContext().imageUriBitmap(uri)
            imageBitmap?.let {
                val imageBase64 = imageBitMapToBase64(bitmap = imageBitmap)
                userRegistrationViewModel.updateProfile(image = imageBase64)
                binding.ivAddPhoto.setImageURI(uri)
            }

        } else
            Toast.makeText(requireContext(), "Oops...Nenhuma foto selecionada", Toast.LENGTH_SHORT)
                .show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        with(binding) {
            ivAddPhoto.setOnClickListener {
                pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
            }

            tietName.addTextChangedListener { text ->
                userRegistrationViewModel.updateProfile(
                    name = text.toString()
                )

            }
            tietEmail.addTextChangedListener { text ->
                userRegistrationViewModel.updateProfile(
                    email = text.toString()
                )

            }
            tietPhone.addTextChangedListener { text ->
                userRegistrationViewModel.updateProfile(
                    phone = text.toString()
                )

            }

            btnSaveUser.setOnClickListener {
                userRegistrationViewModel.saveProfile(
                    onCompleted = {
                        navController.navigate(R.id.action_userRegistrationFragment_to_homeFragment)
                    })

            }
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            userRegistrationViewModel.isProfileValid.collect { isProfileValid ->
                binding.btnSaveUser.isEnabled = isProfileValid
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}