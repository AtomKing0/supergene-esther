package u5;

import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: HeartBeatResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class r {
    public static r a(String str, List<String> list) {
        return new a(str, list);
    }

    public abstract List<String> b();

    public abstract String c();
}
