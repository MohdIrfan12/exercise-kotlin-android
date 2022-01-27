package com.fueled.data.util

import android.content.Context
import com.fueled.R
import java.io.*


/**
 * Created by Mohd Irfan on 26/1/22.
 */
class FileReader(val context: Context) {

    fun getUsers():String {
        val inputStream = context.getResources().openRawResource(R.raw.users)
        return convertStreamToString(inputStream)
    }

    fun getPosts():String {
        val inputStream = context.getResources().openRawResource(R.raw.posts)
        return convertStreamToString(inputStream)
    }

    fun getComments():String {
        val inputStream = context.getResources().openRawResource(R.raw.comments)
        return convertStreamToString(inputStream)
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val writer: Writer = StringWriter()
        val buffer = CharArray(1024)
        try {
            val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
            var n: Int
            while (reader.read(buffer).also { n = it } != -1) {
                writer.write(buffer, 0, n)
            }
        } finally {
            inputStream.close()
        }
        return writer.toString()
    }

}