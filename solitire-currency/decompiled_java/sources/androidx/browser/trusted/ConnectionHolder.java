package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.trusted.b;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ConnectionHolder implements ServiceConnection {
    private static final int STATE_AWAITING_CONNECTION = 0;
    private static final int STATE_CANCELLED = 3;
    private static final int STATE_CONNECTED = 1;
    private static final int STATE_DISCONNECTED = 2;

    @Nullable
    private Exception mCancellationException;

    @NonNull
    private final Runnable mCloseRunnable;

    @NonNull
    private List<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> mCompleters;

    @Nullable
    private TrustedWebActivityServiceConnection mService;
    private int mState;

    @NonNull
    private final WrapperFactory mWrapperFactory;

    static class WrapperFactory {
        WrapperFactory() {
        }

        @NonNull
        TrustedWebActivityServiceConnection create(ComponentName componentName, IBinder iBinder) {
            return new TrustedWebActivityServiceConnection(b.a.asInterface(iBinder), componentName);
        }
    }

    @MainThread
    ConnectionHolder(@NonNull Runnable runnable) {
        this(runnable, new WrapperFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getServiceWrapper$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        int i10 = this.mState;
        if (i10 == 0) {
            this.mCompleters.add(completer);
        } else {
            if (i10 != 1) {
                if (i10 == 2) {
                    throw new IllegalStateException("Service has been disconnected.");
                }
                if (i10 != 3) {
                    throw new IllegalStateException("Connection state is invalid");
                }
                throw this.mCancellationException;
            }
            TrustedWebActivityServiceConnection trustedWebActivityServiceConnection = this.mService;
            if (trustedWebActivityServiceConnection == null) {
                throw new IllegalStateException("ConnectionHolder state is incorrect.");
            }
            completer.set(trustedWebActivityServiceConnection);
        }
        return "ConnectionHolder, state = " + this.mState;
    }

    @MainThread
    public void cancel(@NonNull Exception exc) {
        Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = this.mCompleters.iterator();
        while (it.hasNext()) {
            it.next().setException(exc);
        }
        this.mCompleters.clear();
        this.mCloseRunnable.run();
        this.mState = 3;
        this.mCancellationException = exc;
    }

    @NonNull
    @MainThread
    public com.google.common.util.concurrent.m<TrustedWebActivityServiceConnection> getServiceWrapper() {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.browser.trusted.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f741a.lambda$getServiceWrapper$0(completer);
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.mService = this.mWrapperFactory.create(componentName, iBinder);
        Iterator<CallbackToFutureAdapter.Completer<TrustedWebActivityServiceConnection>> it = this.mCompleters.iterator();
        while (it.hasNext()) {
            it.next().set(this.mService);
        }
        this.mCompleters.clear();
        this.mState = 1;
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
        this.mCloseRunnable.run();
        this.mState = 2;
    }

    @MainThread
    ConnectionHolder(@NonNull Runnable runnable, @NonNull WrapperFactory wrapperFactory) {
        this.mState = 0;
        this.mCompleters = new ArrayList();
        this.mCloseRunnable = runnable;
        this.mWrapperFactory = wrapperFactory;
    }
}
