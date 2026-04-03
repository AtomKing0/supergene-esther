package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: ICustomTabsCallback.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface a extends IInterface {
    public static final String F7 = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void d(Parcel parcel, T t10, int i10) {
            if (t10 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t10.writeToParcel(parcel, i10);
            }
        }
    }

    void extraCallback(String str, Bundle bundle) throws RemoteException;

    Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException;

    void onActivityResized(int i10, int i11, Bundle bundle) throws RemoteException;

    void onMessageChannelReady(Bundle bundle) throws RemoteException;

    void onNavigationEvent(int i10, Bundle bundle) throws RemoteException;

    void onPostMessage(String str, Bundle bundle) throws RemoteException;

    void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) throws RemoteException;

    /* JADX INFO: renamed from: android.support.customtabs.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ICustomTabsCallback.java */
    public static abstract class AbstractBinderC0011a extends Binder implements a {
        static final int TRANSACTION_extraCallback = 3;
        static final int TRANSACTION_extraCallbackWithResult = 7;
        static final int TRANSACTION_onActivityResized = 8;
        static final int TRANSACTION_onMessageChannelReady = 4;
        static final int TRANSACTION_onNavigationEvent = 2;
        static final int TRANSACTION_onPostMessage = 5;
        static final int TRANSACTION_onRelationshipValidationResult = 6;

        /* JADX INFO: renamed from: android.support.customtabs.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ICustomTabsCallback.java */
        private static class C0012a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f586a;

            C0012a(IBinder iBinder) {
                this.f586a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f586a;
            }

            @Override // android.support.customtabs.a
            public void extraCallback(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(3, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return (Bundle) b.c(parcelObtain2, Bundle.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public void onActivityResized(int i10, int i11, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeInt(i10);
                    parcelObtain.writeInt(i11);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(8, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public void onMessageChannelReady(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public void onNavigationEvent(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeInt(i10);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(2, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public void onPostMessage(String str, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeString(str);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // android.support.customtabs.a
            public void onRelationshipValidationResult(int i10, Uri uri, boolean z10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.F7);
                    parcelObtain.writeInt(i10);
                    b.d(parcelObtain, uri, 0);
                    parcelObtain.writeInt(z10 ? 1 : 0);
                    b.d(parcelObtain, bundle, 0);
                    this.f586a.transact(6, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0011a() {
            attachInterface(this, a.F7);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.F7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0012a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = a.F7;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i10) {
                case 2:
                    onNavigationEvent(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 3:
                    extraCallback(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 4:
                    onMessageChannelReady((Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    onPostMessage(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    onRelationshipValidationResult(parcel.readInt(), (Uri) b.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                case 7:
                    Bundle bundleExtraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.d(parcel2, bundleExtraCallbackWithResult, 1);
                    return true;
                case 8:
                    onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
