package androidx.browser.trusted;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;

/* JADX INFO: compiled from: TrustedWebActivityDisplayMode.java */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m {
    @NonNull
    public static TrustedWebActivityDisplayMode a(@NonNull Bundle bundle) {
        return bundle.getInt(TrustedWebActivityDisplayMode.KEY_ID) != 1 ? new TrustedWebActivityDisplayMode.DefaultMode() : TrustedWebActivityDisplayMode.ImmersiveMode.fromBundle(bundle);
    }
}
