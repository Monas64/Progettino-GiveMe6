package com.example.giveme6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

public class List extends AppCompatActivity implements LocationListener {

    private LocationManager locationManager;

    TextView lenght1, lenght2, lenght3, lenght4, lenght5;

    double barCorniLat = 44.64769755183119;
    double barCorniLon = 10.889874096682295;

    double barSelmiLat = 44.647271339434695;
    double barSelmiLon = 10.889040684819319;

    double macchinetteMainLat = 44.64792720174715;
    double macchinetteMainLon = 10.890084074371222;

    double macchinetteUpLat = 44.64790760013106;
    double macchinetteUPLon = 10.890246631674916;

    double conadLat = 44.64652939889768;
    double conadLon = 10.88678927243794;

    //double arr[]= {5,3,1,10,6};
    private double[] arrNum = new double[5];
    private String[] arrNom = {"BarCorni", "BarSelmi", "Macchinette Piano Terra", "Macchinette piani superiori", "Conad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lenght1= findViewById(R.id.lenght1);
        lenght2= findViewById(R.id.lenght2);
        lenght3= findViewById(R.id.lenght3);
        lenght4= findViewById(R.id.lenght4);
        lenght5= findViewById(R.id.lenght5);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3000, 0, this);
        nearest();
        /*
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]+"");
        }
         */

    }

    private double calculate(double zoneLat, double zoneLon, double positionLat, double positionLon) {
        double dist= Math.sqrt(Math.pow((zoneLat-positionLat), 2) + Math.pow((zoneLon-positionLon), 2));
        return dist;
    }
    private void nearest() {
        for(int i=0; i<arrNum.length-1; i++) {
            for(int k=i+1; k<arrNum.length; k++) {
                if (arrNum[i] > arrNum[k]) {
                    double tempNum = arrNum[i];
                    String tempNom = arrNom[i];
                    arrNum[i] = arrNum[k];
                    arrNom[i] = arrNom[k];
                    arrNum[k] = tempNum;
                    arrNom[k] = tempNom;
                }
            }
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        arrNum[0]=calculate(barCorniLat, barCorniLon, location.getLatitude(), location.getLongitude());
        arrNum[1]=calculate(barSelmiLat, barSelmiLon, location.getLatitude(), location.getLongitude());
        arrNum[2]=calculate(macchinetteMainLat, macchinetteMainLon, location.getLatitude(), location.getLongitude());
        arrNum[3]=calculate(macchinetteUpLat, macchinetteUPLon, location.getLatitude(), location.getLongitude());
        arrNum[4]=calculate(conadLat, conadLon, location.getLatitude(), location.getLongitude());

        nearest();

        lenght1.setText(arrNom[0]);
        lenght2.setText(arrNom[1]);
        lenght3.setText(arrNom[2]);
        lenght4.setText(arrNom[3]);
        lenght5.setText(arrNom[4]);
    }
    /*
    /**
     * prendo le posizioni
     * @param barCorniLat
     * @param barCorniLon
     * @param barSelmiLat
     * @param barSelmiLon
     * @param macchinetteMainLat
     * @param macchinetteMainLon
     * @param macchinetteUpLat
     * @param macchinetteUPLon
     * @param conadLat
     * @param conadLon

    public List(double barCorniLat, double barCorniLon, double barSelmiLat, double barSelmiLon, double macchinetteMainLat, double macchinetteMainLon, double macchinetteUpLat, double macchinetteUPLon, double conadLat, double conadLon) {
        this.barCorniLat = barCorniLat;
        this.barCorniLon = barCorniLon;
        this.barSelmiLat = barSelmiLat;
        this.barSelmiLon = barSelmiLon;
        this.macchinetteMainLat = macchinetteMainLat;
        this.macchinetteMainLon = macchinetteMainLon;
        this.macchinetteUpLat = macchinetteUpLat;
        this.macchinetteUPLon = macchinetteUPLon;
        this.conadLat = conadLat;
        this.conadLon = conadLon;
    }
     */

    /*
    public double getBarCorniLat() {
        return barCorniLat;
    }
     */
}