package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tencent.connect.share.QQShare
import com.tencent.connect.share.QQShare.SHARE_TO_QQ_TYPE_DEFAULT
import com.tencent.tauth.IUiListener
import com.tencent.tauth.Tencent
import com.tencent.tauth.UiError
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mTencent: Tencent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mTencent = Tencent.createInstance("101869003", this.getApplicationContext());
        tv_share.setOnClickListener {
//            onClickShare()
            var bottomSelectDialog:BottomSelectDialog= BottomSelectDialog()
            bottomSelectDialog.show(supportFragmentManager,"show")
        }
    }

    private fun onClickShare() {
        val params = Bundle()
        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, SHARE_TO_QQ_TYPE_DEFAULT)
        params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题")
        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要")
        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "https://www.baidu.com/")
        params.putString(
            QQShare.SHARE_TO_QQ_IMAGE_URL,
            "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2683403104,2904190188&fm=26&gp=0.jpg"
        )
        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222")
        mTencent.shareToQQ(this, params, object : IUiListener{
            override fun onComplete(p0: Any?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onCancel() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onError(p0: UiError?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}
