package com.hbb20.androidcountrypicker

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hbb20.CPDataStoreGenerator
import com.hbb20.countrypicker.CPRecyclerViewHelper
import com.hbb20.countrypicker.DefaultEmojiFlagProvider
import com.hbb20.countrypicker.config.CPRecyclerViewConfig
import kotlinx.android.synthetic.main.activity_custom_recycler_view.*

class CustomRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_recycler_view)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        CPRecyclerViewHelper.load(
            recyclerView,
            CPDataStoreGenerator.generate(resources),
            preferredCountryCodes = "IN,US,NZ,RU",
            cpRecyclerViewConfig = CPRecyclerViewConfig(
                rowFontSizeInSP = 14f,
                flagProvider = DefaultEmojiFlagProvider()
            ),
            onCountryClickListener = { cpCountry ->
                Toast.makeText(
                    this,
                    "Selected ${cpCountry.englishName}",
                    Toast.LENGTH_LONG
                ).show()
            }
        )
    }
}