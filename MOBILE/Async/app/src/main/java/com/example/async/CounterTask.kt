package com.example.async

import android.os.AsyncTask
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView

class CounterTask(val button: Button, val textView: TextView): AsyncTask<Int,Int,Unit>() {

    override fun doInBackground(vararg p0: Int?) {
        var max = p0[0] as Int
        for (i in 0..max){
            SystemClock.sleep(500)
            publishProgress(i)
        }
    }

    override fun onPreExecute() {
        super.onPreExecute()
        button.isEnabled = false
    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        button.isEnabled = true
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)

        val contador = values[0]
        textView.text = contador.toString()

    }


}