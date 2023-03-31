package du.meng.chart

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase

class UserView : AppCompatActivity() {
    val users =ArrayList<UserModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_user_view)
        val mRecyclerView = findViewById<RecyclerView>(R.id.recyclerUserView)
        // Set its Properties using LinearLayout
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        // Set RecyclerView Adapter
        Log.d("Yes",Local_user.name)

        val db = FirebaseDatabase.getInstance().getReference().child("Users")
        val childEventListener = object : ChildEventListener {
            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("fire", "onChildAdded:" + dataSnapshot.key!!)

                // A new comment has been added, add it to the displayed list
                try {
                    var comment: UserModel? = dataSnapshot.getValue(UserModel::class.java) ?: return

                    users.add(comment!!)
                    val myAdapter = UserAdapter(this@UserView, users)
                    mRecyclerView.setAdapter(myAdapter)
                    Log.d("fire", comment.name + comment.email)
                }
                catch (e:Exception){
                    return
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("fire", "onChildChanged: ${dataSnapshot.key}")

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so displayed the changed comment.
                val newComment = dataSnapshot.getValue()
                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                Log.d("fire", "onChildRemoved:" + dataSnapshot.key!!)

                // A comment has changed, use the key to determine if we are displaying this
                // comment and if so remove it.
                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onChildMoved(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("fire", "onChildMoved:" + dataSnapshot.key!!)

                // A comment has changed position, use the key to determine if we are
                // displaying this comment and if so move it.
                val movedComment = dataSnapshot.getValue()
                val commentKey = dataSnapshot.key

                // ...
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("fire", "postComments:onCancelled", databaseError.toException())
                Toast.makeText(baseContext, "Failed to load comments.",
                    Toast.LENGTH_SHORT).show()
            }
        }
        db.addChildEventListener(childEventListener)


    }
    // Add Models to arraylist

}