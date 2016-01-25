package in.alcheringa.alcher16;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hariharan on 15/1/16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CViewHolder> {

    public static class CViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        ImageView personPhoto;


        CViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view_concerts);
            personName = (TextView)itemView.findViewById(R.id.cardTextView);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    List<ConcertItem> persons;

    RVAdapter(List<ConcertItem> persons){
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
    public void onBindViewHolder(CViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).name);
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}