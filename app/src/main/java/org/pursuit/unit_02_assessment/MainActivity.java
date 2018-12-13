package org.pursuit.unit_02_assessment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private EditText inputEditText;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "mail.pursuit.org");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Email from Pursuit");
                intent.putExtra(Intent.EXTRA_TEXT, "This is my text.");
                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        RandomGame randomGame = new RandomGame();
        int randomNumber = Integer.parseInt((TextView)findViewById(R.id.number_edittext){
            submitButton.setOnClickListener(setIntent(new View.OnClickListener();
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("name", "result");
            startActivity(intent);
            EditText editText= (EditText) findViewById(R.id.number_edittext);
            if (savedInstanceState != null){
                editText.setText(savedInstanceState.getString("result"));
                        }
                        }
                        ;

                        // TODO: In the onClick method of the listener, use methods from the RandomGame class to check if the number in the EditText matches the number in the field above. If they match, send the winning phrase to the next activity called "SecondActivity", with an explicit intent, and an intent extra with the key "result", and the winning phrase as the value. If not, change the TextView "info_textview" text to display the losing phrase.
                        // TODO: In the activity "SecondActivity", get the intent extra using the key "result", and use the String value it returns to set the value of the TextView "second_textView".
                        // TODO: Use the "onSavedInstanceState" method to save the values of each of the TextViews/EditTexts of both activities prior to orientation change, and set their values in the onCreate method.
                    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_toast) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Hello, Pursuit!",
                    Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_phone:
                Uri phoneUri = Uri.parse("tel:2125551212");
                Intent intent = new Intent(Intent.ACTION_DIAL, phoneUri);
                startActivity(intent);
                break;
            case R.id.nav_sms:
                Uri smsUri = Uri.parse("Welcome to Pursuit!");
                Intent intent2 = new Intent(Intent.ACTION_SENDTO, smsUri);
                startActivity(intent2);
                break;
            case R.id.nav_map_location:
                Uri mapLocUri = Uri.parse("View Coordinates");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, mapLocUri);
                startActivity(intent3);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
