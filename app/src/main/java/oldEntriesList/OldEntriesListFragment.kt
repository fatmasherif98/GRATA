package oldEntriesList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.android.grata.database.GratitudeDatabase

import com.example.android.grata.databinding.OldEntriesListFragmentBinding

class OldEntriesListFragment : Fragment() {

    companion object {
        fun newInstance() = OldEntriesListFragment()
    }

    private lateinit var viewModel: OldEntriesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = OldEntriesListFragmentBinding.inflate(inflater)
        val application = requireNotNull(this.activity).application
        val dataSource = GratitudeDatabase.getInstance(application).gratitudeDatabaseDao
        val viewModelFactory = OldEntriesListViewModelFactory(dataSource, application)
         viewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(OldEntriesListViewModel::class.java)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

            val adapter = GradEntryAdapter()
        binding.entiresList.adapter = adapter

        viewModel.entries.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
        return binding.root
    }


}
