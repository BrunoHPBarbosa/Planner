package com.app.planner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.planner.databinding.FragmentUpdatePlannerActivityDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class UpdatePlannerActivityDialogFragment: BottomSheetDialogFragment() {

    private var _binding: FragmentUpdatePlannerActivityDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentUpdatePlannerActivityDialogBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            //TODO()
        }
    }
    companion object{
        const val TAG = "UpdatePlannerActivityDialogFragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}