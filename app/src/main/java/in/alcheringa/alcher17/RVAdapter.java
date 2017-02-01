package in.alcheringa.alcher17;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CViewHolder> {


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
                    String[] names={"saaz","blitz","crescendo","juggernaut","juggernaut2"};
                    Intent mIntent = new Intent(itemView.getContext(), ProNight.class);
                    mIntent.putExtra("name", names[getAdapterPosition()]);
                    itemView.getContext().startActivity(mIntent);
                }
            });
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
    public void onBindViewHolder(final CViewHolder personViewHolder, int i) {
        personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }
}