package oldEntriesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.android.grata.database.GratitudeEntryDao
import kotlinx.coroutines.*

class OldEntriesListViewModel (val database: GratitudeEntryDao,
                               application: Application): AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var entries = database.getAllEntries()

    init {
        entries = database.getAllEntries()
    }

    fun onClearClicked(){
        uiScope.launch {
            // Clear the database table.
            clear()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
