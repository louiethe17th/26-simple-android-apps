package com.example.tyler.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tyler.myapplication.models.Games;

public class ImageArray extends AppCompatActivity {
    private int index;

    Games[] games = {
            new Games("The Witcher 3: Wild Hunt", R.drawable.witcher, "97/100", "Fantasy RPG", "The Witcher: Wild Hunt is a story-driven, next-generation open world role-playing game set in a visually stunning fantasy universe full of meaningful choices and impactful consequences. In The Witcher you play as the professional monster hunter, Geralt of Rivia, tasked with finding a child of prophecy in a vast open world rich with merchant cities, viking pirate islands, dangerous mountain passes, and forgotten caverns to explore."  ),
            new Games("Battlefield 1", R.drawable.bf1, "91/100", "FPS", "Battlefield™ 1 takes you back to The Great War, WW1, where new technology and worldwide conflict changed the face of warfare forever. Take part in every battle, control every massive vehicle, and execute every maneuver that turns an entire fight around. The whole world is at war – see what’s beyond the trenches." ),
            new Games("World of Warcraft", R.drawable.wow, "92/100", "MMORPG", "World of Warcraft® is an online role-playing experience set in the award-winning Warcraft universe. Players assume the roles of Warcraft heroes as they explore, adventure, and quest across a vast world. Being \"Massively Multiplayer,\" World of Warcraft allows thousands of players to interact within the same world. Whether adventuring together or fighting against each other in epic battles, players will form friendships, forge alliances, and compete with enemies for power and glory.")
    };

    private Button mScoreboard;
    private ImageView picture;
    private TextView title;
    private TextView rating;
    private TextView genre;
    private TextView description;
    private TextView pages;


    private Button prev;
    private Button next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_array);

        index = 0;

        picture = findViewById(R.id.picture);
        title = findViewById(R.id.title);
        rating = findViewById(R.id.rating);
        genre = findViewById(R.id.genre);
        description = findViewById(R.id.description);

        mScoreboard = findViewById(R.id.Scoreboard);
        final Intent intent = new Intent(this, MainActivity.class);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        pages = findViewById(R.id.pages);

        showGame();
        showPages();

        mScoreboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
                showPages();

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
                showPages();

            }
        });
    }

    public void increment() {
        index++;
        showGame();
    }

    public void decrement() {
        index--;
        showGame();
    }


    public void showGame(){
        cycle();

            Games game = games[index];
            title.setText(game.title);
            description.setText(game.description);
            genre.setText(game.genre);
            rating.setText("Rating: " + game.rating);

            Drawable pic = getResources().getDrawable(game.drawableId);
            picture.setImageDrawable(pic);

        }

        public void cycle() {
            // assume the best
            next.setEnabled(true);
            prev.setEnabled(true);

            if (index < 0) {
                index = games.length - 1;
            } else {
                index = index % games.length;
            }
        }

        public void preventBounds() {
            // assume the best
            next.setEnabled(true);
            prev.setEnabled(true);

            // guarantee the current index is between zero and the length of the array
            index = Math.max(index, 0);
            index = Math.min(index, games.length - 1);

            // deal with the worst
            if (index == games.length - 1) {
                next.setEnabled(false);
            }

            if (index == 0) {
                prev.setEnabled(false);
            }

    }
    public void showPages(){
        int currentIndex = index + 1;
        int length = games.length;

        pages.setText(currentIndex + "/" + length);

    }
}
