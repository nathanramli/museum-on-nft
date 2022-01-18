package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.ningning.muses.databinding.FragmentResetPasswordRequestedBinding

class ResetPasswordRequestedFragment : Fragment() {
    private var _binding: FragmentResetPasswordRequestedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResetPasswordRequestedBinding.inflate(inflater, container, false)

        binding.root.findViewById<MaterialButton>(R.id.doneButton).setOnClickListener {
            val intent = Intent(binding.root.context, SignInActivity::class.java)
            binding.root.context.startActivity(intent)
        }
        return binding.root
    }
}
