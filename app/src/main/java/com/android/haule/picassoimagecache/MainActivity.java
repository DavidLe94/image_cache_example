package com.android.haule.picassoimagecache;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private String linkImg = "https://specials-images.forbesimg.com/imageserve/59ca3f6531358e542c02dfa0/416x416.jpg?background=000000&cropX1=335&cropX2=1333&cropY1=1014&cropY2=2013";
    @BindView(R.id.img_view) ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //load image from internet
        //if image not found -> display image error
        //when loading image -> display image place horder
        //save image cache when first load image, the second load -> call from cache
        Picasso.get().load(linkImg)
                .error(R.drawable.ic_image_load_eror)
                .placeholder(R.drawable.ic_place_holder)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imgView);
    }
}
