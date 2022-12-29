package com.example.editboxtextdisplay


import    androidx.appcompat.app.AppCompatActivity
import    android.os.Bundle
import    android.text.Editable
import    android.text.TextWatcher
import    android.util.Log
import    android.view.View
import    android.widget.TextView
import    android.widget.Toast
import    kotlinx.android.synthetic.main.activity_main.*
import    okhttp3.*
import    org.json.JSONObject
import    java.io.IOException

class MainActivity : AppCompatActivity() {
    private val client = OkHttpClient()

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) =
                println(response.body()?.string())
        })
    }

    fun responseApiSuccess(response: JSONObject) {
        Log.i("request-success", response.toString())
    }

    fun responseApiError(error: Exception) {
        Log.e("request-error", error.toString())
    }

    fun callAPI() {
        var queryObject: JSONObject = JSONObject()

        queryObject.put("barcode", "9780140157376");
        queryObject.put("formatted", "y");
        queryObject.put("key", "sa8wcih9qpnb7q1mwhydisbe3hphfo");

        try {
            RequestJSON.instance().setURL("https://api.barcodelookup.com/v3/products/").setMethod("GET").setQuery(queryObject).send(this, this::responseApiSuccess, this::responseApiError);
        } catch (error: Exception) {
            error.printStackTrace();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //callAPI() volley test
        run("https://api.barcodelookup.com/v3/products?barcode=9780140157376&formatted=y&key=sa8wcih9qpnb7q1mwhydisbe3hphfo") // okhttp3 test

        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val inputValue: String = editText.text.toString()
            if (inputValue == null || inputValue.trim() == "") {
                Toast.makeText(
                    this,
                    "please    input    data,    edit    text    cannot    be    blank",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                textView4.setText(inputValue).toString()
            }
        }
        textView5.setOnClickListener {
            if (textView4.text.toString() == null || textView4.text.toString().trim() == "") {
                Toast.makeText(
                    this,
                    "clicked    on    reset    textView,\n    output    textView    already    reset",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                textView4.setText("").toString()
            }
        }
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //        TODO("not    implemented")    //To    change    body    of    created    functions    use    File    |    Settings    |    File    Templates.
                Toast.makeText(
                    applicationContext,
                    "executed    before    making    any    change    over    EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //        TODO("not    implemented")    //To    change    body    of    created    functions    use    File    |    Settings    |    File    Templates.
                Toast.makeText(
                    applicationContext,
                    "executed    while    making    any    change    over    EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun afterTextChanged(p0: Editable?) {
                //        TODO("not    implemented")    //To    change    body    of    created    functions    use    File    |    Settings    |    File    Templates.
                Toast.makeText(
                    applicationContext,
                    "executed    after    change    made    over    EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}        