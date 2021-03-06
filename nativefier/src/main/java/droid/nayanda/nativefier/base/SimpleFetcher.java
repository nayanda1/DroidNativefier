package droid.nayanda.nativefier.base;

import android.content.Context;
import android.support.annotation.NonNull;

import droid.nayanda.nativefier.FetcherTaskScheduler;
import droid.nayanda.nativefier.FetcherTaskScheduler.FetcherTask;

/**
 * Created by nayanda on 18/03/18.
 */

public abstract class SimpleFetcher<TValue> implements Fetcher<TValue> {

    private Context context;

    public SimpleFetcher(Context context) {
        this.context = context;
    }

    @Override
    public void asyncFetch(@NonNull final String key, @NonNull final Finisher<TValue> finisher) {
        FetcherTask<TValue> task = new FetcherTask<>(SimpleFetcher.this::fetch, finisher);
        FetcherTaskScheduler.execute(task, key, context);
    }
}
