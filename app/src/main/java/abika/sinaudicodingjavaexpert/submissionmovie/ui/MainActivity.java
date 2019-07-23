package abika.sinaudicodingjavaexpert.submissionmovie.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import abika.sinaudicodingjavaexpert.submissionmovie.model.Movie;
import abika.sinaudicodingjavaexpert.submissionmovie.model.MovieAdapter;
import abika.sinaudicodingjavaexpert.submissionmovie.R;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel listMovie
    private ListView listMovie;
    //deklarasi variabel movies
    private ArrayList<Movie> movies;

//    private String title = "MOVIE CATALOGUE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisiasi variabel listMovie
        listMovie = findViewById(R.id.lv_main_list);

        //inisiasi variabel movies
        movies = generateDummmyData();

        //deklarasi variabel adapter sebagai adapter untuk listMovie
        MovieAdapter adapter = new MovieAdapter(this, movies);

        //set variabel adapter sebagai adapter untuk listMovie
        listMovie.setAdapter(adapter);

        //set listener saat salah satu item di-klik
        listMovie.setOnItemClickListener(listener);

        setActionBarTitle("MOVIE CATALOGUE");
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    //deklarasi variabel listener untuk digunakan menangkap event saat sebuah item di-klik
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
            detailIntent.putExtra(DetailActivity.EXTRA_MOVIE, movies.get(position));
            startActivity(detailIntent);
        }
    };


    //Men-generate daftar pemain secara hardcode
    private static ArrayList<Movie> generateDummmyData(){
        ArrayList<Movie> dummyMovies = new ArrayList<>();

        //Movie 0 :
        Movie movie = new Movie();
        movie.setMovieName("A Star Is Born");
        movie.setMovieDescription("Seasoned musician Jackson Maine discovers, and falls in love with, struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally\\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.");
        movie.setMovieRelease("19 January 2019");
        movie.setMovieGenre("Drama, Romance, Music");
        movie.setMovieRating(7.8f);
        movie.setImgResource(R.drawable.mv_a_start_is_born);

        dummyMovies.add(movie);

        //Movie 1 :
        movie = new Movie();
        movie.setMovieName("Aquaman");
        movie.setMovieDescription("Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.");
        movie.setMovieRelease("7 December 2018");
        movie.setMovieGenre("Action, Adventure, Fantasy");
        movie.setMovieRating(7.1f);
        movie.setImgResource(R.drawable.mv_alita);

        dummyMovies.add(movie);

        //Movie 2 :
        movie = new Movie();
        movie.setMovieName("Avenger Infinity War");
        movie.setMovieDescription("As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.");
        movie.setMovieRelease("23 April 2018");
        movie.setMovieGenre("Action, Adventure, Fantasy");
        movie.setMovieRating(8.4f);
        movie.setImgResource(R.drawable.mv_aquaman);

        dummyMovies.add(movie);

        //Movie 3 :
        movie = new Movie();
        movie.setMovieName("Bird Box");
        movie.setMovieDescription("Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.");
        movie.setMovieRelease("13 December 2018");
        movie.setMovieGenre("Thriller, Drama");
        movie.setMovieRating(6.6f);
        movie.setImgResource(R.drawable.mv_bohemian);

        dummyMovies.add(movie);

        //Movie 4 :
        movie = new Movie();
        movie.setMovieName("Bohemian Rapsody");
        movie.setMovieDescription("Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.");
        movie.setMovieRelease("4 October 2018");
        movie.setMovieGenre("Drama, Music");
        movie.setMovieRating(8.0f);
        movie.setImgResource(R.drawable.mv_cold_persuit);

        dummyMovies.add(movie);

        //Movie 5 :
        movie = new Movie();
        movie.setMovieName("Bumblebee");
        movie.setMovieDescription("On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.");
        movie.setMovieRelease("15 December 2018");
        movie.setMovieGenre("Action, Adventure, Science Fiction");
        movie.setMovieRating(7.2f);
        movie.setImgResource(R.drawable.mv_creed);

        dummyMovies.add(movie);

        //Movie 6 :
        movie = new Movie();
        movie.setMovieName("Creed II");
        movie.setMovieDescription("Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.");
        movie.setMovieRelease("21 November 2018");
        movie.setMovieGenre("Drama");
        movie.setMovieRating(7.8f);
        movie.setImgResource(R.drawable.mv_crimes);

        dummyMovies.add(movie);

        //Movie 7 :
        movie = new Movie();
        movie.setMovieName("Once Upon a Deadpool");
        movie.setMovieDescription("A kidnapped Fred Savage is forced to endure Deadpool's PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that's full of magic, wonder & zero F's.");
        movie.setMovieRelease("11 December 2018");
        movie.setMovieGenre("Comedy, Action");
        movie.setMovieRating(7.6f);
        movie.setImgResource(R.drawable.mv_glass);

        dummyMovies.add(movie);

        //Movie 8 :
        movie = new Movie();
        movie.setMovieName("How To Train Your Dragon: The Hidden World");
        movie.setMovieDescription("As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.");
        movie.setMovieRelease("3 Januari 2019");
        movie.setMovieGenre("Animation, Family, Adventure");
        movie.setMovieRating(8.0f);
        movie.setImgResource(R.drawable.mv_how_to_train);

        dummyMovies.add(movie);

        //Movie 9 :
        movie = new Movie();
        movie.setMovieName("Dragon Ball Super: BROLY");
        movie.setMovieDescription("Earth is peaceful following the Tournament of Power. Realizing that the universes still hold many more strong people yet to see, Goku spends all his days training to reach even greater heights. Then one day, Goku and Vegeta are faced by a Saiyan called 'Broly' who they've never seen before. The Saiyans were supposed to have been almost completely wiped out in the destruction of Planet Vegeta, so what's this one doing on Earth? This encounter between the three Saiyans who have followed completely different destinies turns into a stupendous battle, with even Frieza (back from Hell) getting caught up in the mix.");
        movie.setMovieRelease("4 December 2018");
        movie.setMovieGenre("Action, Animation, Comedy, Fantasy, Adventure, Science Fiction");
        movie.setMovieRating(8.0f);
        movie.setImgResource(R.drawable.mv_infinity_war);

        dummyMovies.add(movie);

        //Movie 10 :
        movie = new Movie();
        movie.setMovieName("Glass");
        movie.setMovieDescription("In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.");
        movie.setMovieRelease("16 Januari 2019");
        movie.setMovieGenre("Thriller, Drama, Science Fiction");
        movie.setMovieRating(6.8f);
        movie.setImgResource(R.drawable.mv_marry_queen);

        dummyMovies.add(movie);

        //Movie 11 :
        movie = new Movie();
        movie.setMovieName("Hunter Killer");
        movie.setMovieDescription("Captain Glass of the USS Arkansas discovers that a coup d'état is taking place in Russia, so he and his crew join an elite group working on the ground to prevent a war.");
        movie.setMovieRelease("19 October 2018");
        movie.setMovieGenre("Action, Thriller");
        movie.setMovieRating(6.6f);
        movie.setImgResource(R.drawable.mv_master_z);

        dummyMovies.add(movie);

        //Movie 12 :
        movie = new Movie();
        movie.setMovieName("Mary Poppins Return");
        movie.setMovieDescription("In Depression-era London, a now-grown Jane and Michael Banks, along with Michael's three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives.");
        movie.setMovieRelease("13 December 2018");
        movie.setMovieGenre("Fantasy, Family, Comedy");
        movie.setMovieRating(6.9f);
        movie.setImgResource(R.drawable.mv_mortal_engines);

        dummyMovies.add(movie);

        //Movie 13 :
        movie = new Movie();
        movie.setMovieName("Mortal Engines");
        movie.setMovieDescription("Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.");
        movie.setMovieRelease("27 November 2018");
        movie.setMovieGenre("Adventure, Fantasy");
        movie.setMovieRating(6.1f);
        movie.setImgResource(R.drawable.mv_overlord);

        dummyMovies.add(movie);

        //Movie 14 :
        movie = new Movie();
        movie.setMovieName("Preman Pensiun The Movie");
        movie.setMovieDescription("We don\\'t have an overview translated in English. Help us expand our database by adding one.");
        movie.setMovieRelease("17 Januari 2019");
        movie.setMovieGenre("Comedy, Drama");
        movie.setMovieRating(8.0f);
        movie.setImgResource(R.drawable.mv_ralph);

        dummyMovies.add(movie);

        //Movie 15 :
        movie = new Movie();
        movie.setMovieName("Robin Hood");
        movie.setMovieDescription("A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.");
        movie.setMovieRelease("20 November 2018");
        movie.setMovieGenre("Action, Adventure, Thriller");
        movie.setMovieRating(5.3f);
        movie.setImgResource(R.drawable.mv_robin_hood);

        dummyMovies.add(movie);

        //Movie 16 :
        movie = new Movie();
        movie.setMovieName("Spiderman :Into The Spider-Verse");
        movie.setMovieDescription("Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.");
        movie.setMovieRelease("6 December 2018");
        movie.setMovieGenre("Action, Adventure, Animation, Science Fiction, Comedy");
        movie.setMovieRating(8.5f);
        movie.setImgResource(R.drawable.mv_serenity);

        dummyMovies.add(movie);

        //Movie 17 :
        movie = new Movie();
        movie.setMovieName("The Girl In The Spider Web");
        movie.setMovieDescription("In Stockholm, Sweden, hacker Lisbeth Salander is hired by Frans Balder, a computer engineer, to retrieve a program that he believes it is too dangerous to exist.");
        movie.setMovieRelease("25 October 2018");
        movie.setMovieGenre("Action, Crime, Thriller");
        movie.setMovieRating(6.1f);
        movie.setImgResource(R.drawable.mv_spiderman);

        dummyMovies.add(movie);

        //Movie 18 :
        movie = new Movie();
        movie.setMovieName("The Mule");
        movie.setMovieDescription("Earl Stone, a man in his 80s, is broke, alone, and facing foreclosure of his business when he is offered a job that simply requires him to drive. Easy enough, but, unbeknownst to Earl, he’s just signed on as a drug courier for a Mexican cartel. He does so well that his cargo increases exponentially, and Earl hit the radar of hard-charging DEA agent Colin Bates.");
        movie.setMovieRelease("14 December 2018");
        movie.setMovieGenre("Crime, Drama, Thriller");
        movie.setMovieRating(7.1f);
        movie.setImgResource(R.drawable.mv_t34);

        dummyMovies.add(movie);

        //Movie 19 :
//        movie = new Movie();
//        movie.setMovieName("Venom");
//        movie.setMovieDescription("Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.");
//        movie.setMovieRelease("28 September 2018");
//        movie.setMovieGenre("Action, Comedy");
//        movie.setMovieRating(6.7f);
//        movie.setImgResource(R.drawable.mv_venom);
//
//        dummyMovies.add(movie);
//        //dan seterusnya

        return dummyMovies;
    }

}
