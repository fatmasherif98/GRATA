package oldEntriesList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.grata.database.GratitudeEntryDao

class OldEntriesListViewModelFactory(
    private val dataSource: GratitudeEntryDao,
    private val application: Application
): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OldEntriesListViewModel::class.java)) {
            return OldEntriesListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}