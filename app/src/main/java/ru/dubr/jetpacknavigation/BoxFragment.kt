package ru.dubr.jetpacknavigation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dubr.jetpacknavigation.databinding.FragmentBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.fragment_box) {

    private var fragmentBoxBinding: FragmentBoxBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentBoxBinding.bind(view)
        fragmentBoxBinding = binding

        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding.generateNumberButton.setOnClickListener {
            val number = Random.nextInt(100)
            parentFragmentManager.setFragmentResult(
                REQUEST_CODE,
                bundleOf(EXTRA_RANDOM_NUMBER to number)
            )
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentBoxBinding = null
    }

    companion object {
        const val ARG_COLOR = "ARG_COLOR"

        const val REQUEST_CODE = "RANDOM_NUMBER_REQUEST_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}