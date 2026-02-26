package k2;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.common.collect.y;
import java.util.List;

/* JADX INFO: compiled from: BundleListRetriever.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends Binder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f29116b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.common.collect.y<Bundle> f29117a;

    static {
        f29116b = a4.o0.f214a >= 30 ? IBinder.getSuggestedMaxIpcSizeBytes() : 65536;
    }

    public g(List<Bundle> list) {
        this.f29117a = com.google.common.collect.y.m(list);
    }

    public static com.google.common.collect.y<Bundle> a(IBinder iBinder) {
        int i10;
        y.a aVarK = com.google.common.collect.y.k();
        int i11 = 0;
        int i12 = 1;
        while (i12 != 0) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInt(i11);
                try {
                    iBinder.transact(1, parcelObtain, parcelObtain2, 0);
                    while (true) {
                        i10 = parcelObtain2.readInt();
                        if (i10 == 1) {
                            aVarK.a((Bundle) a4.a.e(parcelObtain2.readBundle()));
                            i11++;
                        }
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    i12 = i10;
                } catch (RemoteException e10) {
                    throw new RuntimeException(e10);
                }
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th;
            }
        }
        return aVarK.k();
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i10, Parcel parcel, @Nullable Parcel parcel2, int i11) throws RemoteException {
        if (i10 != 1) {
            return super.onTransact(i10, parcel, parcel2, i11);
        }
        if (parcel2 == null) {
            return false;
        }
        int size = this.f29117a.size();
        int i12 = parcel.readInt();
        while (i12 < size && parcel2.dataSize() < f29116b) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.f29117a.get(i12));
            i12++;
        }
        parcel2.writeInt(i12 < size ? 2 : 0);
        return true;
    }
}
