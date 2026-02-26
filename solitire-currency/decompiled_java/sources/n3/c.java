package n3;

import android.os.Bundle;
import android.os.Parcel;
import com.google.common.collect.y;
import java.util.ArrayList;

/* JADX INFO: compiled from: CueDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public y<b> a(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return a4.c.b(b.f31622s, (ArrayList) a4.a.e(bundle.getParcelableArrayList("c")));
    }
}
