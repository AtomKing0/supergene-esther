package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.StringUtils;
import io.sentry.protocol.SentrySpan;
import java.util.EnumSet;
import kotlin.collections.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class la0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3321a;

    public la0(Context context, String userId, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(userId, "userId");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.sdk_metadata_cache" + StringUtils.getCacheFileSuffix(context, userId, apiKey), 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…y), Context.MODE_PRIVATE)");
        this.f3321a = sharedPreferences;
    }

    public final void a(EnumSet sdkMetadata) {
        kotlin.jvm.internal.t.i(sdkMetadata, "sdkMetadata");
        this.f3321a.edit().putStringSet(SentrySpan.JsonKeys.TAGS, com.braze.support.e.a(sdkMetadata)).apply();
    }

    public final EnumSet b(EnumSet newSdkMetadata) {
        kotlin.jvm.internal.t.i(newSdkMetadata, "newSdkMetadata");
        if (kotlin.jvm.internal.t.d(com.braze.support.e.a(newSdkMetadata), this.f3321a.getStringSet(SentrySpan.JsonKeys.TAGS, z0.e()))) {
            return null;
        }
        return newSdkMetadata;
    }
}
