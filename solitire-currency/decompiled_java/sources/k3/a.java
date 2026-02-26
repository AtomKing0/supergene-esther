package k3;

import android.os.Parcel;
import android.os.Parcelable;
import f3.b;

/* JADX INFO: compiled from: VorbisComment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    public static final Parcelable.Creator<a> CREATOR = new C0601a();

    /* JADX INFO: renamed from: k3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VorbisComment.java */
    class C0601a implements Parcelable.Creator<a> {
        C0601a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i10) {
            return new a[i10];
        }
    }

    public a(String str, String str2) {
        super(str, str2);
    }

    a(Parcel parcel) {
        super(parcel);
    }
}
