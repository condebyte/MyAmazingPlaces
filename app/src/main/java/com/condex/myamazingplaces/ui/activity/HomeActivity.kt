package com.condex.myamazingplaces.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.condex.myamazingplaces.R
import com.condex.myamazingplaces.databinding.ActivityHomeBinding
import com.condex.myamazingplaces.ui.NavigationManager
import com.condex.myamazingplaces.ui.adapters.FragmentAdapter
import com.condex.myamazingplaces.ui.fragments.PlacesListFragment
import com.google.android.material.tabs.TabLayoutMediator


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configView()
        setListener()
    }

    private fun setListener() {
        binding.button.setOnClickListener {
            NavigationManager.openAccidentDetail(this,17)

        }
    }

    private fun configView() {
        val adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        adapter.addFragment(PlacesListFragment(),"mi fragment")

        binding.viewPager2.adapter = adapter
        // binding.viewPager2.setPageTransformer(DepthPageTransformer())

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = adapter.getPageTitle(position)
        }.attach()
    }

}