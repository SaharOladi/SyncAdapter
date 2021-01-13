package com.example.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AuthenticatorService extends Service {
    private StubAuthenticator authenticator;

    @Override
    public void onCreate() {
        Log.i("AuthService", "Service created");
        authenticator = new StubAuthenticator(this);
    }

    @Override
    public void onDestroy() {
        Log.i("AuthService", "Service destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return authenticator.getIBinder();
    }
}
