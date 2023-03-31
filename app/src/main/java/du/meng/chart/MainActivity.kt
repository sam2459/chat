package du.meng.chart

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Comment
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Write a message to the database
        val intent = intent
        val tName = intent.getStringExtra("tName")
        val db = FirebaseDatabase.getInstance().getReference().child("Users")

        val bt: Button=findViewById<Button>(R.id.button)
        Log.d("Name",tName!!)
        bt.setText(tName)
        var x=0
        bt.setOnClickListener{

            x= x xor 1
            Log.d(TAG, "x is: $x")
        }

    }
}