package du.meng.chart
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UserHolder(itemView: View) : ViewHolder(itemView) {
    //views

    var mImageFlag: ImageView
    var mUserName: TextView
    var mUserInfo: TextView
    var mRelative: RelativeLayout
    init {
        mImageFlag = itemView.findViewById(R.id.cardImageflag)
        mUserName = itemView.findViewById(R.id.cardUserName)
        mUserInfo = itemView.findViewById(R.id.cardUserInfo)
        mRelative = itemView.findViewById(R.id.relative)
    }
}