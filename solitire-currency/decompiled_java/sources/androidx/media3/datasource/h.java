package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import com.king.amp.sa.AbmAdPlayer;
import e5.p;

/* JADX INFO: compiled from: HttpDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h {
    static {
        p<String> pVar = HttpDataSource.REJECT_PAYWALL_TYPES;
    }

    public static /* synthetic */ boolean a(String str) {
        if (str == null) {
            return false;
        }
        String strE = e5.c.e(str);
        if (TextUtils.isEmpty(strE)) {
            return false;
        }
        return ((strE.contains("text") && !strE.contains(MimeTypes.TEXT_VTT)) || strE.contains(AbmAdPlayer.HTML) || strE.contains("xml")) ? false : true;
    }
}
