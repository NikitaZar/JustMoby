package ru.nikitazar.justmoby.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ru.nikitazar.justmoby.R
import ru.nikitazar.justmoby.databinding.FragmentListBinding
import ru.nikitazar.justmoby.dto.CategoryData
import ru.nikitazar.justmoby.ui.adapters.CategoryAdapter
import ru.nikitazar.justmoby.viewModel.ListViewModel

@AndroidEntryPoint
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val categoryAdapter = CategoryAdapter()
        binding.list.adapter = categoryAdapter

        viewModel.data.observe(viewLifecycleOwner) { data ->
            categoryAdapter.submitList(data)
        }

        return binding.root
    }
}