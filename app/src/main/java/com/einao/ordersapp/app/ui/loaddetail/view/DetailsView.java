package com.einao.ordersapp.app.ui.loaddetail.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.einao.ordersapp.R;
import com.einao.ordersapp.app.ui.viewmodel.LoadViewModel;
import com.einao.ordersapp.domain.providers.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsView extends LinearLayout {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.map)
    ImageView map;

    @BindView(R.id.destination)
    TextView destination;

    @BindView(R.id.price)
    TextView price;

    @BindView(R.id.destinationDate)
    TextView destinationDate;

    @BindView(R.id.originDate)
    TextView originDate;

    @BindView(R.id.status)
    TextView status;

    @BindView(R.id.weight)
    TextView weight;

    @BindView(R.id.package_type)
    TextView packageType;

    public DetailsView(Context context) {
        super(context);
        setUp();
    }

    public DetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setUp();
    }

    public DetailsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setUp();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DetailsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setUp();
    }

    private void setUp() {
        LayoutInflater.from(getContext()).inflate(R.layout.details_view, this);
        ButterKnife.bind(this);
    }

    public void setInformation(LoadViewModel loadViewModel, ImageLoader<ImageView> imageLoader) {
        destination.setText(loadViewModel.getDestinationFullAddress());
        name.setText(loadViewModel.getName());
        imageLoader.load(map,
                "https://maps.googleapis.com/maps/api/staticmap?center=40.123,-3.123&zoom=8&size=1200x1200&markers=40.123,-3.123");
        packageType.setText(loadViewModel.getPackageType());
        originDate.setText(loadViewModel.getOriginDate());
        destinationDate.setText(loadViewModel.getDestinationDate());
        price.setText(loadViewModel.getPrice());
        status.setText(String.valueOf(loadViewModel.getStatus()));
        weight.setText(String.valueOf(loadViewModel.getWeight()));
    }
}
