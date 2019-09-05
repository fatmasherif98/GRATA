package OldEntriesList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.android.grata.R

class OldEntriesListFragment : Fragment() {

    companion object {
        fun newInstance() = OldEntriesListFragment()
    }

    private lateinit var viewModel: OldEntriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.old_entries_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OldEntriesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
