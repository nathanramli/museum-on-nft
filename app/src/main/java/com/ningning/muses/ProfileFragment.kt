package com.ningning.muses

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ningning.muses.data.MUSEUMS
import com.ningning.muses.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListener()

    }

    private fun setupListener() {
        binding.wallet.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(binding.root.context, WalletActivity::class.java)
            context.startActivity(intent)
        }

        binding.termsAndConditions.setOnClickListener {
            val context = binding.root.context
            val intent = Intent(binding.root.context, TermsAndConditionsActivity::class.java)
            context.startActivity(intent)
        }
    }
}