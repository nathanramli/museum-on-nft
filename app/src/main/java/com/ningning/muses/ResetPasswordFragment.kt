package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.ningning.muses.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : Fragment() {
    private var _binding: FragmentResetPasswordBinding? = null
    private val binding get() = _binding!!

    private lateinit var toolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResetPasswordBinding.inflate(inflater, container, false)

        binding.root.findViewById<MaterialButton>(R.id.resetPasswordButton).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(
                    R.id.frameContainer,
                    ResetPasswordRequestedFragment(),
                    ResetPasswordRequestedFragment::class.java.simpleName
                )
                commit()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar = requireActivity().findViewById(R.id.toolbar)
        (activity as AppCompatActivity)!!.setSupportActionBar(toolbar)
        (activity as AppCompatActivity)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (activity as AppCompatActivity)!!.supportActionBar?.setHomeButtonEnabled(true)
        toolbar?.setNavigationOnClickListener {
            val context = binding.root.context
            val intent = Intent(context, SignInActivity::class.java)
            context.startActivity(intent)

            activity?.finish()
        }
    }
}
