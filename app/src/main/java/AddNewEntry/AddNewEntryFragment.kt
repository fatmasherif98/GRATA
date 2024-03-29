package AddNewEntry

import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.grata.database.GratitudeDatabase

import com.example.android.grata.R
import com.example.android.grata.database.GratitudeEntry
import com.example.android.grata.databinding.AddNewEntryFragmentBinding
import com.google.android.material.snackbar.Snackbar
import android.graphics.BitmapFactory




class AddNewEntryFragment : Fragment() {

    companion object {
        fun newInstance() = AddNewEntryFragment()
    }

    private lateinit var viewModel: AddNewEntryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


//        val icon = BitmapFactory.decodeResource(
//            context?.getResources(),
//            com.example.android.grata.R.drawable.background
//        )

       val binding = AddNewEntryFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application

        val dataSource = GratitudeDatabase.getInstance(application).gratitudeDatabaseDao

        val viewModelFactory = AddNewEntryViewModelFactory(dataSource, application)

//        binding.imageView.setImageBitmap(icon)
        viewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(AddNewEntryViewModel::class.java)
        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)


//on clicking submit button
        viewModel.submitClicked.observe(this, Observer{
            if(it == true)
            {
                Log.i("fragment", "observer evoked")
                viewModel.insertIntoDatabase()
                viewModel.doneSubmitting()
            }
        })
//for naviagting to list of entries
        viewModel.navigate.observe( viewLifecycleOwner, Observer{
            Log.i("frag" , "before if statement")
            if( it == true){
                Log.i("frag" , "trying to navigate")
                this.findNavController().navigate( AddNewEntryFragmentDirections.actionAddNewEntryFragmentToOldEntriesListFragment())
                viewModel.onDoneNavigating()
            }
        })

//show snackBar
        viewModel.showSnackBarEvent.observe(this, Observer {
            if (it == true) {
                Snackbar.make(
                    activity!!.findViewById(android.R.id.content),
                    getString(com.example.android.grata.R.string.added_entry),
                    Snackbar.LENGTH_SHORT
                ).show()
                viewModel.doneShowingSnackbar()
            }
        })


        return binding.root
    }



}
