package keyone.to.keytwo.a8testtest.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import keyone.to.keytwo.a8testtest.R;

public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private String[] dataSource;

    OnMyClickListener clickListener;


    public void setOnMyClickListener(OnMyClickListener onMyClickListener) {
        this.clickListener = onMyClickListener;
    }

    public SocialNetworkAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public SocialNetworkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new SocialNetworkAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SocialNetworkAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            this.textView =   ((LinearLayout) itemView).findViewById(R.id.textView);
            this.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onMyClick(textView,getAdapterPosition());
                }
            });
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
