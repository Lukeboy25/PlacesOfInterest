package hva.nl.placesofinterest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        placeAdapter.notifyDataSetChanged()
        initViews()
    }

    private fun initViews() {
        // Should use StaggeredGridLayoutManager here, but GridLayoutManager looks even nicer!
        rvPlaces.layoutManager = GridLayoutManager(this@MainActivity, 2, RecyclerView.VERTICAL, false)
        rvPlaces.adapter = placeAdapter
        rvPlaces.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
    }

}
