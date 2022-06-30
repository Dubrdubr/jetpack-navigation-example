package ru.dubr.jetpacknavigation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dubr.jetpacknavigation.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {

    private var fragmentSecretBinding: FragmentSecretBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSecretBinding.bind(view)
        fragmentSecretBinding = binding
        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.closeBoxButton.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentSecretBinding = null
    }
}