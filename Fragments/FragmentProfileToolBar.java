package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.zybooks.testworldsalsa.Allevents;
import com.zybooks.testworldsalsa.ConcertsDeejays;
import com.zybooks.testworldsalsa.ContactUs;
import com.zybooks.testworldsalsa.HomePage;
import com.zybooks.testworldsalsa.HomePageSpinner;
import com.zybooks.testworldsalsa.HomePageSpinnerAdapter;
import com.zybooks.testworldsalsa.Hotel;
import com.zybooks.testworldsalsa.News;
import com.zybooks.testworldsalsa.Performances;
import com.zybooks.testworldsalsa.R;
import com.zybooks.testworldsalsa.SalsaDataBase;
import com.zybooks.testworldsalsa.Tickets;
import com.zybooks.testworldsalsa.VideoGallery;
import com.zybooks.testworldsalsa.Workshops;

import java.util.ArrayList;

import Competition.Competitions;
import Instructors.Instructors;
import ProfilePages.LogIn;
import ProfilePages.ProfileInformationPage;
import ProfilePages.ProfileTicketPage;
import ProfilePages.ProfileWorkshopPage;
import Vendors.Vendors;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentProfileToolBar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentProfileToolBar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentProfileToolBar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentProfileToolBar.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentProfileToolBar newInstance(String param1, String param2) {
        FragmentProfileToolBar fragment = new FragmentProfileToolBar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_tool_bar, container, false);
    }


    private ArrayList<HomePageSpinner> spinnerList = new ArrayList<>();
    private HomePageSpinnerAdapter adapter;
    Spinner spinner;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();

        Button button1 = view.findViewById(R.id.profilebutton);
        Button button2 = view.findViewById(R.id.profileTickets);
        Button button3 = view.findViewById(R.id.profileWorkshops);
        Button button4 = view.findViewById(R.id.profileWorkshops2);
        Button button5 = view.findViewById(R.id.homeClick);

        button1.setOnClickListener(b1);
        button2.setOnClickListener(b2);
        button3.setOnClickListener(b3);
        button4.setOnClickListener(b4);
        button5.setOnClickListener(b5);

        spinner = view.findViewById(R.id.homePageSpinner);
        adapter = new HomePageSpinnerAdapter(getContext(), spinnerList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(selection);

    }

    View.OnClickListener b1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profileClick();
        }
    };

    View.OnClickListener b2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profileTickets();
        }
    };

    View.OnClickListener b3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profileWorkshopsClick();
        }
    };

    View.OnClickListener b4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           loginClick();
        }
    };

    View.OnClickListener b5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HomePageClick();
        }
    };

    AdapterView.OnItemSelectedListener selection = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0)   {}
            if (position ==1) {
                Intent open = new Intent(getActivity(), Instructors.class);
                startActivity(open);
            }
            else if (position ==2) {
                Intent open = new Intent(getActivity(), Competitions.class);
                startActivity(open);
            }
            else if (position ==3) {
                Intent open = new Intent(getActivity(), ConcertsDeejays.class);
                startActivity(open);
            }
            else if (position ==4) {
                Intent open = new Intent(getActivity(), ContactUs.class);
                startActivity(open);
            }
            else if (position ==5) {
                Intent open = new Intent(getActivity(), HomePage.class);
                startActivity(open);
            }
            else if (position ==6) {
                Intent open = new Intent(getActivity(), Hotel.class);
                startActivity(open);
            }
            else if (position ==7) {
                Intent open = new Intent(getActivity(), News.class);
                startActivity(open);
            }
            else if (position ==8) {
                Intent open = new Intent(getActivity(), Tickets.class);
                startActivity(open);
            }
            else if (position ==9) {
                Intent open = new Intent(getActivity(), Vendors.class);
                startActivity(open);
            }
            else if (position == 10) {
                Intent open = new Intent(getActivity(), Performances.class);
                startActivity(open);
            }
            else if (position == 11) {
                Intent open = new Intent(getActivity(), Workshops.class);
                startActivity(open);
            }
            else if (position ==12) {
                Intent open = new Intent(getActivity(), Allevents.class);
                startActivity(open);
            }
            else if (position == 13) {
                Intent open = new Intent(getActivity(), VideoGallery.class);
                startActivity(open);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    private void initialize () {

        spinnerList.add(new HomePageSpinner("",R.drawable.__blackdancer));
        spinnerList.add(new HomePageSpinner("Instructors", R.drawable.__bersycortez));
        spinnerList.add(new HomePageSpinner("Competition", R.drawable.__competition));
        spinnerList.add(new HomePageSpinner("Concerts", R.drawable.__dj_nico));
        spinnerList.add(new HomePageSpinner("Contact Us", R.drawable.baseline_local_phone_24));
        spinnerList.add(new HomePageSpinner("Home Page", R.drawable.a_edmundo));
        spinnerList.add(new HomePageSpinner("Hotel", R.drawable.__marriot));
        spinnerList.add(new HomePageSpinner("News", R.drawable.__magazine));
        spinnerList.add(new HomePageSpinner("Tickets", R.drawable.__victor_manuelle));
        spinnerList.add(new HomePageSpinner("Vendors/Sponsors", R.drawable.__vendor22));
        spinnerList.add(new HomePageSpinner("Performances", R.drawable.a__salsaperformance));
        spinnerList.add(new HomePageSpinner("Workshops", R.drawable.a_deny));
        spinnerList.add(new HomePageSpinner("All Events", R.drawable.__titos));
        spinnerList.add(new HomePageSpinner("Photos/Videos", R.drawable.__pparty));

    }

    /**
     * go to profile page
     *
     */
    public void profileClick() {

        Intent info = new Intent(getContext(), ProfileInformationPage.class);
      //  info.putExtra("username", username2);
    //    info.putExtra("password", password2);
        startActivity(info);
    }

    public void profileTickets() {
        Intent info = new Intent(getActivity(), ProfileTicketPage.class);
        startActivity(info);
    }

    public void profileWorkshopsClick() {
        Intent info = new Intent(getActivity(), ProfileWorkshopPage.class);
        startActivity(info);
    }

    public void loginClick() {
        SalsaDataBase.loggedOut();
        Intent leave = new Intent(getActivity(), LogIn.class);
        startActivity(leave);
    }


    /**
     * go to home page
     *
     */
    public void HomePageClick() {
        Intent go = new Intent(getActivity(), HomePage.class);
        startActivity(go);
    }

}