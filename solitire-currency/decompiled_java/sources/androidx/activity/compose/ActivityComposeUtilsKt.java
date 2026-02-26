package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: ActivityComposeUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityComposeUtilsKt {
    public static final /* synthetic */ <T> T findOwner(Context context) {
        for (Object obj = context; obj instanceof ContextWrapper; obj = (T) ((ContextWrapper) obj).getBaseContext()) {
            t.o(3, "T");
            if (obj instanceof Object) {
                return (T) obj;
            }
        }
        return null;
    }
}
