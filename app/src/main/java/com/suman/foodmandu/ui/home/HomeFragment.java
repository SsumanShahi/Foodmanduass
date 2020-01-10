package com.suman.foodmandu.ui.home;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.suman.foodmandu.Adaptar.CatgAdaptar;
import com.suman.foodmandu.Adaptar.ChefAdaptar;
import com.suman.foodmandu.Adaptar.DetailsAdaptar;
import com.suman.foodmandu.Adaptar.GlobeAdaptar;
import com.suman.foodmandu.Adaptar.SpecialAdaptar;
import com.suman.foodmandu.R;
import com.suman.foodmandu.Url.url;
import com.suman.foodmandu.api.Specialapi;
import com.suman.foodmandu.api.Userapi;
import com.suman.foodmandu.model.Catg;
import com.suman.foodmandu.model.Chef;
import com.suman.foodmandu.model.Details;
import com.suman.foodmandu.model.Globe;
import com.suman.foodmandu.model.Special;
import com.suman.foodmandu.strictmode.StrictModeClass;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    RecyclerView recycler2, recyclerView2, recyclerView3, recycler4, recycle1;
    ImageView card1;

    //Adaptars
    CatgAdaptar catgAdaptar;
    DetailsAdaptar detailsAdaptar;
    ChefAdaptar chefAdaptar;
    SpecialAdaptar specialAdaptar;
    GlobeAdaptar globeAdaptar;

    //List of array
    List<Catg> catgs;
    List<Chef> chefList;
    List<Details> detailsList;
    List<Special> specials;
    List<Globe> globes;
    private int[] mImages = new int[]{
            R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4
    };

    private String[] mImageTitle = new String[]{
            "Liquor", "Momo", "Sauce", "juice"
    };


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        CarouselView carouselView;

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        recycle1 = root.findViewById(R.id.recycle1);
        recycler2 = root.findViewById(R.id.recycler2);
        recyclerView2 = root.findViewById(R.id.recyclerView2);
        recyclerView3 = root.findViewById(R.id.recyclerView3);
        recycler4 = root.findViewById(R.id.recycler4);
        card1 = root.findViewById(R.id.card1);

        carouselView = root.findViewById(R.id.cara1);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override

            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getContext(), mImageTitle[position], Toast.LENGTH_SHORT).show();
            }
        });

        //Categories

        catgs = new ArrayList<>();
        catgs.add(new Catg(R.drawable.res, "Restaurant"));
        catgs.add(new Catg(R.drawable.liquor, "Liquors"));
        catgs.add(new Catg(R.drawable.cup, "Bakeries"));
        catgs.add(new Catg(R.drawable.ref, "Refreshment"));
        catgs.add(new Catg(R.drawable.o, "Organic"));
        catgAdaptar = new CatgAdaptar(getContext(), catgs);
        recycle1.setHasFixedSize(true);
        recycle1.setAdapter(catgAdaptar);
        recycle1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));





        //detail
        detailsList = new ArrayList<>();

//        detailsList.add(new Details(R.drawable.ban1, "Breakfast", "Nakhu"));
//
//        detailsList.add(new Details(R.drawable.ban1, "Breakfast", "Nakhu"));
//
//        detailsList.add(new Details(R.drawable.ban1, "Breakfast", "Nakhu"));
//
//        detailsList.add(new Details(R.drawable.ban1, "Breakfast", "Nakhu"));
//
//        detailsList.add(new Details(R.drawable.ban1, "Breakfast", "Nakhu"));

        Userapi userapi = url.getInstance().create(Userapi.class);

        Call<List<Details>> listCall = userapi.getsuper7();
        Call<Details> listCall1 = userapi.getsuperDetails(url.token);

        listCall1.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getContext(), "Code " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                String imgPath = url.imagePath +  response.body().getImage();
                Picasso.get().load(imgPath).into(card1);
//                StrictModeClass.StrictMode();
//                try{
//
//
//                    URL url = new URL(imgPath);
//                    card1.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//
//                }  catch (IOException e) {
//                    e.printStackTrace();
//                }
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {
                Log.d("the error in api is ",t.getLocalizedMessage());
                Toast.makeText(getContext(), "Error " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listCall.enqueue(new Callback<List<Details>>() {
            @Override
            public void onResponse(Call<List<Details>> call, Response<List<Details>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code Error" + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }



                List<Details> detailsList = response.body();
                detailsAdaptar = new DetailsAdaptar(getContext(), detailsList);
                recycler2.setAdapter(detailsAdaptar);
                recycler2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                recycler2.setHasFixedSize(true);


            }

            @Override
            public void onFailure(Call<List<Details>> call, Throwable t) {
                Log.d("Mero Msg", "onFailure:" + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();

            }
        });

        //Chef
        chefList = new ArrayList<>();
        chefList.add(new Chef(R.drawable.ad1));
        chefList.add(new Chef(R.drawable.backcover));
        chefList.add(new Chef(R.drawable.ban));
        chefList.add(new Chef(R.drawable.ban1));
        chefList.add(new Chef(R.drawable.food1));
        chefList.add(new Chef(R.drawable.food2));
        chefList.add(new Chef(R.drawable.food3));
        chefAdaptar = new ChefAdaptar(getContext(), chefList);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setAdapter(chefAdaptar);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        //SpecialOffer
        specials = new ArrayList<>();
//        specials.add(new Special(R.drawable.offer1, "Genesis Cafe"));
//        specials.add(new Special(R.drawable.offer2, "Roadcross Biryani Kebab"));
//        specials.add(new Special(R.drawable.offer3, "Freddo Cafe"));
//        specials.add(new Special(R.drawable.offer4, "Anatolia (Halal)"));
//        specials.add(new Special(R.drawable.offer5, "Travis Restaurant"));
//        specials.add(new Special(R.drawable.offer6, "Hotel Tranquil"));
//        specials.add(new Special(R.drawable.offer7, "Vesper Fine Wine"));
//        specials.add(new Special(R.drawable.offer8, "Chef's Burger"));

        Specialapi specialapi = url.getInstance().create(Specialapi.class);
        Call<List<Special>> listCall2 = specialapi.getspecial();
        Call<Special> listCall3 = specialapi.getspecailimage(url.token);
        listCall2.enqueue(new Callback<List<Special>>() {
            @Override
            public void onResponse(Call<List<Special>> call, Response<List<Special>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Code Error" + response.code(), Toast.LENGTH_LONG).show();
                    return;

            }
                List<Special> specials = response.body();
                specialAdaptar = new SpecialAdaptar(getContext(), specials);
                recyclerView3.setHasFixedSize(true);
                recyclerView3.setAdapter(specialAdaptar);
                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        }

            @Override
            public void onFailure(Call<List<Special>> call, Throwable t) {
                Log.d("Mero Msg", "onFailure:" + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }

            });




        //Globe
        globes = new ArrayList<>();
        globes.add(new Globe(R.drawable.globe1, "Bun Thit Nuong", "Vietnamese", "Saigon Pho"));
        globes.add(new Globe(R.drawable.globe2, "Chu Chi Pla", "Thai", "Thai Ghar"));
        globes.add(new Globe(R.drawable.globe4, "Korean Kimbap", "Korean", "Korean Kimbab House"));
        globes.add(new Globe(R.drawable.globe3, "Lasagne al Ragu", "Italian", "Piano B"));
        globes.add(new Globe(R.drawable.globe5, "Zakuski", "Russian", "Wunjala Moskva"));
        globeAdaptar = new GlobeAdaptar(getContext(), globes);
        recycler4.setAdapter(globeAdaptar);
        recycler4.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recycler4.setHasFixedSize(true);


        return root;
    }
}