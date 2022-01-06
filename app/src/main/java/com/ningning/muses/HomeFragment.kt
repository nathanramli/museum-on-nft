package com.ningning.muses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ningning.muses.databinding.FragmentHomeBinding
import com.ningning.muses.data.MUSEUMS

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var popularMuseumAdapter: PopularMuseumAdapter
    private lateinit var recommendedMuseumAdapter: RecommendedMuseumAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        popularMuseumAdapter = PopularMuseumAdapter()
        recommendedMuseumAdapter = RecommendedMuseumAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialRecyclerView()
        popularMuseumAdapter.setData(MUSEUMS)
        recommendedMuseumAdapter.setData(MUSEUMS)

        recyclerViewScrollListener()
    }

    private fun initialRecyclerView() {
        binding.recyclerViewPopularMuseum.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewPopularMuseum.setHasFixedSize(true)
        binding.recyclerViewPopularMuseum.adapter = popularMuseumAdapter

        binding.recyclerViewRecommendedMuseum.layoutManager =
            object : GridLayoutManager(requireContext(), 2) {
                override fun canScrollHorizontally(): Boolean {
                    return false
                }
            }
        binding.recyclerViewRecommendedMuseum.setHasFixedSize(true)
        binding.recyclerViewRecommendedMuseum.adapter = recommendedMuseumAdapter
    }

    private fun recyclerViewScrollListener() {
        binding.recyclerViewPopularMuseum.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

        binding.recyclerViewRecommendedMuseum.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
}