package d4;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: IGetInstallReferrerService.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: d4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IGetInstallReferrerService.java */
    public static abstract class AbstractBinderC0538a extends Binder implements a {

        /* JADX INFO: renamed from: d4.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IGetInstallReferrerService.java */
        private static class C0539a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f24449a;

            C0539a(IBinder iBinder) {
                this.f24449a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24449a;
            }

            @Override // d4.a
            public Bundle c(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    this.f24449a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static a o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0539a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }

    Bundle c(Bundle bundle) throws RemoteException;
}
