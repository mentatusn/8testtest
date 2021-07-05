package keyone.to.keytwo.a8testtest.data;

import android.content.Context;
import android.content.SharedPreferences;

import keyone.to.keytwo.a8testtest.MainActivity;

public class Memory {

    public static boolean getLike(Context mContext,int position) {
        if (MainActivity._activity != null) {
            SharedPreferences sharedPreferences = mContext.getSharedPreferences("hack", Context.MODE_PRIVATE);
            return sharedPreferences.getBoolean("like_" + position, false);
        }
        return false;
    }
    public static void setLike(Context mContext,int position, boolean value) {
        SharedPreferences sp = mContext.getSharedPreferences("hack", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("like_"+position, value);
        editor.apply();
    }
}
