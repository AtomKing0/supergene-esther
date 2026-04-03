package n3;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: CueEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public byte[] a(List<b> list) {
        ArrayList<Bundle> arrayListD = a4.c.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListD);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
