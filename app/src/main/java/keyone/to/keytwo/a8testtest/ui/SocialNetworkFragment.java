package keyone.to.keytwo.a8testtest.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import keyone.to.keytwo.a8testtest.R;

public class SocialNetworkFragment extends Fragment {


    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycleView);
        String[] allData = getResources().getStringArray(R.array.titles);
        recyclerView.setHasFixedSize(true);
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);*/
        Log.d("mylogs",allData.length+" le");
        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(allData);
        socialNetworkAdapter.setOnMyClickListener(new OnMyClickListener() {
            @Override
            public void onMyClick(View view, int position) {
                Toast.makeText(container.getContext(),"Получилось "+((TextView) view).getText()+" "+position,Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(socialNetworkAdapter);
        return view;
    }
}