
// EM UMA PASTA UTILS (PARA BOA ORGANIZAÇÃO)

package br.com.fecapccp.myapplication.Utils;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import br.com.fecapccp.myapplication.Activities.ConfigActivity;
//import br.com.fecapccp.myapplication.Activities.HistPage;
//import br.com.fecapccp.myapplication.Activities.Home;
import br.com.fecapccp.myapplication.R;

public class BottomNavHelper {

    public static void setupBottomNavigation(Activity activity, int selectedItemId) {
        BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(selectedItemId);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home && selectedItemId != R.id.nav_home) {
                //activity.startActivity(new Intent(activity, Home.class));
                activity.overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_info && selectedItemId != R.id.nav_info) {
                //activity.startActivity(new Intent(activity, HistPage.class));
                activity.overridePendingTransition(0, 0);
                return true;
            } else if (itemId == R.id.nav_config && selectedItemId != R.id.nav_config) {
                activity.startActivity(new Intent(activity, ConfigActivity.class));
                activity.overridePendingTransition(0, 0);
                return true;
            }

            return false;
        });
    }
}
