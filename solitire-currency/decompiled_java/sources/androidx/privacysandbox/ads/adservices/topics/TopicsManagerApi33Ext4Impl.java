package androidx.privacysandbox.ads.adservices.topics;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.media3.common.PlaybackException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TopicsManagerApi33Ext4Impl.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresExtension(extension = PlaybackException.CUSTOM_ERROR_CODE_BASE, version = 4)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class TopicsManagerApi33Ext4Impl extends TopicsManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public TopicsManagerApi33Ext4Impl(@NotNull Context context) {
        t.i(context, "context");
        Object systemService = context.getSystemService((Class<Object>) android.adservices.topics.TopicsManager.class);
        t.h(systemService, "context.getSystemService…opicsManager::class.java)");
        super((android.adservices.topics.TopicsManager) systemService);
    }
}
