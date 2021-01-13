package com.example.syncadapter;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

public class SyncAdapter extends AbstractThreadedSyncAdapter {
    static final String TAG = SyncAdapter.class.getName();

    /**
     * Constructor. Obtains handle to content resolver for later use.
     */
    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    /**
     * Called by the Android system in response to a request to run the sync adapter. The work
     * required to read data from the network, parse it, and store it in the content provider
     * should be done here. Extending AbstractThreadedSyncAdapter ensures that all methods within SyncAdapter
     * run on a background thread. For this reason, blocking I/O and other long-running tasks can be
     * run <em>in situ</em>, and you don't have to set up a separate thread for them.
     *
     * <p>
     * <p>This is where we actually perform any work required to perform a sync.
     * {@link AbstractThreadedSyncAdapter} guarantees that this will be called on a non-UI thread,
     * so it is safe to perform blocking I/O here.
     * <p>
     *
     * <p>The syncResult argument allows you to pass information back to the method that triggered
     * the sync.
     */
    @Override
    public void onPerformSync(Account account, Bundle extras, String authority,
                              ContentProviderClient provider, SyncResult syncResult) {

        // Your code to sync data
        // between mobile database and
        // the server goes here.

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
                Log.i(TAG, ">>>> sleeping the thread: " + (i + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }   // end for

        // write DB data sanity checks at the end.
    }

    @Override
    public void onSyncCanceled() {
        super.onSyncCanceled();
        Log.i(TAG, "");
    }

    @Override
    public void onSecurityException(Account account, Bundle extras, String authority, SyncResult syncResult) {
        super.onSecurityException(account, extras, authority, syncResult);
        Log.i(TAG,"Extras: " + extras);
    }
}
