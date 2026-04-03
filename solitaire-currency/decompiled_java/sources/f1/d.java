package f1;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import r0.k;
import u0.v;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements k<c> {
    @Override // r0.k
    @NonNull
    public r0.c b(@NonNull r0.h hVar) {
        return r0.c.SOURCE;
    }

    @Override // r0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull v<c> vVar, @NonNull File file, @NonNull r0.h hVar) throws Throwable {
        try {
            o1.a.e(vVar.get().c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            }
            return false;
        }
    }
}
