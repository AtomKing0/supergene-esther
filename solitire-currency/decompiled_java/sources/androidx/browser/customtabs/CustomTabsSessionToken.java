package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.a;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";

    @Nullable
    private final CustomTabsCallback mCallback;

    @Nullable
    final android.support.customtabs.a mCallbackBinder;

    @Nullable
    private final PendingIntent mSessionId;

    CustomTabsSessionToken(@Nullable android.support.customtabs.a aVar, @Nullable PendingIntent pendingIntent) {
        if (aVar == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.mCallbackBinder = aVar;
        this.mSessionId = pendingIntent;
        this.mCallback = aVar == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.extraCallback(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            @NonNull
            public Bundle extraCallbackWithResult(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onActivityResized(int i10, int i11, @NonNull Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onActivityResized(i10, i11, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(@Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int i10, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(i10, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(@NonNull String str, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int i10, @NonNull Uri uri, boolean z10, @Nullable Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(i10, uri, z10, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    @NonNull
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), null);
    }

    private IBinder getCallbackBinderAssertNotNull() {
        android.support.customtabs.a aVar = this.mCallbackBinder;
        if (aVar != null) {
            return aVar.asBinder();
        }
        throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
    }

    @Nullable
    public static CustomTabsSessionToken getSessionTokenFromIntent(@NonNull Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        return new CustomTabsSessionToken(binder != null ? a.AbstractBinderC0011a.asInterface(binder) : null, pendingIntent);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent id = customTabsSessionToken.getId();
        PendingIntent pendingIntent = this.mSessionId;
        if ((pendingIntent == null) != (id == null)) {
            return false;
        }
        return pendingIntent != null ? pendingIntent.equals(id) : getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
    }

    @Nullable
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    @Nullable
    IBinder getCallbackBinder() {
        android.support.customtabs.a aVar = this.mCallbackBinder;
        if (aVar == null) {
            return null;
        }
        return aVar.asBinder();
    }

    @Nullable
    PendingIntent getId() {
        return this.mSessionId;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasCallback() {
        return this.mCallbackBinder != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasId() {
        return this.mSessionId != null;
    }

    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        return pendingIntent != null ? pendingIntent.hashCode() : getCallbackBinderAssertNotNull().hashCode();
    }

    public boolean isAssociatedWith(@NonNull CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }

    static class MockCallback extends a.AbstractBinderC0011a {
        MockCallback() {
        }

        @Override // android.support.customtabs.a
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        @Override // android.support.customtabs.a.AbstractBinderC0011a, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.a
        public void onMessageChannelReady(Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void extraCallback(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void onNavigationEvent(int i10, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void onPostMessage(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void onActivityResized(int i10, int i11, Bundle bundle) {
        }

        @Override // android.support.customtabs.a
        public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) {
        }
    }
}
