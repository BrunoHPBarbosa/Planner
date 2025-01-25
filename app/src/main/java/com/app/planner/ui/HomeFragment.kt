package com.app.planner.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.app.planner.R
import com.app.planner.domain.utils.imageBase64ToBitmap
import com.app.planner.databinding.FragmentHomeBinding
import com.app.planner.ui.component.PlannerActivityDatePickerDialogFragment
import com.app.planner.ui.component.PlannerActivityTimePickerDialogFragment
import com.app.planner.ui.viewmodel.UserRegistrationViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class HomeFragment: Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val userRegistrationViewModel:UserRegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
        with(binding){
            tietNewPlannerActivityDate.setOnClickListener {
                PlannerActivityDatePickerDialogFragment(
                    onConfirm = { year, month, day ->
                        Toast.makeText(requireContext(), "$year $month $day", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onCancel = {}
                ).show(
                    childFragmentManager,
                    PlannerActivityDatePickerDialogFragment.TAG
                )
            }
            tietNewPlannerActivityDate.setOnClickListener {
                PlannerActivityTimePickerDialogFragment(
                    onConfirm = { hourOfDay,minute ->
                        Toast.makeText(requireContext(), "$hourOfDay $minute", Toast.LENGTH_SHORT)
                            .show()
                    },
                    onCancel = {}
                ).show(
                    childFragmentManager,
                    PlannerActivityTimePickerDialogFragment.TAG
                )
            }
            btnSaveNewPlannerActivity.setOnClickListener {
                UpdatePlannerActivityDialogFragment().show(
                    childFragmentManager,
                    UpdatePlannerActivityDialogFragment.TAG
                )
            }
        }
    }

    private fun setupObservers() {
        lifecycleScope.launch {
            launch {
                userRegistrationViewModel.profile.collect { profile ->
                    binding.tvUserName.text = getString(R.string.ola_usuario, profile.name)
                    imageBase64ToBitmap(base64String = profile.image)?.let { imageBitmap ->
                        binding.ivUserPhoto.setImageBitmap(imageBitmap)
                    }

                }
            }
            launch {
                userRegistrationViewModel.isTokenValid.distinctUntilChanged {
                    old, new -> old == new
                }.collect { isTokenValid ->
                    Log.d("CheckIsTokenValid", "setupObservers:isTokenValid = $isTokenValid ")
                    if (isTokenValid == false) showNewTokenSnackBar()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    private fun showNewTokenSnackBar() {
        Snackbar.make(requireView(),"Oops...O seu token expirou",Snackbar.LENGTH_INDEFINITE)
            .setAction("Obter novo token"){
                userRegistrationViewModel.obtainsNewToken()

            }
            .setActionTextColor(
                ContextCompat.getColor(requireContext(),R.color.lime_300)
            ).show()
    }
}