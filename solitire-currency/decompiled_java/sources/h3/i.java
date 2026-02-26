package h3;

import c3.a;
import k2.b2;
import k2.o1;

/* JADX INFO: compiled from: Id3Frame.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f26451a;

    public i(String str) {
        this.f26451a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // c3.a.b
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return c3.b.a(this);
    }

    @Override // c3.a.b
    public /* synthetic */ o1 getWrappedMetadataFormat() {
        return c3.b.b(this);
    }

    @Override // c3.a.b
    public /* synthetic */ void i(b2.b bVar) {
        c3.b.c(this, bVar);
    }

    public String toString() {
        return this.f26451a;
    }
}
