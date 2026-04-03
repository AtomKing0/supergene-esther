package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.common.util.concurrent.m;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public interface ProgressUpdater {
    @NonNull
    m<Void> updateProgress(@NonNull Context context, @NonNull UUID uuid, @NonNull Data data);
}
