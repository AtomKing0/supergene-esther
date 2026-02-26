package b;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import b.a;

/* JADX INFO: compiled from: ResultReceiver.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f1804a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Handler f1805b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    b.a f1806c;

    /* JADX INFO: compiled from: ResultReceiver.java */
    class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i10) {
            return new b[i10];
        }
    }

    /* JADX INFO: renamed from: b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ResultReceiver.java */
    class BinderC0146b extends a.AbstractBinderC0144a {
        BinderC0146b() {
        }

        @Override // b.a
        public void g(int i10, Bundle bundle) {
            b bVar = b.this;
            Handler handler = bVar.f1805b;
            if (handler != null) {
                handler.post(bVar.new c(i10, bundle));
            } else {
                bVar.a(i10, bundle);
            }
        }
    }

    /* JADX INFO: compiled from: ResultReceiver.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bundle f1809b;

        c(int i10, Bundle bundle) {
            this.f1808a = i10;
            this.f1809b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f1808a, this.f1809b);
        }
    }

    b(Parcel parcel) {
        this.f1806c = a.AbstractBinderC0144a.o(parcel.readStrongBinder());
    }

    public void b(int i10, Bundle bundle) {
        if (this.f1804a) {
            Handler handler = this.f1805b;
            if (handler != null) {
                handler.post(new c(i10, bundle));
                return;
            } else {
                a(i10, bundle);
                return;
            }
        }
        b.a aVar = this.f1806c;
        if (aVar != null) {
            try {
                aVar.g(i10, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i10) {
        synchronized (this) {
            if (this.f1806c == null) {
                this.f1806c = new BinderC0146b();
            }
            parcel.writeStrongBinder(this.f1806c.asBinder());
        }
    }

    protected void a(int i10, Bundle bundle) {
    }
}
