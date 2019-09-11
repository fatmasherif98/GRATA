package AddNewEntry

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.android.grata.R
import com.example.android.grata.databinding.AddNewEntryFragmentBinding

class AddNewEntryFragment : Fragment() {

    companion object {
        fun newInstance() = AddNewEntryFragment()
    }

    private lateinit var viewModel: AddNewEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding = AddNewEntryFragmentBinding.inflate(inflater)
        viewModel = ViewModelProviders.of(this).get(AddNewEntryViewModel::class.java)
        binding.viewModel = viewModel
        return binding.root
    }



}
