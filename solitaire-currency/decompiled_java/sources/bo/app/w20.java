package bo.app;

import com.braze.enums.inappmessage.MessageType;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class w20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4163a;

    static {
        int[] iArr = new int[MessageType.values().length];
        try {
            iArr[MessageType.FULL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr[MessageType.MODAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr[MessageType.SLIDEUP.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr[MessageType.HTML_FULL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr[MessageType.HTML.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f4163a = iArr;
    }
}
