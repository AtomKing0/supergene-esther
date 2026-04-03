package z1;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: CreationContext.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class h {
    public static h a(Context context, i2.a aVar, i2.a aVar2, String str) {
        return new c(context, aVar, aVar2, str);
    }

    public abstract Context b();

    @NonNull
    public abstract String c();

    public abstract i2.a d();

    public abstract i2.a e();
}
