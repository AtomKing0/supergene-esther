package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;

/* JADX INFO: loaded from: classes.dex */
public interface EngagementSignalsCallback {
    void onGreatestScrollPercentageIncreased(@IntRange(from = 1, to = AndroidComposeViewAccessibilityDelegateCompat.SendRecurringAccessibilityEventsIntervalMillis) int i10, @NonNull Bundle bundle);

    void onSessionEnded(boolean z10, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z10, @NonNull Bundle bundle);
}
