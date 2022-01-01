package com.ningning.muses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ningning.muses.databinding.FragmentBottomSheetDialogBinding
import com.ningning.muses.databinding.FragmentMyTicketBinding

class BottomSheetDialogFragment : Fragment() {
    private var _binding: FragmentBottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomSheetDialogBinding.inflate(inflater, container, false)

        return binding.root
    }
}