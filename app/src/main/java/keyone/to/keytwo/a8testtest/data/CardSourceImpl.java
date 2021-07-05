package keyone.to.keytwo.a8testtest.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import keyone.to.keytwo.a8testtest.MainActivity;
import keyone.to.keytwo.a8testtest.R;

public class CardSourceImpl implements CardSource {
    private List<CardData> dataSource;
    private Resources resources;


    public CardSourceImpl(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public CardSourceImpl init() {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.desriptions);
        int[] pictures = getImages();

        for(int i =0;i<titles.length;i++){

            dataSource.add(new CardData(titles[i],descriptions[i],pictures[i],false));
        }
        return this;
    }






    private int[] getImages() {
        TypedArray typedArray = resources.obtainTypedArray(R.array.images);
        int[] images = new int[typedArray.length()];
        for(int i=0;i<typedArray.length();i++){
            Log.d("mylogs","typedArray.getResourceId(i,-1) "+typedArray.getResourceId(i,-1));
            images[i] =typedArray.getResourceId(i,-1);
        }
        return images;
    }


    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public CardData getGardData(int position) {
        Log.d("mylogs","position"+position);

        if(position>=dataSource.size()){
            position = position%7;
        }
        Log.d("mylogs","position"+position);
        return dataSource.get(position);
    }
}
