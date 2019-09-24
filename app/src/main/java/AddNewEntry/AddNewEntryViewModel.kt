package AddNewEntry

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.grata.database.GratitudeEntry
import com.example.android.grata.database.GratitudeEntryDao
import com.example.android.grata.formatDate
import kotlinx.coroutines.*
import java.util.*

class AddNewEntryViewModel (val database: GratitudeEntryDao,
                            application: Application): AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//sets the current date in the layout
    var dateString = formatDate(Calendar.getInstance().getTime())



     var gratitudeEntry = GratitudeEntry()

    //livedata for submit button
    private var _submitClicked = MutableLiveData<Boolean>()
    val submitClicked : LiveData<Boolean>
        get() =_showSnackbarEvent

// livedata for navigation
    private var _navigate = MutableLiveData<Boolean>()
    val navigate : LiveData<Boolean>
    get() = _navigate



    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent : LiveData<Boolean>
        get() =_showSnackbarEvent

    fun doneShowingSnackbar(){
        _showSnackbarEvent.value = false
    }

    fun onSubmitClicked(){

        _submitClicked.value = true
        _showSnackbarEvent.value = true
        Log.i("vm", "on submit clicked is working")
    }

    fun onSeeOldListClicked(){
        _navigate.value = true
        Log.i("vm", "onSeeOldListClicked is clicked")
    }

    fun onDoneNavigating(){
        _navigate.value = false
        Log.i("vm", "should be done navigating")
    }

    fun insertIntoDatabase(){
Log.i("vm", "insert into database is called")

        gratitudeEntry.date = dateString
        if( gratitudeEntry.firstEntry.equals(""))
            return
       uiScope.launch {
            insert()
        }
    }

    private suspend fun insert() {
        Log.i("vm", " ${gratitudeEntry.firstEntry} and ${gratitudeEntry.secondEntry}")
        withContext(Dispatchers.IO) {
            database.insert( gratitudeEntry)
        }
    }

     fun doneSubmitting(){
        _submitClicked.value = false
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
