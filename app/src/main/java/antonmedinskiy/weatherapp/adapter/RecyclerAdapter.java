package antonmedinskiy.weatherapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import antonmedinskiy.weatherapp.R;
import antonmedinskiy.weatherapp.model.db.CityEntity;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CityHolder> {

    private List<CityEntity> mCities;
    private LayoutInflater mInflater;

    public RecyclerAdapter(List<CityEntity> mCities, LayoutInflater mInflater) {
        this.mCities = mCities;
        this.mInflater = mInflater;
    }


    @Override
    public CityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent,false);
        return new CityHolder(view);
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        CityEntity cityEntity = mCities.get(position);
        holder.bindCity(cityEntity);
    }

    public void setCities(List<CityEntity> cities){
        this.mCities = cities;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    class CityHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mCityName;
        public CityHolder(View itemView) {
            super(itemView);
            mCityName = (TextView)itemView.findViewById(R.id.list_city_name);
            itemView.setOnClickListener(this);
        }

        public void bindCity(CityEntity cityEntity){
            mCityName.setText(cityEntity.getWde().getName());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
