package com.ningning.muses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationBarView
import com.ningning.muses.databinding.ActivityHomeBinding
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val homeFragment = HomeFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            add(R.id.frameContainer, homeFragment, HomeFragment::class.java.simpleName)
            commit()
        }

        binding.bottomNavigationView.setOnItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeFragment -> {
                val fragment = HomeFragment()
                replaceFragment(fragment, HomeFragment::class.java.simpleName)
            }
            R.id.myTicketFragment -> {
                val fragment = MyTicketFragment()
                replaceFragment(fragment, MyTicketFragment::class.java.simpleName)
            }
            R.id.profileFragment -> {
                val fragment = ProfileFragment()
                replaceFragment(fragment, ProfileFragment::class.java.simpleName)
            }
        }
        return true
    }

    private fun replaceFragment(fragment: Fragment, simpleName: String) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, fragment, simpleName)
            commit()
        }
    }
}