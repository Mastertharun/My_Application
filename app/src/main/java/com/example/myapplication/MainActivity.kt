import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.kotlinexss.Employee

class MainActivity : AppCompatActivity() {
    //activiy is getting created -- chick is in the egg -- mem being allocated for activity
    var TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inflate this xml
        setContentView(R.layout.activity_main)
        Log.i(TAG,"activity is getting created")
        // inflateXml()
        // var myEmp = Employee("abdul")
    }

    //chick came out of the egg --activity is visible to the user to interact - click
    override fun onStart() {
        super.onStart()
        Log.e(TAG,"activity is started")
    }

    //sleep night -- incomming call ur activity goes into the background for sometime
    override fun onPause() {
        super.onPause()
        Log.w(TAG,"activity has paused")

    }

    //death of the chick -- activity no lonnger exists in the ram -- pushed to hdd[hibernate]
    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity is stopped")

    }



    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity is destroyed")
    }

    fun clickHandler(view: View) {
        Log.i("MainActivity-clickhandler","button clicked")
        /*  var dialIntent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:98765432"))  //intent= intention
           var webIntent: Intent = Intent(Intent.ACTION_VIEW,Uri.parse("http://www.ndtv.com"))
           startActivity(webIntent)*/
        var hIntent:Intent = Intent(this,HomeActivity::class.java)
        hIntent.putExtra("mykey","android-vit-abdul")
        startActivity(hIntent)
    }


    fun inflateXml(){
        var nameEditText = EditText(this)
        nameEditText.setHint("enter ur name")
        var pwdEditText = EditText(this)
        pwdEditText.setHint("enter ur pass")
        var loginButton = Button(this)
        loginButton.setText("login")
    }

}