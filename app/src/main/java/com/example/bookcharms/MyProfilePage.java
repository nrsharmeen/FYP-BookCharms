package com.example.bookcharms;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MyProfilePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile_page);

        // Example: Populate FAQ content
        populateFAQContent();
    }

    private void populateFAQContent() {
        // Example: Populate FAQ content dynamically
        TextView question1 = findViewById(R.id.faq_question1);
        TextView answer1 = findViewById(R.id.faq_answer1);
        TextView question2 = findViewById(R.id.faq_question2);
        TextView answer2 = findViewById(R.id.faq_answer2);
        TextView question3 = findViewById(R.id.faq_question3);
        TextView answer3 = findViewById(R.id.faq_answer3);
        TextView question4 = findViewById(R.id.faq_question4);
        TextView answer4 = findViewById(R.id.faq_answer4);

        question1.setText("What is the BookCharms Mobile App?");
        answer1.setText("The BookCharms Mobile App is a convenient platform designed to enhance your book explore experience by choosing book by your own preferences and interests.");

        question2.setText("Is the BookCharms Mobile App free to use?");
        answer2.setText("Yes, the BookCharms Mobile App is completely free to download and use. There are no hidden charges or subscription fees.");

        question3.setText(" How do I sign up for an account on the BookCharms Mobile App?");
        answer3.setText("Signing up for an account on the BookCharms Mobile App is easy! Simply download the app, open it, and follow the prompts to create your account. You may be asked to provide some basic information such as your name, email address, and password.");

        question4.setText("How do I contact customer support through the BookCharms Mobile App?");
        answer4.setText("Customer support is just a tap away! You can easily reach out to our support team through this number +60165151776, where you can submit inquiries or report any issues you encounter.");
}
}
