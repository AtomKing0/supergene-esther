package fb;

import android.util.JsonToken;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f25777a;

    static {
        int[] iArr = new int[JsonToken.values().length];
        f25777a = iArr;
        iArr[JsonToken.NUMBER.ordinal()] = 1;
        iArr[JsonToken.BOOLEAN.ordinal()] = 2;
        iArr[JsonToken.STRING.ordinal()] = 3;
    }
}
