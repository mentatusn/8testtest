package keyone.to.keytwo.a8testtest.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import keyone.to.keytwo.a8testtest.R;
import keyone.to.keytwo.a8testtest.data.CardData;
import keyone.to.keytwo.a8testtest.data.CardSource;
import keyone.to.keytwo.a8testtest.data.CardSourceImpl;
import keyone.to.keytwo.a8testtest.data.Memory;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    //private String[] dataSource;
    private CardSource dataSource;

    OnMyClickListener clickListener;



    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.clickListener = onMyClickListener;
    }

    public SocialNetworkAdapter(CardSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public SocialNetworkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new SocialNetworkAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SocialNetworkAdapter.ViewHolder holder, int position) {
        holder.setData(dataSource.getGardData(position));
    }

    @Override
    public int getItemCount() {
        return 100000000;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle;
        public ToggleButton checkBox;
        private ImageView imageView;
        private TextView textViewDescr;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            this.textViewDescr =   (itemView).findViewById(R.id.description);
            this.textViewTitle =  (itemView).findViewById(R.id.title);
            this.checkBox =  (itemView).findViewById(R.id.like);



            this.imageView =  (itemView).findViewById(R.id.imageView);
            this.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onMyClick(v,getAdapterPosition());
                }
            });

        }

        public void setData(CardData data) {
            this.textViewDescr.setText(data.getDescription());
            this.textViewTitle.setText(data.getTitle());
            Log.d("mylogs","data.getPicture() "+data.getPicture());
            this.imageView.setImageResource(data.getPicture());

            this.checkBox.setChecked(Memory.getLike(this.checkBox.getContext(),getAdapterPosition()));
            this.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Memory.setLike(checkBox.getContext(),getAdapterPosition(),isChecked);
                }
            });
            //this.checkBox.setChecked(data.isLike());
        }
    }
}
