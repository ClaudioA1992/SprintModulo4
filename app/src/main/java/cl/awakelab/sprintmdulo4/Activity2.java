package cl.awakelab.sprintmdulo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import cl.awakelab.sprintmdulo4.databinding.Activity2Binding;

public class Activity2 extends AppCompatActivity {

    Activity2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.textLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/spacex/"));
                startActivity(intent);
            }
        });

        binding.imageLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/spacex/"));
                startActivity(intent);
            }
        });

        binding.textTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/elonmusk"));
                startActivity(intentTwitter);
            }
        });

        binding.imageTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTwitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/elonmusk"));
                startActivity(intentTwitter);
            }
        });

        binding.emailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mensaje = binding.mensaje.getText().toString();
                sendEmail(mensaje);
            }
        });

        binding.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+18006138840"));//change the number
                startActivity(callIntent);
            }
        });

        binding.phoneIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:+18006138840"));//change the number
                startActivity(callIntent);
            }
        });

    }

    protected void sendEmail(String message) {
        String[] TO = {"elonmusk@live.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:elonmusk@live.com"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
        emailIntent.putExtra(Intent.EXTRA_TEXT, message);

        startActivity(Intent.createChooser(emailIntent, "Enviando mail..."));
        finish();

    };

}
