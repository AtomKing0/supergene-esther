package b;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: IResultReceiver.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface a extends IInterface {
    public static final String M7 = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* JADX INFO: compiled from: IResultReceiver.java */
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

    void g(int i10, Bundle bundle) throws RemoteException;

    /* JADX INFO: renamed from: b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IResultReceiver.java */
    public static abstract class AbstractBinderC0144a extends Binder implements a {

        /* JADX INFO: renamed from: b.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IResultReceiver.java */
        private static class C0145a implements a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f1803a;

            C0145a(IBinder iBinder) {
                this.f1803a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f1803a;
            }

            @Override // b.a
            public void g(int i10, Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(a.M7);
                    parcelObtain.writeInt(i10);
                    b.d(parcelObtain, bundle, 0);
                    this.f1803a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }

        public AbstractBinderC0144a() {
            attachInterface(this, a.M7);
        }

        public static a o(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.M7);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0145a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = a.M7;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            g(parcel.readInt(), (Bundle) b.c(parcel, Bundle.CREATOR));
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
