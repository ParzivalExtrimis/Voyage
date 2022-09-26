package com.locale.voyage;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.locale.voyage.Models.DestinationModel;
import com.locale.voyage.Models.HotelModel;

public class MainActivity extends AppCompatActivity {

    //destination data model
    DestinationModel[] mDestinations;
    HotelModel[] mHotels;
    //hooks
    BottomNavigationView bottomNavigationView;
    NavController navController;
    NavHostFragment navHostFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup models;
        setUpHotelModel();
        setUpDestinationModel();

        //setup navigation
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        try {
            navController = navHostFragment.getNavController();
        } catch (NullPointerException e) {
            Log.d("TestActivity", "get nav controller returned null.");
        }
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                navController.navigate(item.getItemId());
                return true;
            }
        });
    }

    public  DestinationModel[] getDestinationsData() {
        return mDestinations;
    }
    public  HotelModel[] getHotels() { return mHotels; }

    private void setUpHotelModel() {

        String[] name = {
                //kerala
                "The Gateway Hotel Marina Drive",
                "Hotel Lemon Tree",
                "Grand Hotel",
                //ooty
                "Milton Abotts",
                "Hotel Darshan",
                "Hotel Lakeview",
                //mysore
                "The Grand Mercure",
                "Radisson Blu Plaze",
                "The Southstar Hotel",
                //goa
                "Radisson Park Inn",
                "Marriott Fairfield",
                "Majestic Eco"
        };
        String[] desc = {
                //kerala
                "Rejuvenate your mind and body with holistic therapies at The Gateway Hotel Marine Drive Ernakulam's on-site Abhyangam Spa.\n" +
                        "Take a refreshing swim in the crystal-clear swimming pool.\n" +
                        "Relish coastal dishes as well as Mediterranean and Asian delicacies at The Gateway Hotel Marine Drive Ernakulam's in-house The Bubble Café.",

                "Keep up with your fitness regime at the equipped gym.\n" +
                        "Enjoy serene views of backwaters from the rooms and suites.\n" +
                        "Visit the Kerala Folklore Museum located adjacent to the hotel.\n" +
                        "Savor the chilled beer and wines and play pool table at the recreation bar, Unlock Beer & Wine on-site.",

                "Experience traditional Kerala decor and cuisine in a contemporary and opulent setup, a perfect way to unwind in God’s Own Country.\n" +
                        "\n" +
                        "It features a restaurant, bar and a bakery at Grand Hotel Kochi.\n" +
                        "There is a souvenir shop within Grand Hotel Kochi.",

                //ooty
                "Surrounded by misty coolness, this 19th-Century British colonial estate bungalow featuring lush lawn and guided treks, offers a magical holiday away in the hills.\n" +
                        "\n" +
                        "Dig into delicious Tamilian, Sri Lankan, and English meals prepared on-site by the caretakers.\n" +
                        "Visit famed attractions Adams Fountain, Government Botanical Garden, Baroda Palace, Ooty Lake, and Deer Park (10-min drive). \n" +
                        "Dating back to 1865, this grand Colonial estate (restored to its former glory) offers a marvellous holiday amidst scenic vistas.\n" +
                        "Go on a walk exploring the estate and later spend your evening around the bonfire, under the stars.",

                "Overlooking the Nilgiri Hills, this lavish property offers stylish rooms, a dining venue and easy connectivity to popular areas of the city.\n" +
                        "\n" +
                        "Wake up to the stunning views of the Niligiri Hills.\n" +
                        "Enjoy the property's close proximity to Ooty Lake which is 260 m away from the property.\n" +
                        "Relish a wide range of scrumptious vegetarian delicacies at the on-site multi-cuisine vegetarian restaurant.",

                "Hotel Lakeview ooty provides a peaceful ambiance in a picturesque location backed by a luxurious stay to curate the perfect holiday.\n" +
                        "\n" +
                        "Ooty Railway Station is 2.8 km from the resort.\n" +
                        "Ooty Lake is just 1 km from the property.\n" +
                        "Enjoy horse-riding within the perimters of the massive property.",

                //mysore
                "Experience a perfect vacation at this swanky hotel offering luxurious rooms, great dining options and top-notch leisure facilities.\n" +
                        "\n" +
                        "Take a dip in the rooftop swimming pool to unwind after a hectic day.\n" +
                        "Witness amazing views of Mysore City from the hotel rooms and suites.\n" +
                        "Enjoy a hearty meal of local delicacies and global dishes, indoors or alfresco at La Uppu, the on-site restaurant.\n" +
                        "Let your kids engage in fun-filled activities at the Kids' Play Area or enjoy X-box system in the lobby.",

                "Radisson Blu Plaza Hotel Mysore welcomes you to indulge in the opulence of their hospitality set against the mesmerizing views of the Chamundi Hills as a backdrop.\n" +
                        "Right next to Mall of Mysore, this city-centre hotel offers an outdoor pool, luxury spa, gym, and a 24-hour business centre.\n" +
                        "Popular attractions in the vicinity include Sri Chamarajendra Zoological Gardens (900 m) and Mysore Palace (2.8 km).\n" +
                        "Famous shopping areas include the adjoining Mall of Mysore, Devaraja Market (3 km), and Forum Centre mall (3.7 km).\n" +
                        "Besides 24-hour room service, it offers a choice of 3 dining outlets including an elegant lounge.",

                "Experience unparalleled luxury at this award-winning property offering well-appointed rooms, incredible restaurants, a lavish spa and upscale amenities.\n" +
                        "\n" +
                        "Pamper your body with therapeutic massages at the on-site spa.\n" +
                        "Swim a few laps in the crystal-clear swimming pool.\n" +
                        "Tantalise your taste buds with Indian and international cuisines at the on-site restaurant, Zest.",

                //goa
                "Lavish rooms, multiple dining spots, an outdoor swimming pool and a host of amenities await you for a delightful stay at this luxurious property.\n" +
                        "\n" +
                        "Take a refreshing dip in the outdoor swimming pool.\n" +
                        "Start your day with a refreshing workout session at the well-equipped fitness centre.\n" +
                        "Satiate your palate with regional dishes and mouth-watering international cuisines at Chapora Restaurant.",

                "Close to Calangute Beach, this lavish property features comfortable rooms, a great dining venue, an outdoor swimming pool and a wide range of modern amenities.\n" +
                        "\n" +
                        "Take a refreshing swim in the outdoor pool, and allow your children to have fun in the kids' pool.\n" +
                        "Enjoy the property's close proximity to Calangute Beach which is 2.7 km away.\n" +
                        "Start your day with an invigorating workout session at the on-site fitness centre.\n" +
                        "Relish traditional Indian and international dishes at the on-site restaurant, Kava.",

                "We have designed it in a unique way considering in mind the destination and its ecology, climatic conditions and culture inheritance. The architecture brings out the essence of the destination to provide an intimately enriching holiday experience. From our Deluxe Wooden Cottages, Premium Rooms offering mesmerizing greenery all around , to traditional aromatic spa therapies and Quad Rooms with pool and garden view, yoga and meditation center, jogging track, badminton and volleyball court and more. With Majestic Eco comforts re-imagine the meaning and experience of a relaxing holiday. A wonderful and refreshing place to enjoy your perfect getaway with clean natural beauty & white sand beach just a few steps away. "
        };

        String[][] features = {
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },
                {
                        "Free Cancellation",
                        "Lake View"
                },
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },


                {
                        "Free Cancellation",
                        "Lake View"
                },
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },


                {
                        "Free Cancellation",
                        "Swimming pool available"
                },
                {
                        "Free Cancellation",
                        "Lake View"
                },
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },

                
                {
                        "Free Cancellation",
                        "Swimming pool available"
                },
                {
                        "Free Cancellation",
                        "Sea Facing"
                },
                {
                        "Free Cancellation",
                        "Sea Facing"
                }
        };

        int price[] = {
                3689, 2589, 6890,
                1890, 5499, 12549,
                2299, 7899, 10999,
                4999, 13789, 15960
        };

        int availability[] = {
                5, 7, 6,
                8, 4, 6,
                7, 7, 4,
                6, 8, 4
        };

        float rating[] = {
                4.2f, 3.6f, 4.8f,
                2.6f, 5.0f, 4.8f,
                3.8f, 4.0f, 3.0f,
                4.0f, 4.2f, 4.4f
        };

        int[] main_img = {
                //kerala
                R.drawable.kerala_marina,
                R.drawable.kerala_lemontree,
                R.drawable.kerala_grand,

                //ooty
                R.drawable.ooty_saffronstays,
                R.drawable.ooty_darshan,
                R.drawable.ooty_lakeview,

                //mysore
                R.drawable.mysore_mercure,
                R.drawable.mysore_radisson,
                R.drawable.mysore_southstar,

                //goa
                R.drawable.goa_parkin,
                R.drawable.goa_fairfield,
                R.drawable.goa_majestic
        };

        int[][] other_images = {
                //kerala
                {
                        R.drawable.kerala_marina2
                },
                {
                        R.drawable.kerala_lemontree2
                },
                {
                        R.drawable.kerala_grand2
                },

               //ooty
                {
                        R.drawable.ooty_saffronstays2
                },
                {
                        R.drawable.ooty_darshan2
                },
                {
                        R.drawable.ooty_lakeview2
                },

                //mysore
                {
                        R.drawable.mysore_mercure2
                },
                {
                        R.drawable.mysore_radisson2
                },
                {
                        R.drawable.mysore_southstar2
                },

                //goa
                {
                        R.drawable.goa_parkin2
                },
                {
                        R.drawable.goa_fairfield2
                },
                {
                        R.drawable.goa_majestic2
                },
        };

        //String name, String desc, int img, other img[] float rating, int availability, String[] reviews, String[] features
        //int price

        HotelModel[] hotels = {
                new HotelModel(name[0], desc[0], main_img[0], other_images[0], rating[0], availability[0], null, features[0], price[0]),
                new HotelModel(name[1], desc[1], main_img[1], other_images[1], rating[1], availability[1], null, features[1], price[1]),
                new HotelModel(name[2], desc[2], main_img[2], other_images[2], rating[2], availability[2], null, features[2], price[2]),
                new HotelModel(name[3], desc[3], main_img[3], other_images[3], rating[3], availability[3], null, features[3], price[3]),
                new HotelModel(name[4], desc[4], main_img[4], other_images[4], rating[4], availability[4], null, features[4], price[4]),
                new HotelModel(name[5], desc[5], main_img[5], other_images[5], rating[5], availability[5], null, features[5], price[5]),
                new HotelModel(name[6], desc[6], main_img[6], other_images[6], rating[6], availability[6], null, features[6], price[6]),
                new HotelModel(name[7], desc[7], main_img[7], other_images[7], rating[7], availability[7], null, features[7], price[7]),
                new HotelModel(name[8], desc[8], main_img[8], other_images[8], rating[8], availability[8], null, features[8], price[8]),
                new HotelModel(name[9], desc[9], main_img[9], other_images[9], rating[9], availability[9], null, features[9], price[9]),
                new HotelModel(name[10], desc[10], main_img[10], other_images[10], rating[10], availability[10], null, features[10], price[10]),
                new HotelModel(name[11], desc[11], main_img[11], other_images[11], rating[11], availability[11], null, features[11], price[11])
        };

        mHotels = hotels;
    };
    private void setUpDestinationModel() {
        // TODO destination model needs to be populated after hotel data is figured out

        int[] places_images = {
                R.drawable.kerala0,
                R.drawable.ooty0,
                R.drawable.mysore0,
                R.drawable.goa0,
        };
        String[] package_titles = {
                "kerala mystique",
                "Ooty retreat",
                "Magnificent Mysore",
                "Glorious Goa"
        };

        String[] places_titles = {
                "Kerala",
                "Ooty",
                "Mysore",
                "Goa"
        };
        String[] places_desc = {
                "Experience the royalty in the rich history of these soils.",
                "Find paradise on Earth in the best Ooty has to offer.",
                "From culture to cuisine, find the best of heritage in Kerala.",
                "Roaring waves and roaring crowds, find your place in Goa with us."
        };

        if(mHotels == null) {
            setUpHotelModel();
        }

        HotelModel[] keralaHotels = {
                mHotels[0],
                mHotels[1],
                mHotels[2],
                mHotels[3],
        };

        HotelModel[] ootyHotels = {
                mHotels[0],
                mHotels[1],
                mHotels[2],
                mHotels[3],
        };

        HotelModel[] mysoreHotels = {
                mHotels[4],
                mHotels[5],
                mHotels[6],
                mHotels[7],
        };

        HotelModel[] goaHotels = {
                mHotels[8],
                mHotels[9],
                mHotels[10],
                mHotels[11],
        };
        DestinationModel[] destinationModels = {
                new DestinationModel(places_titles[0], places_desc[0], places_images[0], keralaHotels, true),
                new DestinationModel(places_titles[1], places_desc[1], places_images[1], ootyHotels, true),
                new DestinationModel(places_titles[2], places_desc[2], places_images[2], mysoreHotels, true),
                new DestinationModel(places_titles[3], places_desc[3], places_images[3], goaHotels, true)
        };
        mDestinations = destinationModels;
    }
}