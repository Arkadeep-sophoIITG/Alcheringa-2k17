package in.alcheringa.alcher16;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by hariharan on 15/1/16.
 */
public class RVAdapterProshows extends RecyclerView.Adapter<RVAdapterProshows.CViewHolder> {


    public static class CViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView personPhoto;


        CViewHolder(final View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view_concerts);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] names={"ijp","fasta","ouzo","tropicgreen","omarmusa","metastasis"};
                        Intent mIntent = new Intent(itemView.getContext(), ProNight.class);
                        mIntent.putExtra("name", names[getAdapterPosition()]);
                        itemView.getContext().startActivity(mIntent);
                }
            });
        }
    }

    List<ConcertItem> persons;

    RVAdapterProshows(List<ConcertItem> persons){
        this.persons = persons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public CViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_concerts, viewGroup, false);
        CViewHolder pvh = new CViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final CViewHolder personViewHolder, int i) {
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}