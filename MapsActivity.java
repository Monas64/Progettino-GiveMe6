package com.example.giveme6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.giveme6.databinding.ActivityMapsBinding;

import javax.sql.RowSetMetaData;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        //if gps isn't on on create = set a standard position
        /*
        if() {
            LatLng posBase = new LatLng(44.64755327355206, 10.889357985359663);
        }
         */
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Settings
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);


        // Add a marker in markets and move the camera
        LatLng barCorni = new LatLng(44.64769755183119, 10.889874096682295);
        mMap.addMarker(new MarkerOptions().position(barCorni).title("Bar del Corni ★★★★★"));
        LatLng barSelmi = new LatLng(44.647271339434695, 10.889040684819319);
        mMap.addMarker(new MarkerOptions().position(barSelmi).title("Bar del Selmi ★★★"));
        LatLng macchinetteMain = new LatLng(44.64792720174715, 10.890084074371222);
        mMap.addMarker(new MarkerOptions().position(macchinetteMain).title("Macchinette piano terra ★★"));
        LatLng macchinetteUp = new LatLng(44.64790760013106, 10.890246631674916);
        mMap.addMarker(new MarkerOptions().position(macchinetteUp).title("Macchinette piani superiori ★"));
        LatLng conad = new LatLng(44.64652939889768, 10.88678927243794);
        mMap.addMarker(new MarkerOptions().position(conad).title("Conad \n★★★★"));
        //List l= new List(barCorni.latitude, barCorni.longitude, barSelmi.latitude, barSelmi.longitude, macchinetteMain.latitude, macchinetteMain.longitude, macchinetteUp.latitude, macchinetteUp.longitude, conad.latitude, conad.longitude);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()),13));
    }
}