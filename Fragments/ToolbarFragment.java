package Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
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
import ProfilePages.LogIn;
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
import ProfilePages.ProfilePage;
import Vendors.Vendors;

/** creates the toolbar on every page
 * A simple {@link Fragment} subclass.
 * Use the {@link ToolbarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolbarFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ToolbarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ToolbarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ToolbarFragment newInstance(String param1, String param2) {
        ToolbarFragment fragment = new ToolbarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_toolbar, container, false);
    }

    /** list for the homepage spinner objects */
    private ArrayList<HomePageSpinner> spinnerList = new ArrayList<>();
    private HomePageSpinnerAdapter spinnerAdapter;
    Spinner spinner;

    /**
     *
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();

        spinner = view.findViewById(R.id.homePageSpinner);
        spinnerAdapter =  new HomePageSpinnerAdapter(getContext(),  spinnerList);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(spin);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setOnClickListener(tooling);

        Button button = view.findViewById(R.id.logbutton);

        try {
            if (SalsaDataBase.getloggedin().getName() == null) {}
            else {
                button.setText("You are logged in " + SalsaDataBase.getloggedin().getName());
                button.setTextSize(10);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        profileClick();
                    }
                });

            }

        } catch (NullPointerException e) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogInClick();
                }
            });

        }



    }

    /**
     * spinner set up
     */
    AdapterView.OnItemSelectedListener spin = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       //     HomePageSpinner clickedItem = (HomePageSpinner) parent.getItemAtPosition(position);
            if(position == 0)   {}
            if (position ==1) {
                Intent open = new Intent(getContext(), Instructors.class);
                startActivity(open);
            }
            else if (position ==2) {
                Intent open = new Intent(getContext(), Competitions.class);
                startActivity(open);
            }
            else if (position ==3) {
                Intent open = new Intent(getContext(), ConcertsDeejays.class);
                startActivity(open);
            }
            else if (position ==4) {
                Intent open = new Intent(getContext(), ContactUs.class);
                startActivity(open);
            }
            else if (position ==5) {
                Intent open = new Intent(getContext(), HomePage.class);
                startActivity(open);
            }
            else if (position ==6) {
                Intent open = new Intent(getContext(), Hotel.class);
                startActivity(open);
            }
            else if (position ==7) {
                Intent open = new Intent(getContext(), News.class);
                startActivity(open);
            }
            else if (position ==8) {
                Intent open = new Intent(getContext(), Tickets.class);
                startActivity(open);
            }
            else if (position ==9) {
                Intent open = new Intent(getContext(), Vendors.class);
                startActivity(open);
            }
            else if (position == 10) {
                Intent open = new Intent(getContext(), Performances.class);
                startActivity(open);
            }
            else if (position == 11) {
                Intent open = new Intent(getContext(), Workshops.class);
                startActivity(open);
            }
            else if (position ==12) {
                Intent open = new Intent(getContext(), Allevents.class);
                startActivity(open);
            }
            else if (position == 13) {
                Intent open = new Intent(getContext(), VideoGallery.class);
                startActivity(open);
            }
            else if (position == 14) {
                SalsaDataBase.loggedOut();
                Intent open = new Intent(getContext(), HomePage.class);
                startActivity(open);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    /** initialize objects */
    private void initialize () {

        spinnerList.add(new HomePageSpinner("",R.drawable.__menu_logo_ico));
        spinnerList.add(new HomePageSpinner("Instructors", R.drawable.__bersycortez));
        spinnerList.add(new HomePageSpinner("Competition", R.drawable.__competition));
        spinnerList.add(new HomePageSpinner("Concerts", R.drawable.__dj_nico));
        spinnerList.add(new HomePageSpinner("Contact Us", R.drawable.baseline_local_phone_24));
        spinnerList.add(new HomePageSpinner("Home Page", R.drawable.a_edmundo));
        spinnerList.add(new HomePageSpinner("Hotel", R.drawable.__marriot));
        spinnerList.add(new HomePageSpinner("News", R.drawable.__magazine));
        spinnerList.add(new HomePageSpinner("Tickets", R.drawable.__vicman));
        spinnerList.add(new HomePageSpinner("Vendors/Sponsors", R.drawable.__vendor22));
        spinnerList.add(new HomePageSpinner("Performances", R.drawable.a__salsaperformance));
        spinnerList.add(new HomePageSpinner("Workshops", R.drawable.a_deny));
        spinnerList.add(new HomePageSpinner("All Events", R.drawable.__titos));
        spinnerList.add(new HomePageSpinner("Photos/Videos", R.drawable.__pparty));
        spinnerList.add(new HomePageSpinner("Log Out", 0));

    }

    /**
     * go to log in
     */
    public void LogInClick() {
        Intent log = new Intent(getActivity(), LogIn.class);
        startActivity(log);
    }

    /**
     * go to profile page
     */
    public void profileClick() {
        Intent profile = new Intent(getActivity(), ProfilePage.class);
        profile.putExtra("username", SalsaDataBase.getloggedin().getUsername());
        profile.putExtra("password", SalsaDataBase.getloggedin().getPassword());
        startActivity(profile);
    }

    /**
     * go to home page
     */
    View.OnClickListener tooling = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent home = new Intent(getActivity(), HomePage.class);
            startActivity(home);
        }
    };

}
