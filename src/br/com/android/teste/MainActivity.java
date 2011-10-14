package br.com.android.teste;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
   
   private PlayerDatabase pd;
   
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      
      pd = new PlayerDatabase(this);
      
      try {
         
         Player p = pd.select(11);
         
         TextView tx = (TextView) findViewById(R.id.text);
         tx.setText(p.toString());
         
         /*Make your tests! =)*/
         
         
      } finally {
         pd.close(); 
      }
   }



   
	   
}