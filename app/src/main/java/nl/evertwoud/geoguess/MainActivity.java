package nl.evertwoud.geoguess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout imageHolder = findViewById(R.id.image_holder);

        //Chose not to use use a RecyclerView on purpose as this will recycle and reinflate the views. This will remove the chosen selection of the imageview.
        for (GuessImage img : getItemList()){
            EuropeSwipingImageView imgView = new EuropeSwipingImageView(this);
            imgView.setEurope(img.isEurope());
            //Use glide for loading cause this uses the background thread and optimizes the view.
            Glide.with(this).load(img.getResId()).into(imgView);
            imgView.setAdjustViewBounds(true);
            imageHolder.addView(imgView);
        }
    }

    //Returns a list of GuessImages which will be loaded into the Scrollview
    List<GuessImage> getItemList() {
        List<GuessImage> items = new LinkedList<>();
        items.add(new GuessImage(R.drawable.img1_yes_denmark, true));
        items.add(new GuessImage(R.drawable.img2_no_canada, false));
        items.add(new GuessImage(R.drawable.img3_no_bangladesh, false));
        items.add(new GuessImage(R.drawable.img4_yes_kazachstan, true));
        items.add(new GuessImage(R.drawable.img5_no_colombia, false));
        items.add(new GuessImage(R.drawable.img6_yes_poland, true));
        items.add(new GuessImage(R.drawable.img7_yes_malta, true));
        items.add(new GuessImage(R.drawable.img8_no_thailand, false));
        return items;
    }
}


