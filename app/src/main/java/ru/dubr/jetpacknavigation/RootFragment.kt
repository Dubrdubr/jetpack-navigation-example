package ru.dubr.jetpacknavigation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import ru.dubr.jetpacknavigation.databinding.FragmentRootBinding

class RootFragment : Fragment(R.layout.fragment_root) {

    private var fragmentRootBinding: FragmentRootBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentRootBinding.bind(view)
        fragmentRootBinding = binding
        binding.openGreenBoxButton.setOnClickListener {
            openBox(Color.rgb(0, 129, 0), "Green")
        }
        binding.openYellowBoxButton.setOnClickListener {
            openBox(Color.rgb(0, 255, 0), "Yellow")
        }

        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE,
            viewLifecycleOwner) { _, data ->
            val number = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), "Generated number $number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openBox(color: Int, colorName: String) {
        val direction = RootFragmentDirections.actionRootFragmentToBoxFragment(color, colorName)
        findNavController().navigate(direction)
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentRootBinding = null
    }
}