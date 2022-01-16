package com.ningning.muses

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.google.android.material.navigation.NavigationBarView
import com.ningning.muses.databinding.ActivityHomeBinding
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ningning.muses.data.Museum

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val data = intent.getStringExtra("fragment")
        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        fragmentManager.beginTransaction().apply {
            add(R.id.frameContainer, homeFragment, HomeFragment::class.java.simpleName)
            commit()
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        if (data == "profile") {
            bottomNavigation.selectedItemId = R.id.profileFragment
            onNavigationItemSelected(bottomNavigation.menu.findItem(R.id.profileFragment))
        } else if (data == "ticket") {
            bottomNavigation.selectedItemId = R.id.myTicketFragment
            onNavigationItemSelected(bottomNavigation.menu.findItem(R.id.myTicketFragment))
        }
        binding.bottomNavigationView.setOnItemSelectedListener(this)

        setupButtonListener()
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

    private fun setupButtonListener() {
        binding.btnAppBarNotification.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.fragment_notification)
            val yesBtn = dialog.findViewById<Button>(R.id.btn_yes)
            val noBtn = dialog.findViewById<Button>(R.id.btn_no)

            yesBtn.setOnClickListener {
                binding.btnAppBarNotification.setImageResource(R.drawable.ic_notification_active)
                dialog.dismiss()
            }
            noBtn.setOnClickListener {
                binding.btnAppBarNotification.setImageResource(R.drawable.ic_notification_inactive)
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}