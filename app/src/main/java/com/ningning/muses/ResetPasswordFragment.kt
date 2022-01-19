package com.ningning.muses

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
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
            val phrase = binding.inputEmail
            if (phrase.text!!.isEmpty()) {
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "Please fill your email first!",
                    Snackbar.LENGTH_SHORT
                ).setBackgroundTint(Color.RED)
                    .setTextColor(Color.WHITE)
                    .show()
            } else {
                requireActivity().supportFragmentManager.beginTransaction().apply {
                    replace(
                        R.id.frameContainer,
                        ResetPasswordRequestedFragment(),
                        ResetPasswordRequestedFragment::class.java.simpleName
                    )
                    commit()
                }
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
