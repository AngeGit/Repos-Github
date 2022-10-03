package com.easytech.devexperto_androiddesdecero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.easytech.devexperto_androiddesdecero.recyclerview_exercise.model.adapter.MoviesAdapter
import com.proyectos.angie.blockbuster.model.Movie

class MainActivity : AppCompatActivity() {
    private var TAG= "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) { //1era funcion
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicializaciones
        Log.d(TAG, "On Create")
        val movie=findViewById<ImageView>(R.id.iv_prueba_glide)
        Glide.with(movie.context).load("https://loremflickr.com/g/320/240/paris").into(movie)
        ejercicioRecyclerView()
    }

    private fun ejercicioRecyclerView() {
        setContentView(R.layout.recycler_view_exercise)
        var recycler= findViewById<RecyclerView>(R.id.recycler)
        //val layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true)
        val layoutManager=GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false)
        recycler.layoutManager=layoutManager
        recycler.adapter= MoviesAdapter(listOf(
            Movie(0, "Aladdin",
                "A kind-hearted street urchin Aladdin vies for the love of the beautiful princess Jasmine, the princess of Agrabah. When he finds a magic lamp, he uses the genie's magic power to make himself a prince in order to marry her. He's also on a mission to stop the powerful Jafar who plots to steal the magic lamp that could make his deepest wishes come true.",
                "https://loremflickr.com/g/320/240/paris?lock=1"
            ),
            Movie(1, "Avengers: Endgame",
                "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos's actions and undo the chaos to the universe, no matter what consequences may be in store, and no matter who they face...",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/bridgerton-201-unit-03419r-1648192328.jpg"
            ),
            Movie(3, "Kill Bill: Vol. 1",
                "The lead character, called 'The Bride,' was a member of the Deadly Viper Assassination Squad, led by her lover 'Bill.' Upon realizing she was pregnant with Bill's child, 'The Bride' decided to escape her life as a killer. She fled to Texas, met a young man, who, on the day of their wedding rehearsal was gunned down by an angry and jealous Bill (with the assistance of the Deadly Viper Assassination Squad). Four years later, 'The Bride' wakes from a coma, and discovers her baby is gone. She, then, decides to seek revenge upon the five people who destroyed her life and killed her baby. The saga of Kill Bill Volume I begins.",
                "https://pbs.twimg.com/media/FPSfMjlXoAo_UXt?format=jpg&name=small"
            ),    Movie(4, "Aladdin",
                "A kind-hearted street urchin Aladdin vies for the love of the beautiful princess Jasmine, the princess of Agrabah. When he finds a magic lamp, he uses the genie's magic power to make himself a prince in order to marry her. He's also on a mission to stop the powerful Jafar who plots to steal the magic lamp that could make his deepest wishes come true.",
                "https://imgix.bustle.com/uploads/image/2022/3/30/af468096-1ff8-49eb-af2e-b8870195f353-bridgerton_202_unit_00149r.jpg?w=1200&h=630&fit=crop&crop=focalpoint&fm=jpg&fp-x=0.5653&fp-y=0.2395"
            ),
            Movie(5, "Avengers: Endgame",
                "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos's actions and undo the chaos to the universe, no matter what consequences may be in store, and no matter who they face...",
                "https://64.media.tumblr.com/df8fb1f714e3c691dd1067e10e8ba688/1e40e4a85fb833c9-40/s540x810/e530523e6be93876d7bb917f44478bae33ab4afd.jpg"
            ),
            Movie(6, "Kill Bill: Vol. 1",
                "The lead character, called 'The Bride,' was a member of the Deadly Viper Assassination Squad, led by her lover 'Bill.' Upon realizing she was pregnant with Bill's child, 'The Bride' decided to escape her life as a killer. She fled to Texas, met a young man, who, on the day of their wedding rehearsal was gunned down by an angry and jealous Bill (with the assistance of the Deadly Viper Assassination Squad). Four years later, 'The Bride' wakes from a coma, and discovers her baby is gone. She, then, decides to seek revenge upon the five people who destroyed her life and killed her baby. The saga of Kill Bill Volume I begins.",
                "https://www.tuaudiolibro.com.ve/wp-content/uploads/2021/08/tW3lwCV-819x1024.jpeg")
        ))
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "On Start")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "On Resume")
    }
    override fun onPause() { //La activity se sigue viendo en pantalla, pero algo la cubre o bloquea (dialog, etc.)
        super.onPause()
        Log.d(TAG, "On Pause")
    }
    override fun onStop() { //La activity pasa a segundo plano, cuando una actividad se pone por encima.
        super.onStop()
        Log.d(TAG, "On Stop")
    }
    override fun onDestroy() {//última fun
        Log.d(TAG, "On Destroy")
        super.onDestroy()
        //Cosas que no deben sobrevivir cuando la actividad se destruya

    }








}