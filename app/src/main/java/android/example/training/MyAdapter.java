package android.example.training;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;







public class MyAdapter extends RecyclerView.Adapter<MyAdapter.OwnAdapter> {

    String[] data1,data2;
    int[] img;
    Context ctx;


public MyAdapter(Context ct,String[] s1,String[] s2,int[] im)
{

    data1=s1;
    data2=s2;
    img=im;
    ctx=ct;
}

    @NonNull
    @Override
    public OwnAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater layIf=LayoutInflater.from(ctx);
       View myOwnView= layIf.inflate(R.layout.myrow,parent,false);
        return new OwnAdapter(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull OwnAdapter holder, int position)
    {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.image.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class OwnAdapter extends RecyclerView.ViewHolder
    {
        ImageView image;
        TextView t1,t2;

        public OwnAdapter(@NonNull View itemView)
        {
            super(itemView);

            image=(ImageView)itemView.findViewById(R.id.imageView1);
            t1=(TextView)itemView.findViewById(R.id.textview1);
            t2=(TextView)itemView.findViewById(R.id.textview2);



        }
    }
}
