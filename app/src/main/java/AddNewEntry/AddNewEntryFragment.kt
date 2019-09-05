package AddNewEntry

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.android.grata.R

class AddNewEntryFragment : Fragment() {

    companion object {
        fun newInstance() = AddNewEntryFragment()
    }

    private lateinit var viewModel: AddNewEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_new_entry_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddNewEntryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
